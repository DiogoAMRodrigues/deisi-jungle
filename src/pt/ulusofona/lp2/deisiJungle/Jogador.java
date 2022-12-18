package pt.ulusofona.lp2.deisiJungle;
import pt.ulusofona.lp2.deisiJungle.Food.Food;
import pt.ulusofona.lp2.deisiJungle.Species.Especie;

import java.util.ArrayList;

public class Jogador {
    private final int id;
    private final String name;
    private final Especie species;
    private int position;
    private int energy;
    protected boolean hasEatenBanana;

    public Jogador(int id, String name, Especie species) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.position = 0;
        energy = species.getStartEnergy();
        hasEatenBanana = false;
    }

    public boolean getHasEatenBanana() {
        return hasEatenBanana;
    }

    public void eatBanana(){
        hasEatenBanana = true;
    }

    public void gainEnergy(int amount){
        if(this.energy + amount >= 200){
            this.energy = 200;
        }else{
            this.energy += amount;
        }
    }

    public void gainEnergyResting(){
        int amount = this.getSpecies().getEnergyGain();
        if(this.energy + amount >= 200){
            this.energy = 200;
        }else{
            this.energy += amount;
        }
    }

    public void loseEnergy(int amount){
        if (this.energy >= amount){
            this.energy -= amount;
        }else{
            this.energy = 0;
        }
    }

    public boolean loseEnergyMovement(){
        int amount = this.getSpecies().getEnergyConsumption();
        if(this.energy >= amount){
            this.energy -= amount;
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Especie getSpecies() {
        return species;
    }

    public int getPosition() {
        return position;
    }

    public int getEnergy() {
        return energy;
    }


    public MovementResult theMovementPart(Tabuleiro tabuleiro, int nrSquares, boolean byPassValidations)  {
        MovementResult theResult = new MovementResult(MovementResultCode.VALID_MOVEMENT,"");
        Especie mySpecies = this.species;
        boolean hasEaten = false;
        String tooltip = "";
        //Refuse to let em move if there is already a winner
        if (!tabuleiro.getWinner()){
            //Is position in board if not go to last postion
            int moveToPos = this.position + nrSquares;
            if (moveToPos >= tabuleiro.getSize()){
                moveToPos = tabuleiro.getSize() - 1;
            }
            //Goes behind first house
            if (moveToPos < 0){
                theResult = new MovementResult(MovementResultCode.INVALID_MOVEMENT, "Illegal move behind");
                return theResult;
            }
            //Check if the movementspeed is legal
            if (!byPassValidations) {
                if (!(mySpecies.getMinSpeed() <= Math.abs(nrSquares) && mySpecies.getMaxSpeed() >= Math.abs(nrSquares))) {
                    theResult = new MovementResult(MovementResultCode.INVALID_MOVEMENT, "Illegal movementSpeed");
                    return theResult;
                }
            }
            //Check energy I need for this House
            int amountOfEnergyRequired = mySpecies.getEnergyConsumption();
            ArrayList<Food> thisHousesFood = tabuleiro.getCasas()[moveToPos].getComida();
            for (int i = 0; i < thisHousesFood.size(); i++){
                amountOfEnergyRequired += thisHousesFood.get(i).getEatenSim(this, tabuleiro.getTurns());
            }
            //Current energy needs to be bigger than energy usage while move
            if (this.energy <= amountOfEnergyRequired){
                theResult = new MovementResult(MovementResultCode.NO_ENERGY, "Not enough energy");
                return theResult;
            }
            //If he moves do this
            if (nrSquares != 0){
                Casa myHouse = tabuleiro.getCasas()[this.position];
                myHouse.leaveHouse(this);

                //Add to other house
                Casa moveToHouse = tabuleiro.getCasas()[moveToPos];
                moveToHouse.addJogadorCasa(this);
                position = moveToPos;

                //Lose energy
                loseEnergyMovement();
                for (int i = 0; i < thisHousesFood.size(); i++){
                    hasEaten = true;
                    tooltip += thisHousesFood.get(i).getEaten(tabuleiro);
                }
                //Check if he won
                if (moveToPos == tabuleiro.getSize() - 1){
                    tabuleiro.winGame();
                    tabuleiro.setPlayerWin(this);
                }
            }else {
                gainEnergyResting();
                for (int i = 0; i < thisHousesFood.size(); i++){
                    hasEaten = true;
                    tooltip += thisHousesFood.get(i).getEaten(tabuleiro);
                }
            }
        }
        if (hasEaten){
            return new MovementResult(MovementResultCode.CAUGHT_FOOD, tooltip);
        }
        return new MovementResult(MovementResultCode.VALID_MOVEMENT, "Worked");
    }
}
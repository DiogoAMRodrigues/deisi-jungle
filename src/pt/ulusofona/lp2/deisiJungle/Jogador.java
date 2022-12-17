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

    public void setPosition(int position) {
        this.position = position;
    }

    public int getEnergy() {
        return energy;
    }


    public MovementResult theMovementPart(Tabuleiro tabuleiro, int nrSquares, boolean byPassValidations)  {
        MovementResult theResult = new MovementResult(MovementResultCode.VALID_MOVEMENT,"");
        Especie mySpecies = this.species;
        //Refuse to let em move if there is already a winner
        if (tabuleiro.getPlayerWin() == null){
            //Is position in board if not go to last postion
            int moveToPos = this.position += nrSquares;
            if (moveToPos >= tabuleiro.getSize()){
                moveToPos = tabuleiro.getSize();
            }
            //Check if the movementspeed is legal
            if (!(mySpecies.getMinSpeed() <= nrSquares && mySpecies.getMaxSpeed() >= nrSquares)){
                theResult = new MovementResult(MovementResultCode.INVALID_MOVEMENT, "Illegal movementSpeed");
                return theResult;
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




        }
        /*
        //everythingsFine
        int playersPosition = this.getPosition();
        Casa thisHouse = tabuleiro.getCasas()[playersPosition];
        //remove him from that House and update the occupationState of that house IF he has energy
        if (this.getEnergy() - 2 >= 0) {
            this.loseEnergy();
            thisHouse.getJogadores().remove(this);
            if (thisHouse.isOccupied()){
                thisHouse.occupy();
            }
            //add him to the other house
            int otherHousePosition = playersPosition + nrSquares;
            int lastHousePosition = tabuleiro.getCasas().length - 1;
            //IF it is over the ending it stops at the end
            if (otherHousePosition >= lastHousePosition) {
                Casa otherHouse = tabuleiro.getCasas()[lastHousePosition];
                otherHouse.getJogadores().add(this);
                this.setPosition(lastHousePosition);
                tabuleiro.setPlayerWin(this);
                tabuleiro.setWinner(true);
            } else {
                Casa otherHouse = tabuleiro.getCasas()[otherHousePosition];
                otherHouse.getJogadores().add(this);
                this.setPosition(otherHousePosition);
            }
        }*/

        //so it dont die
        return null;
    }
}
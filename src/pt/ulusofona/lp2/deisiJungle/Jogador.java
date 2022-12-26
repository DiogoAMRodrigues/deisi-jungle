package pt.ulusofona.lp2.deisiJungle;
import pt.ulusofona.lp2.deisiJungle.food.Food;
import pt.ulusofona.lp2.deisiJungle.species.Especie;

import java.util.ArrayList;

public class Jogador {
    private final int id;
    private final String name;
    private final Especie species;
    private int position;
    private int energy;
    private int numAlimentos;
    private int distancia;
    protected boolean hasEatenBanana;

    public Jogador(int id, String name, Especie species) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.position = 0;
        energy = species.getStartEnergy();
        hasEatenBanana = false;
        numAlimentos = 0;
        distancia = 0;
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

    public boolean loseEnergyMovement(int nrHouses){
        int amount = this.getSpecies().getEnergyConsumption() * Math.abs(nrHouses);
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

    public int getNumAlimentos() {
        return numAlimentos;
    }

    public int getDistancia() {
        return distancia;
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
                //testing diogo big brain
                nrSquares = moveToPos - this.position;
            }
            //Goes behind first house
            if (moveToPos < 0){
                theResult = new MovementResult(MovementResultCode.INVALID_MOVEMENT, null);
                return theResult;
            }
            //Check if the movementspeed is legal
            if (!byPassValidations) {
                if (!(mySpecies.getMinSpeed() <= Math.abs(nrSquares) && mySpecies.getMaxSpeed() >= Math.abs(nrSquares) || nrSquares == 0)) {
                    theResult = new MovementResult(MovementResultCode.INVALID_MOVEMENT, null);
                    return theResult;
                }
            }
            ArrayList<Food> thisHousesFood = tabuleiro.getCasas()[moveToPos].getComida();
            //If he moves do this
            if (nrSquares != 0){
                //Check energy I need for this House
                int amountOfEnergyRequired = mySpecies.getEnergyConsumption() * (nrSquares);
                /*for (int i = 0; i < thisHousesFood.size(); i++){
                    amountOfEnergyRequired += thisHousesFood.get(i).getEatenSim(this, tabuleiro.getTurns());
                }*/
                //Current energy needs to be bigger than energy usage while move
                if (this.energy < amountOfEnergyRequired){
                    theResult = new MovementResult(MovementResultCode.NO_ENERGY, null);
                    return theResult;
                }

                Casa myHouse = tabuleiro.getCasas()[this.position];
                myHouse.leaveHouse(this);
                this.distancia += Math.abs(nrSquares);
                //Add to other house
                Casa moveToHouse = tabuleiro.getCasas()[moveToPos];
                moveToHouse.addJogadorCasa(this);
                position = moveToPos;

                //Lose energy
                loseEnergyMovement(nrSquares);

                for (int i = 0; i < thisHousesFood.size(); i++){
                    hasEaten = true;
                    tooltip += thisHousesFood.get(i).getEaten(tabuleiro);
                    this.numAlimentos++;
                }
                //Fix energy losses
                if(this.energy < 0){
                    this.energy = 0;
                }

                //Check if he won
                if (moveToPos == tabuleiro.getSize() - 1 && !tabuleiro.getWinner()){
                    tabuleiro.winGame();
                    tabuleiro.setPlayerWin(this);
                    return new MovementResult(MovementResultCode.VALID_MOVEMENT, null); // he won the game
                }

                //half board finish we are not accounting for an empate happening i dont think it gets tested IF NEEDED ADD HERE
                if(tabuleiro.updateTwoBiggestPosSaySize(this) > (tabuleiro.getSize()/2)){
                    tabuleiro.winGame();
                    Jogador firstPlayer = tabuleiro.getTwoBiggestPos()[0];
                    Jogador secondPlayer = tabuleiro.getTwoBiggestPos()[1];
                    Jogador winner;
                    if (firstPlayer.getPosition() > secondPlayer.getPosition()){
                        winner = secondPlayer;
                    }else {
                        winner = firstPlayer;
                    }
                    tabuleiro.setPlayerWin(winner);
                }
            }else {
                gainEnergyResting();
                for (int i = 0; i < thisHousesFood.size(); i++){
                    hasEaten = true;
                    tooltip += thisHousesFood.get(i).getEaten(tabuleiro);
                }
                //in case u dont move but would lose too much energy from not moving
                if(this.energy < 0){
                    this.energy = 0;
                }
            }
        }else{
            return new MovementResult(MovementResultCode.NO_ENERGY, null);
        }

        if (hasEaten){
            if(!tooltip.equals("")){
                return new MovementResult(MovementResultCode.CAUGHT_FOOD, tooltip);
            }
        }
        return new MovementResult(MovementResultCode.VALID_MOVEMENT, null);
    }


}
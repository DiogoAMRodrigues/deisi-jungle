package pt.ulusofona.lp2.deisiJungle;

import pt.ulusofona.lp2.deisiJungle.Species.Especie;

public class Jogador {
    private final int id;
    private final String name;
    private final Especie species;
    private int position;
    private int energy;

    public Jogador(int id, String name, Especie species, int energy) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.position = 0;
        this.energy = energy;
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


    public void theMovementPart(Tabuleiro tabuleiro, int nrSquares)  {
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
        }
    }
}
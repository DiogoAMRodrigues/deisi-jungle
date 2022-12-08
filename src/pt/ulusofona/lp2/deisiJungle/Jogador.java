package pt.ulusofona.lp2.deisiJungle;

public class Jogador {
    private final int id;
    private final String name;
    private final Especie species;
    private int position;
    private int energy;

    public Jogador(int id, String name, Especie species) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.position = 0;
        this.energy = energy;
    }

    protected void loseEnergy(){
        if (this.energy >= 2){
            this.energy -= 2;
        }
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

    public void theMovementPart(Tabuleiro tabuleiro, int nrSquares) {
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

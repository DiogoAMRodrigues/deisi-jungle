package pt.ulusofona.lp2.deisiJungle;
import pt.ulusofona.lp2.deisiJungle.Food.Food;
import pt.ulusofona.lp2.deisiJungle.Food.Shrooms;

import java.util.ArrayList;

public class Casa {
    private final ArrayList<Shrooms.Jogador> jogadores;

    private Food comida = null;
    private boolean occupied;
    public Casa() {
        this.occupied = false;
        jogadores = new ArrayList<>();
    }
    public boolean isOccupied() {
        if (jogadores.isEmpty()) {
            return this.occupied = jogadores.size() > 0;
        }
        return false;
    }

    public void leaveHouse(Shrooms.Jogador player){
        jogadores.remove(player);
        if (jogadores.isEmpty()){
            this.occupied = false;
        }
    }
    public void addJogadorCasa(Shrooms.Jogador player){
        jogadores.add(player);
        this.occupied = true;
    }
    public ArrayList<Shrooms.Jogador> getJogadores() {
        return jogadores;
    }

    public Food getComida(){
        return comida;
    }

    public void setComida(Food comida){
        this.comida = comida;
    }

}

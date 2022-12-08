package pt.ulusofona.lp2.deisiJungle;
import java.util.ArrayList;

public class Casa {
    private ArrayList<Jogador> jogadores;
    private boolean occupied;
    public Casa() {
        this.occupied = false;
        jogadores = new ArrayList<>();
    }
    public boolean isOccupied() {
        if (jogadores != null) {
            return this.occupied = jogadores.size() > 0;
        }
        return false;
    }
    public void occupy(){
        this.occupied = true;
    }
    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

}

package pt.ulusofona.lp2.deisiJungle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Casa {
    ArrayList<Jogador> jogadores;
    boolean occupied;

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

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}

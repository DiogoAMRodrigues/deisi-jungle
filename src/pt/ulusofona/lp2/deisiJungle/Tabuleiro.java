package pt.ulusofona.lp2.deisiJungle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Tabuleiro {
    Casa[] casas;
    int size;
    ArrayList<Jogador> jogadores;
    HashMap<Integer, Jogador> jogaresHS;
    Jogador currentPlayer;
    int currentPlayerInt;

    boolean winner = false;

    Jogador playerWin;

    public Tabuleiro(int size) {
        this.size = size;
        this.casas = new Casa[size];
        for(int i = 0; i < size; ++i){
            casas[i] = new Casa();
        }
        this.jogadores = new ArrayList<>();
        this.jogaresHS = new HashMap<>();
        this.currentPlayerInt = 0;
    }

    void addJogador(Jogador player){
        jogadores.add(player);
        jogaresHS.putIfAbsent(player.getId(), player);

        jogadores.sort(Comparator.comparingInt(Jogador::getId));
    }

    void nextTurn(){
        currentPlayerInt++;
        if (currentPlayerInt >= jogadores.size()){
            currentPlayerInt = 0;
        }
        currentPlayer = jogadores.get(currentPlayerInt);
    }

    public Casa[] getCasas() {
        return casas;
    }

    public int getSize() {
        return size;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public Jogador getCurrentPlayer() {
        return currentPlayer;
    }

    public HashMap<Integer, Jogador> getJogaresHS() {
        return jogaresHS;
    }

}

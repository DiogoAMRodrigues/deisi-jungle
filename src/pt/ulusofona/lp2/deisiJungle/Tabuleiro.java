package pt.ulusofona.lp2.deisiJungle;

import java.util.ArrayList;
import java.util.HashMap;

public class Tabuleiro {
    Casa[] casas;
    int size;
    ArrayList<Jogador> jogadores;
    HashMap<Integer, Jogador> jogaresHS;
    Jogador currentPlayer;
    int currentPlayerInt;

    public Tabuleiro(int size) {
        this.size = size;
        casas = new Casa[size];
        jogadores = new ArrayList<>();
        jogaresHS = new HashMap<>();
        currentPlayerInt = 0;
    }

    void addJogador(Jogador player){
        jogadores.add(player);
        jogaresHS.putIfAbsent(player.getId(), player);
        for (int i = 0; i < jogadores.size() - 1; i++ ){
            Jogador firstPlayer = jogadores.get(i);
            for (int j = 0; j < jogadores.size(); j++){
                Jogador secondPlayer = jogadores.get(j);
                if (firstPlayer.getId() > secondPlayer.getId()){
                    jogadores.set(i, secondPlayer);
                    jogadores.set(j, firstPlayer);
                }
            }
        }
    }

    void nextTurn(){
        currentPlayerInt++;
        if (currentPlayerInt >= size){
            currentPlayerInt -= size;
        }
        currentPlayer = jogadores.get(currentPlayerInt);
    }

    public Casa[] getCasas() {
        return casas;
    }

    public void setCasas(Casa[] tabuleiro) {
        this.casas = tabuleiro;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public Jogador getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Jogador currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getCurrentPlayerInt() {
        return currentPlayerInt;
    }

    public void setCurrentPlayerInt(int currentPlayerInt) {
        this.currentPlayerInt = currentPlayerInt;
    }
}

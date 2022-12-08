package pt.ulusofona.lp2.deisiJungle;

import pt.ulusofona.lp2.deisiJungle.Food.Shrooms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Tabuleiro {
    private final Casa[] casas;
    private final int size;
    private final ArrayList<Shrooms.Jogador> jogadores;
    private final HashMap<Integer, Shrooms.Jogador> jogaresHS;
    private Shrooms.Jogador currentPlayer;
    private int currentPlayerInt;
    private boolean winner = false;
    private Shrooms.Jogador playerWin;
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

    public void addJogador(Shrooms.Jogador player){
        jogadores.add(player);
        jogaresHS.putIfAbsent(player.getId(), player);

        jogadores.sort(Comparator.comparingInt(Shrooms.Jogador::getId));
    }

    public void nextTurn(){
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

    public ArrayList<Shrooms.Jogador> getJogadores() {
        return jogadores;
    }

    public void setCurrentPlayer(Shrooms.Jogador jogador){
        this.currentPlayer = jogador;
    }

    public Shrooms.Jogador getCurrentPlayer() {
        return currentPlayer;
    }

    public HashMap<Integer, Shrooms.Jogador> getJogaresHS() {
        return jogaresHS;
    }

    public boolean getWinner(){
        return winner;
    }
    public void setWinner(boolean win){
        this.winner = win;
    }

    public Shrooms.Jogador getPlayerWin(){
        return playerWin;
    }

    public void setPlayerWin(Shrooms.Jogador jogador){
        this.playerWin = jogador;
    }

}

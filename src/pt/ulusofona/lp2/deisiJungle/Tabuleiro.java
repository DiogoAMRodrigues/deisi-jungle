package pt.ulusofona.lp2.deisiJungle;

import pt.ulusofona.lp2.deisiJungle.Food.Shrooms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Tabuleiro {
    private final Casa[] casas;
    private final int size;
    private final ArrayList<Jogador> jogadores;
    private final HashMap<Integer, Jogador> jogaresHS;
    private Jogador currentPlayer;
    private int currentPlayerInt;
    private boolean winner = false;
    private Jogador playerWin;
    private int turns;
    public Tabuleiro(int size) {
        this.size = size;
        casas = new Casa[size];
        for(int i = 0; i < size; ++i){
            casas[i] = new Casa();
        }
        jogadores = new ArrayList<>();
        jogaresHS = new HashMap<>();
        currentPlayerInt = 0;
        turns = 1;
    }

    public void addJogador(Jogador player){
        jogadores.add(player);
        jogaresHS.putIfAbsent(player.getId(), player);

        jogadores.sort(Comparator.comparingInt(Jogador::getId));
    }

    public void nextTurn(){
        currentPlayerInt++;
        if (currentPlayerInt >= jogadores.size()){
            currentPlayerInt = 0;
        }
        currentPlayer = jogadores.get(currentPlayerInt);
        turns++;
    }

    public int getTurns() {
        return turns;
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

    public void setCurrentPlayer(Jogador jogador){
        this.currentPlayer = jogador;
    }

    public Jogador getCurrentPlayer() {
        return currentPlayer;
    }

    public HashMap<Integer, Jogador> getJogaresHS() {
        return jogaresHS;
    }

    public boolean getWinner(){
        return winner;
    }
    public void setWinner(boolean win){
        this.winner = win;
    }

    public Jogador getPlayerWin(){
        return playerWin;
    }

    public void setPlayerWin(Jogador jogador){
        this.playerWin = jogador;
    }

}

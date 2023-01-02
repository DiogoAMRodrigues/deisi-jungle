package pt.ulusofona.lp2.deisiJungle;

import java.util.ArrayList;
import java.util.Arrays;
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
    private ArrayList<Jogador> twoBiggestPos;
    public Tabuleiro(int size) {
        this.size = size;
        casas = new Casa[size];
        for(int i = 0; i < size; ++i){
            casas[i] = new Casa();
        }
        jogadores = new ArrayList<>();
        jogaresHS = new HashMap<>();
        currentPlayerInt = 0;
        turns = 0;
        twoBiggestPos = new ArrayList<>();
    }

    public void addJogador(Jogador player){
        jogadores.add(player);
        jogaresHS.put(player.getId(), player);
        jogadores.sort(Comparator.comparingInt(Jogador::getId));
    }

    public void nextTurn(){
        turns++;
        currentPlayerInt++;
        if (currentPlayerInt >= jogadores.size()){
            currentPlayerInt = 0;
        }
        currentPlayer = jogadores.get(currentPlayerInt);
    }

    public int getTurns() {
        return turns;
    }

    public void setTurn(int num){
        this.turns = num;
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

    public void winGame(){
        winner = true;
    }

    public Jogador getPlayerWin(){
        return playerWin;
    }

    public void setPlayerWin(Jogador jogador){
        this.playerWin = jogador;
    }

    public ArrayList<Jogador> getTwoBiggestPos() {
        return twoBiggestPos;
    }

    public void decreaseTurn(){
        this.turns--;
    }

    public int updateTwoBiggestPosSaySize() {
        Jogador[] players = new Jogador[jogadores.size()];
        twoBiggestPos = jogadores;
        for (int i = 0; i < twoBiggestPos.size(); i++){
            players[i] = twoBiggestPos.get(i);
        }
        for (int i = 0; i < players.length - 1; i++){
            for (int j = i + 1; j < players.length; j++){
                if (players[i].getPosition() < players[j].getPosition()){
                    Jogador placeHolder = players[i];
                    players[i] = players[j];
                    players[j] = placeHolder;
                }else if(players[i].getId() > players[j].getId()){
                    Jogador placeHolder = players[i];
                    players[i] = players[j];
                    players[j] = placeHolder;
                }

            }
        }
        twoBiggestPos = new ArrayList<>();
        twoBiggestPos.addAll(Arrays.asList(players));

        return twoBiggestPos.get(0).getPosition() - twoBiggestPos.get(1).getPosition();
    }
}
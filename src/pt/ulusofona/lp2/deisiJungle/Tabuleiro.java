package pt.ulusofona.lp2.deisiJungle;

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
    private Jogador[] twoBiggestPos;
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
        twoBiggestPos = new Jogador[2];
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

    public void winGame(){
        winner = true;
    }

    public Jogador getPlayerWin(){
        return playerWin;
    }

    public void setPlayerWin(Jogador jogador){
        this.playerWin = jogador;
    }

    public Jogador[] getTwoBiggestPos() {
        return twoBiggestPos;
    }

    public int updateTwoBiggestPosSaySize(Jogador thisPlayer) {
        if(twoBiggestPos[0] == null) {
            twoBiggestPos[0] = thisPlayer;
            return 0;
        } else if(twoBiggestPos[1] == null){
            twoBiggestPos[1] = thisPlayer;
            return 0;
        }else{
            if ((twoBiggestPos[0].getPosition() < thisPlayer.getPosition()) && (twoBiggestPos[1].getId() != thisPlayer.getId())) {
                twoBiggestPos[0] = thisPlayer;
            }else if((twoBiggestPos[1].getPosition() < thisPlayer.getPosition()) && (twoBiggestPos[0].getId() != thisPlayer.getId())){
                twoBiggestPos[1] = thisPlayer;
            }
        }
        return Math.abs(twoBiggestPos[0].getPosition() - twoBiggestPos[1].getPosition());
    }
}

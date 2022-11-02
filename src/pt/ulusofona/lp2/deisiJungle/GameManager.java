package pt.ulusofona.lp2.deisiJungle;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class GameManager {
    Tabuleiro tabuleiro;
    public GameManager() {
    }

    public String[][] getSpecies() {
        String[][] species = new String[6][3];
        species[0][0] = "E";
        species[0][1] = "Elefante";
        species[0][2] = "elephant.png";
        species[1][0] = "L";
        species[1][1] = "Leão";
        species[1][2] = "lion.png";
        species[2][0] = "T";
        species[2][1] = "Tartaruga";
        species[2][2] = "turtle.png";
        species[3][0] = "P";
        species[3][1] = "Passáro";
        species[3][2] = "bird.png";
        species[4][0] = "Z";
        species[4][1] = "Tarzan";
        species[4][2] = "tarzan.png";
        species[5][0] = "S";
        species[5][1] = "Cobra";
        species[5][2] = "snake.png";

        return species;
    }

    public boolean createInitialJungle(int jungleSize, int initialEnergy, String[][] playersInfo){
        //assuming the start and finishlines count for the amount of houses
        int id = 0;
        int name = 1;
        int species = 2;
        boolean hasTarzan = false;

        //Creating tabuleiro
        tabuleiro = new Tabuleiro(jungleSize);

        if (playersInfo != null) {
            //Player amount check
            if (playersInfo.length < 2 || playersInfo.length > 4) {
                return false;
            }

            //Tabuleiro size check
            if (jungleSize < playersInfo.length * 2) {
                return false;
            }

            for (int player1 = 0; player1 < playersInfo.length; player1++) {
                if (playersInfo[player1] != null) {

                    //name is well-made
                    String thisName = playersInfo[player1][name];
                    if (thisName == null || thisName.length() == 0) {
                        return false;
                    }

                    //only 1 of the 2 needed
                    //is an eligible Species
                    String thisSpecies = playersInfo[player1][species];
                    if (!(thisSpecies.equals("E") || thisSpecies.equals("L") ||
                            thisSpecies.equals("P") || thisSpecies.equals("Z") || thisSpecies.equals("S"))) {
                        if (thisSpecies.equals("T") && !hasTarzan) {
                            hasTarzan = true;
                        } else {
                            return false;
                        }
                    }

                    /*
                    boolean isEligibleSpecies = false;
                    for (int i = 0; i < getSpecies().length; i++){
                        if (thisSpecies.equals(getSpecies()[i][id])){
                            if (thisSpecies.equals("T") && !hasTarzan){
                                hasTarzan = true;
                            }else {
                                return false;
                            }
                            isEligibleSpecies = true;
                        }
                    }
                    if (!isEligibleSpecies){
                        return false;
                    }
                    */

                    //no repeated ID's
                    for (int player2 = player1 + 1; player2 < playersInfo.length; player2++) {
                        String firstPlayerID = playersInfo[player1][id];
                        String secondPlayerID = playersInfo[player2][id];
                        if (firstPlayerID.equals(secondPlayerID)) {
                            return false;
                        }
                        //Check if the ID is an Integer
                        try {
                            Integer.parseInt(firstPlayerID);
                            Integer.parseInt(secondPlayerID);
                        }catch (NumberFormatException n) {
                            return false;
                        }
                    }

                    //Adding the Player into the Tabuleiro
                    Jogador thisPlayerObject = new Jogador(Integer.parseInt(playersInfo[player1][0]), thisName, new Especie(thisSpecies.charAt(0)),
                            initialEnergy);
                    tabuleiro.addJogador(thisPlayerObject);
                    tabuleiro.casas[0].jogadores.add(thisPlayerObject);
                }else{
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }


    //UNDONE
    public int[] getPlayerIds(int squareNr){
        int[] playerIDs;
        if (tabuleiro != null){
            int convertedSquare = squareNr - 1;
            if (!(convertedSquare > tabuleiro.getSize() || convertedSquare < 0) && tabuleiro.getCasas()[convertedSquare] != null) {
                int amountOfPlayersInSquare = tabuleiro.getCasas()[convertedSquare].getJogadores().size();
                playerIDs = new int[amountOfPlayersInSquare];
                for (int i = 0; i < amountOfPlayersInSquare; i++) {
                    int thisPlayersID = tabuleiro.getCasas()[convertedSquare].getJogadores().get(i).getId();
                    playerIDs[i] = thisPlayersID;
                }
                return playerIDs;
            }
        }
        playerIDs = new int[0];
        return playerIDs;
    }

    //UNDONE
    public String[] getSquareInfo(int squareNr){
        int convertedSquare = squareNr - 1;
        String[] casa = new String[3];
        if (tabuleiro != null){
            if (convertedSquare < 0 || tabuleiro.getSize() < convertedSquare){
                return null;
            }
            if (convertedSquare == tabuleiro.getSize()){
                casa[0] = "finish.png";
                casa[1] = "Meta";
            } else {
                casa[0] = "blank.png";
                casa[1] = "Vazio";
            }
            casa[2] = "";
            for (int i = 0; i < getPlayerIds(squareNr).length - 1; i++) {
                casa[2] += getPlayerIds(squareNr)[i] + ",";
            }
            casa[2] += getPlayerIds(squareNr)[getPlayerIds(squareNr).length - 1];
        }

        return casa;
    }

    //UNDONE
    public String[] getPlayerInfo(int playerId){
        String[] playerInfo = new String[4];
        //getTabuleiro to use HS to get player
        return playerInfo;
    }

    //UNDONE
    public String[] getCurrentPlayerInfo(){
        String[] thisPlayer = new String[4];
        thisPlayer[0] = tabuleiro.getCurrentPlayer().getId() + "";
        thisPlayer[1] = tabuleiro.getCurrentPlayer().getName();
        thisPlayer[2] = tabuleiro.getCurrentPlayer().getSpecies().getIdentifier() + "";
        thisPlayer[3] = tabuleiro.getCurrentPlayer().getEnergy() + "";
        return thisPlayer;
    }

    //UNDONE
    public String[][] getPlayersInfo(){
        return null;
    }

    //UNDONE
    public boolean moveCurrentPlayer(int nrSquares, boolean bypassValidations){
        if (!bypassValidations){
            if (nrSquares > 0 && nrSquares <= 6){
                theMovementPart(nrSquares);
            }else {
                return false;
            }
        }else {
            theMovementPart(nrSquares);
        }
        tabuleiro.nextTurn();
        return true;
    }
    void theMovementPart(int nrSquares){
        //everythingsFine
        Jogador thisPlayer = tabuleiro.getCurrentPlayer();
        int playersPosition = thisPlayer.getPosition();
        Casa thisHouse = tabuleiro.getCasas()[playersPosition];
        //remove him from that House and update the occupationState of that house IF he has energy
        if (!thisPlayer.isOutOfEnergy()) {
            thisHouse.getJogadores().remove(thisPlayer);
            thisHouse.occupied = thisHouse.isOccupied();
            //add him to the other house
            int otherHousePosition = playersPosition + nrSquares;
            int lastHousePosition = tabuleiro.getCasas().length - 1;
            //IF it is over the ending it stops at the end
            if (otherHousePosition > lastHousePosition){
                Casa otherHouse = tabuleiro.getCasas()[lastHousePosition];
                otherHouse.getJogadores().add(thisPlayer);
                thisPlayer.setPosition(lastHousePosition);
            }else {
                Casa otherHouse = tabuleiro.getCasas()[otherHousePosition];
                otherHouse.getJogadores().add(thisPlayer);
                thisPlayer.setPosition(otherHousePosition);
            }
        }
    }
    //UNDONE
    public String[] getWinnerInfo(){
        return null;
    }

    //UNDONE
    public ArrayList<String> getGameResults(){
        return null;
    }

    //UNDONE
    public JPanel getAuthorsPanel(){
        return null;
    }

    //UNDONE
    public String whoIsTaborda(){
        return null;
    }

}

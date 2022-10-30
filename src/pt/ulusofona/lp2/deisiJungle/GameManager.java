package pt.ulusofona.lp2.deisiJungle;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
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

        if (playersInfo != null) {
            //Player amount check
            if (playersInfo.length < 2 || playersInfo.length > 4) {
                return false;
            }

            //Tabuleiro size check
            if (jungleSize < playersInfo.length * 2) {
                return false;
            }

            for (int player1 = 0; player1 < playersInfo.length - 1; player1++) {
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
        int[] playerIDs = new int[4];
        for (int i = 0; tabuleiro.getJogadores())
        return playerIDs;
    }

    //UNDONE
    public String[] getSquareInfo(int squareNr){
        String[] casa = new String[3];
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
        return thisPlayer;
    }

    //UNDONE
    public String[][] getPlayersInfo(){
        return null;
    }

    //UNDONE
    public boolean moveCurrentPlayer(int nrSquares, boolean bypassValidations){
        return false;
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

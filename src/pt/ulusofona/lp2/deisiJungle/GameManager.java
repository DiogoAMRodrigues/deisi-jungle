package pt.ulusofona.lp2.deisiJungle;

import java.lang.reflect.Array;

public class GameManager {
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

            for (int player1 = 0; player1 < playersInfo.length - 1; player1++) {
                if (playersInfo[player1] != null) {
                    //name is well made
                    String thisName = playersInfo[player1][name];
                    if (thisName == null || thisName.length() == 0) {
                        return false;
                    }

                    //Only 1 of the 2 options is needed
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
                    }
                }

                //Player amount check
                if (playersInfo.length < 2 || playersInfo.length > 4) {
                    return false;
                }

                //Tabuleiro size check
                if (jungleSize < playersInfo.length * 2) {
                    return false;
                }
            }
        }
        return true;
    }

    //UNDONE
    public int[] getPlayerIds(int squareNr){
        int[] playerIDs = new int[4];
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

    public String[] getCurrentPlayerInfo(){
        String[] thisPlayer = new String[4];
        return thisPlayer;
    }

    public String[][] getPlayersInfo(){
        return null;
    }

    public boolean moveCurrentPlayer(int nrSquares, boolean bypassValidations){

    }

    public String[] getWinnerInfo(){
        return null;
    }

    public ArrayList<String> getGameResults(){
        return null;
    }

    public JPanel getAuthorsPanel(){
        return null;
    }

    public String whoIsTaborda(){
        return null;
    }

}

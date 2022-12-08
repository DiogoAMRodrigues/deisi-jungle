package pt.ulusofona.lp2.deisiJungle;

import javax.swing.*;
import java.util.ArrayList;

public class GameManager {
    public Tabuleiro tabuleiro;
    public GameManager() {
    }

    public String[][] getSpecies() {
        String[][] species = new String[6][7];
        species[0][0] = "E";
        species[0][1] = "Elefante";
        species[0][2] = "elephant.png";
        species[0][3] = "180";
        species[0][4] = "4";
        species[0][5] = "10";
        species[0][6] = "1..6";

        species[1][0] = "L";
        species[1][1] = "Leão";
        species[1][2] = "lion.png";
        species[1][3] = "80";
        species[1][4] = "2";
        species[1][5] = "10";
        species[1][6] = "4..6";

        species[2][0] = "T";
        species[2][1] = "Tartaruga";
        species[2][2] = "turtle.png";
        species[2][3] = "150";
        species[2][4] = "1";
        species[2][5] = "5";
        species[2][6] = "1..3";

        species[3][0] = "P";
        species[3][1] = "Pássaro";
        species[3][2] = "bird.png";
        species[3][3] = "70";
        species[3][4] = "4";
        species[3][5] = "50";
        species[3][6] = "5..6";

        species[4][0] = "Z";
        species[4][1] = "Tarzan";
        species[4][2] = "tarzan.png";
        species[4][3] = "70";
        species[4][4] = "2";
        species[4][5] = "20";
        species[4][6] = "1..6";

        species[5][0] = "S";
        species[5][1] = "Cobra";
        species[5][2] = "snake.png";
        species[5][3] = "100";
        species[5][4] = "10";
        species[5][5] = "30";
        species[5][6] = "3..6";

        return species;
    }

    public boolean createInitialJungle(int jungleSize, String[][] playersInfo, String[][] foodsInfo) {
        //assuming the start and finishlines count for the amount of houses
        int id = 0;
        int name = 1;
        int species = 2;
        boolean hasTarzan = false;

        ArrayList<Jogador> jogadores = new ArrayList<>();

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
                String firstPlayerID = playersInfo[player1][id];

                if (playersInfo[player1] != null) {

                    if(!playerAttributeChecksAndAdd(playersInfo, player1, name, firstPlayerID, id, species, hasTarzan
                            /*initialEnergy*/, jogadores)){
                        return false;
                    }

                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        for(int i = 0; i < jogadores.size(); ++i){
            tabuleiro.addJogador(jogadores.get(i));
        }
        tabuleiro.getCasas()[0].getJogadores().addAll(jogadores);
        tabuleiro.setCurrentPlayer(tabuleiro.getJogadores().get(0));

        for(int i = 0; i < foodsInfo.length; ++i){

        }

        return true;
    }

    private boolean playerAttributeChecksAndAdd(String[][] playersInfo, int player1, int name, String firstPlayerID, int id,
                                int species, boolean hasTarzan /*int initialEnergy*/, ArrayList<Jogador> jogadores){
        //name is well-made
        String thisName = playersInfo[player1][name];
        if (thisName == null || thisName.length() == 0) {
            return false;
        }

        //no repeated ID's
        for (int player2 = player1 + 1; player2 < playersInfo.length; player2++) {
            String secondPlayerID = playersInfo[player2][id];
            if (firstPlayerID.equals(secondPlayerID)) {
                return false;
            }
        }
        //Check if the ID is an Integer
        try {
            if (Integer.parseInt(firstPlayerID) <= 0) {
                return false;
            }
        } catch (NumberFormatException n) {
            return false;
        }
        //is an eligible Species
        String thisSpecies = playersInfo[player1][species];

        if ((thisSpecies.equals("E") || thisSpecies.equals("L") || thisSpecies.equals("P") || thisSpecies.equals("Z") || thisSpecies.equals("S"))
                || (thisSpecies.equals("T") && !hasTarzan)) {
            //Adding the Player into the Tabuleiro
/*
            Jogador thisPlayerObject = new Jogador(Integer.parseInt(playersInfo[player1][0]), thisName, new Especie(thisSpecies.charAt(0)),
                    initialEnergy);
            jogadores.add(thisPlayerObject);
        } else {*/
            return false;
        }
        return true;
    }

    public int[] getPlayerIds(int squareNr) {
        int[] playerIDs;
        if (tabuleiro != null) {
            int convertedSquare = squareNr - 1;
            if ((convertedSquare < tabuleiro.getSize() && convertedSquare >= 0) && tabuleiro.getCasas()[convertedSquare] != null) {
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

    public String[] getSquareInfo(int squareNr) {
        int convertedSquare = squareNr - 1;
        String[] casa = new String[3];
        if (!(convertedSquare < tabuleiro.getSize() && convertedSquare >= 0)) {
            return null;
        }
        if (tabuleiro != null) {
            if (convertedSquare == tabuleiro.getSize() - 1) {
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
            if (getPlayerIds(squareNr).length > 0) {
                casa[2] += getPlayerIds(squareNr)[getPlayerIds(squareNr).length - 1];
            }
        }

        return casa;
    }

    public String[] getPlayerInfo(int playerId) {
        String[] thisPlayer = new String[5];
        Jogador thisJogador = tabuleiro.getJogaresHS().get(playerId);
        if (tabuleiro != null && tabuleiro.getJogaresHS() != null && thisJogador != null) {
            thisPlayer[0] = thisJogador.getId() + "";
            thisPlayer[1] = thisJogador.getName();
            thisPlayer[2] = thisJogador.getSpecies().getIdentifier() + "";
            thisPlayer[3] = thisJogador.getEnergy() + "";
            thisPlayer[4] = thisJogador.getSpecies().getMinSpeed() + ".." + thisJogador.getSpecies().getMaxSpeed();
        } else {
            return null;
        }
        return thisPlayer;
    }

    public String[] getCurrentPlayerInfo() {
        String[] thisPlayer = new String[4];
        Jogador thisJogador = tabuleiro.getCurrentPlayer();
        thisPlayer[0] = thisJogador.getId() + "";
        thisPlayer[1] = thisJogador.getName();
        /*thisPlayer[2] = thisJogador.getSpecies().getIdentifier() + "";*/
        thisPlayer[3] = thisJogador.getEnergy() + "";
        return thisPlayer;
    }

    public String[][] getPlayersInfo() {
        String[][] thesePlayers = new String[tabuleiro.getJogadores().size()][4];
        if (tabuleiro != null) {
            for (int i = 0; i < tabuleiro.getJogadores().size(); i++) {
                Jogador thisJogador = tabuleiro.getJogadores().get(i);
                thesePlayers[i][0] = thisJogador.getId() + "";
                thesePlayers[i][1] = thisJogador.getName();
                thesePlayers[i][2] = thisJogador.getSpecies().getIdentifier() + "";
                thesePlayers[i][3] = thisJogador.getEnergy() + "";
            }
            return thesePlayers;
        }
        return null;
    }

    public boolean moveCurrentPlayer(int nrSquares, boolean bypassValidations) {
        boolean state = false;
        //Refuse to let em move if there is already a winner
        if (tabuleiro.getPlayerWin() == null){
            if (tabuleiro.getCurrentPlayer().getEnergy() >= 2) {
                if (!bypassValidations) {
                    if (nrSquares > 0 && nrSquares <= 6) {
                        tabuleiro.getCurrentPlayer().theMovementPart(tabuleiro, nrSquares);
                    }else{
                        tabuleiro.nextTurn();
                        return false;
                    }
                } else {
                    tabuleiro.getCurrentPlayer().theMovementPart(tabuleiro, nrSquares);
                }
                state = true;
            }
            tabuleiro.nextTurn();
        }
        return state;
    }

    private int playersWithEnergy(){
        int count = 0;
        for(int i = 0; i < tabuleiro.getJogadores().size(); ++i){
            //I put a 1 instead of a 0
            if(tabuleiro.getJogadores().get(i).getEnergy() > 1){
                count++;
            }
        }
        return count;
    }

    public String[] getWinnerInfo() {

        if (!tabuleiro.getWinner() && playersWithEnergy() > 0) {
            return null;
        }

        if(!tabuleiro.getWinner() && playersWithEnergy() == 0){
            int max = tabuleiro.getJogadores().get(0).getPosition();
            Jogador player = tabuleiro.getJogadores().get(0);

            for(int i = 0; i < tabuleiro.getJogadores().size(); ++i){
                if(tabuleiro.getJogadores().get(i).getPosition() > max){
                    max = tabuleiro.getJogadores().get(i).getPosition();
                    player = tabuleiro.getJogadores().get(i);
                }
            }
            tabuleiro.setPlayerWin(player);
        }

        return new String[]{
                /*String.valueOf(tabuleiro.playerWin.id), tabuleiro.playerWin.name,
                String.valueOf(tabuleiro.playerWin.getSpecies().getIdentifier()),String.valueOf(tabuleiro.playerWin.getEnergy())*/};
    }

    public ArrayList<String> getGameResults() {
        ArrayList<String> players = new ArrayList<>();
        int counter = 1;

        for (int i = tabuleiro.getCasas().length - 1; i >= 0; --i) {
            if (tabuleiro.getCasas()[i].getJogadores().size() != 0) {
                for (int j = 0; j < tabuleiro.getCasas()[i].getJogadores().size(); ++j) {
                    Jogador player = tabuleiro.getCasas()[i].getJogadores().get(j);
                    /*players.add("#" + counter + " " + player.name + ", " + player.species.getName() + ", " + String.valueOf(player.getPosition()+1));*/
                    counter++;
                }
            }
        }
        return players;
    }

    public JPanel getAuthorsPanel() {
        return null;
    }

    public String whoIsTaborda() {
        return "Wrestling";
    }


}
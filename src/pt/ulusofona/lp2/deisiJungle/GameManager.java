package pt.ulusofona.lp2.deisiJungle;

import pt.ulusofona.lp2.deisiJungle.Food.*;
import pt.ulusofona.lp2.deisiJungle.Species.*;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class GameManager {
    private Tabuleiro tabuleiro;

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public GameManager() {}

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

    public String[] getCurrentPlayerEnergyInfo(int nrPositions){
        String[] info = new String[2];

        for(int i = 0; i < getSpecies().length; ++i){
            char identifier = tabuleiro.getCurrentPlayer().getSpecies().getIdentifier();
            char identifier_compare = getSpecies()[i][0].charAt(0);

            if(identifier == identifier_compare){
                info[0] = getSpecies()[i][4];
                info[1] = getSpecies()[i][5];
            }
        }

        return info;
    }

    public String[][] getFoodTypes(){
        String[][] foodTypes = new String[5][3];
        foodTypes[0][0] = "e";
        foodTypes[0][1] = "Erva";
        foodTypes[0][2] = "grass.png";

        foodTypes[1][0] = "a";
        foodTypes[1][1] = "Agua";
        foodTypes[1][2] = "water.png";

        foodTypes[2][0] = "b";
        foodTypes[2][1] = "Cacho de bananas";
        foodTypes[2][2] = "bananas.png";

        foodTypes[3][0] = "c";
        foodTypes[3][1] = "Carne";
        foodTypes[3][2] = "meat.png";

        foodTypes[4][0] = "m";
        foodTypes[4][1] = "Cogumelos magicos";
        foodTypes[4][2] = "mushroom.png";

        return foodTypes;
    }

    private InitializationError setFoodOnBoard(String[][] foodsInfo){
        if (foodsInfo != null) {
            for (int i = 0; i < foodsInfo.length; i++) {

                int foodPosition = Integer.parseInt(foodsInfo[i][1]) - 1; //ASSUMING THEY COUNT LIKE HUMANS
                char foodIdentifier = foodsInfo[i][0].charAt(0);

                //Check if food array has the correct size
                if (!(foodsInfo[i].length == 2)){
                    return new InitializationError("WRONGFOODARRAYDIMENSIONS");
                }
                //Check if the food is inside the board, can't be on starting pos or finish line
                if (foodPosition > 0 && foodPosition < tabuleiro.getSize() - 1) {
                    Food food = foodFactory(foodIdentifier);
                    if (food != null){/*
                        tabuleiro.getCasas()[foodPosition].setComida(food);
                    }else {*/
                        return new InitializationError("ILLEGALFOOD");
                    }
                }else {
                    return new InitializationError("FOODOUTSIDETABULEIRO");
                }
            }
        }else {
            return new InitializationError("FOODSINFOISNULL");
        }
        return null;
    }

    public InitializationError createInitialJungle(int jungleSize, String[][] playersInfo){
        //assuming the start and finishlines count for the amount of houses
        int id = 0;
        int name = 1;
        int species = 2;
        boolean hasTarzan = false;

        ArrayList<Jogador> jogadores = new ArrayList<>();

        //Creating tabuleiro
        tabuleiro = new Tabuleiro(jungleSize);

        if (playersInfo == null) {
            return new InitializationError("PLAYERINFOISNULL");
        }
        //Player amount check
        if (playersInfo.length < 2 || playersInfo.length > 4) {
            return new InitializationError("WRONGPLAYERAMOUNT");
        }

        //Tabuleiro size check
        if (jungleSize < playersInfo.length * 2) {
            return new InitializationError("WRONGJUNGLESIZE");
        }

        for (int player1 = 0; player1 < playersInfo.length; player1++) {

            String firstPlayerID = "";
            if (playersInfo[player1] == null) {
                return new InitializationError("THISPLAYERSINFOISNULL");
            }
            firstPlayerID = playersInfo[player1][id];
            InitializationError theCheck = playerAttributeChecksAndAdd(playersInfo, player1, name, firstPlayerID, id, species, hasTarzan, jogadores);
            if(!(theCheck.getMessage().equals("GOODPLAYERATTRIBUTES"))){
                return theCheck;
            }
            //Check if player is Tarzan
            if (!hasTarzan && playersInfo[player1][species].equals("Z")){
                hasTarzan = true;
            }
        }

        //add players to board
        for(int i = 0; i < jogadores.size(); i++){
            tabuleiro.addJogador(jogadores.get(i));
        }

        //add players to first Position of board and define currentPlayer
        tabuleiro.getCasas()[0].getJogadores().addAll(jogadores);
        tabuleiro.setCurrentPlayer(tabuleiro.getJogadores().get(0));

        return null;
    }

    public InitializationError createInitialJungle(int jungleSize, String[][] playersInfo, String[][] foodsInfo) {
        InitializationError createJungle = createInitialJungle(jungleSize, playersInfo);
        if(createJungle != null){
            return createJungle;
        }

        InitializationError food = setFoodOnBoard(foodsInfo);
        return food;
    }

    private InitializationError playerAttributeChecksAndAdd(String[][] playersInfo, int player1, int name, String firstPlayerID, int id,
                                int species, boolean hasTarzan, ArrayList<Jogador> jogadores){
        //name is well-made
        String thisName = playersInfo[player1][name];
        if (thisName == null || thisName.length() == 0) {
            return new InitializationError("ILLEGALNAME");
        }

        //no repeated ID's
        for (int player2 = player1 + 1; player2 < playersInfo.length; player2++) {
            String secondPlayerID = playersInfo[player2][id];
            if (firstPlayerID.equals(secondPlayerID)) {
                return new InitializationError("REPEATEDPLAYER");
            }
        }

        //Check if the ID is an Integer
        try {
            if (Integer.parseInt(firstPlayerID) <= 0) {
                return new InitializationError("NEGATIVEID");
            }
        } catch (NumberFormatException n) {
            return new InitializationError("WRONGTYPEID");
        }
        //is an eligible Species
        int playerID = Integer.parseInt(playersInfo[player1][0]);
        char thisPlayersSpeciesID =  playersInfo[player1][species].charAt(0);
        Especie thisPlayersSpecies = createAnimal(thisPlayersSpeciesID);

        //Adding the Player into the Tabuleiro
        if (thisPlayersSpecies != null){
            Jogador thisPlayerObject = new Jogador(playerID, thisName, thisPlayersSpecies);
            jogadores.add(thisPlayerObject);
        }else {
            return new InitializationError("ILLEGALANIMAL");
        }
        if (hasTarzan && thisPlayersSpeciesID == 'Z') {
            return new InitializationError("TOOMANYTARZAN");
        }
        return new InitializationError("GOODPLAYERATTRIBUTES");
    }

    private Especie createAnimal(char id){
        switch (id){
            case 'E':
                Elefante e = new Elefante();
                return e;

            case 'L':
                Leao l = new Leao();
                return l;

            case 'T':
                Tartaruga t = new Tartaruga();
                return t;

            case 'P':
                Passaro p = new Passaro();
                return p;

            case 'Z':
                Tarzan z = new Tarzan();
                return z;

            case 'C':
                Cobra c = new Cobra();
                return c;

            default:
                return null;
        }
    }

    private Food foodFactory(char id){
        switch (id){
            case 'e':
                Erva e = new Erva();
                return e;

            case 'a':
                Agua a = new Agua();
                return a;

            case 'b':
                Bananas b = new Bananas();
                return b;

            case 'c':
                Carne c = new Carne();
                return c;

            case 'm':
                Shrooms m = new Shrooms();
                return m;

            default:
                return null;
        }
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
        thisPlayer[2] = thisJogador.getSpecies().getIdentifier() + "";
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

    public MovementResult moveCurrentPlayer(int nrSquares, boolean bypassValidations) {
        MovementResult thisResult = tabuleiro.getCurrentPlayer().theMovementPart(tabuleiro, nrSquares, bypassValidations);
        tabuleiro.nextTurn();
        return thisResult;
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

    public boolean saveGame(File file){
        return false;
    }

    public boolean loadGame(File file){
        return false;
    }
}
package pt.ulusofona.lp2.deisiJungle;

import pt.ulusofona.lp2.deisiJungle.food.*;
import pt.ulusofona.lp2.deisiJungle.species.*;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GameManager {
    private Tabuleiro tabuleiro;

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

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

    public String[] getCurrentPlayerEnergyInfo(int nrPositions) {
        String[] info = new String[2];

        info[0] = Math.abs((tabuleiro.getCurrentPlayer().getSpecies().getEnergyConsumption()*nrPositions)) + "";
        info[1] = tabuleiro.getCurrentPlayer().getSpecies().getEnergyGain() + "";

        return info;
    }

    public String[][] getFoodTypes() {
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

    private InitializationError setFoodOnBoard(String[][] foodsInfo) {
        if (foodsInfo != null) {
            for (int i = 0; i < foodsInfo.length; i++) {
                try {
                    int foodPosition = Integer.parseInt(foodsInfo[i][1]) - 1; //ASSUMING THEY COUNT LIKE HUMANS
                    char foodIdentifier = foodsInfo[i][0].charAt(0);

                    //Check if the food is inside the board, can't be on starting pos or finish line
                    if (foodPosition > 0 && foodPosition < tabuleiro.getSize() - 1) {
                        Food food = foodFactory(foodIdentifier);
                        if (food != null) {
                            tabuleiro.getCasas()[foodPosition].addComida(food);
                        } else {
                            return new InitializationError("ILLEGALFOOD");
                        }
                    } else {
                        return new InitializationError("FOODOUTSIDETABULEIRO");
                    }
                } catch (NumberFormatException e) {
                    return new InitializationError("WRONGFOODFORMAT");
                }
            }
        } else {
            return new InitializationError("FOODSINFOISNULL");
        }
        return null;
    }

    public InitializationError createInitialJungle(int jungleSize, String[][] playersInfo) {
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

            if (playersInfo[player1] == null || playersInfo[player1][id] == null) {
                return new InitializationError("THISPLAYERSINFOISNULL");
            }

            String firstPlayerID = playersInfo[player1][id];

            InitializationError theCheck = playerAttributeChecksAndAdd(playersInfo, player1, name, firstPlayerID, id, species, hasTarzan, jogadores);
            if (!(theCheck.getMessage().equals("GOODPLAYERATTRIBUTES"))) {
                return theCheck;
            }
            //Check if player is Tarzan
            if (!hasTarzan && playersInfo[player1][species].equals("Z")) {
                hasTarzan = true;
            }
        }

        //add players to board
        for (int i = 0; i < jogadores.size(); i++) {
            tabuleiro.addJogador(jogadores.get(i));
        }

        //add players to first Position of board and define currentPlayer
        tabuleiro.getCasas()[0].getJogadores().addAll(jogadores);
        tabuleiro.setCurrentPlayer(tabuleiro.getJogadores().get(0));

        return null;
    }

    public InitializationError createInitialJungle(int jungleSize, String[][] playersInfo, String[][] foodsInfo) {
        InitializationError createJungle = createInitialJungle(jungleSize, playersInfo);

        if (createJungle != null) {
            return createJungle;
        }
        InitializationError food = setFoodOnBoard(foodsInfo);
        return food;
    }

    private InitializationError playerAttributeChecksAndAdd(String[][] playersInfo, int player1, int name, String firstPlayerID, int id,
                                                            int species, boolean hasTarzan, ArrayList<Jogador> jogadores) {
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
        char thisPlayersSpeciesID;
        Especie thisPlayersSpecies;
        if (playersInfo[player1][species] != null && playersInfo[player1][species].length() > 0) {
            thisPlayersSpeciesID = playersInfo[player1][species].charAt(0);
            thisPlayersSpecies = createAnimal(thisPlayersSpeciesID);
        } else {
            return new InitializationError("ANIMALNOTPROVIDED");
        }

        //Adding the Player into the Tabuleiro
        if (thisPlayersSpecies != null) {
            Jogador thisPlayerObject = new Jogador(playerID, thisName, thisPlayersSpecies);
            /*if (thisPlayerObject.getSpecies() == null) {
                return new InitializationError("ILLEGALANIMAL");
            }*/
            jogadores.add(thisPlayerObject);
        } else {
            return new InitializationError("ILLEGALANIMAL");
        }
        if (hasTarzan && thisPlayersSpeciesID == 'Z') {
            return new InitializationError("TOOMANYTARZAN");
        }
        return new InitializationError("GOODPLAYERATTRIBUTES");
    }

    private Especie createAnimal(char id) {
        switch (id) {
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

    private Food foodFactory(char id) {
        switch (id) {
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

                ArrayList<Food> comidas = tabuleiro.getCasas()[convertedSquare].getComida();

                if (comidas != null && !comidas.isEmpty()){
                    Food comida = comidas.get(0);
                    if (comida != null){
                        casa[0] = comida.getImg();
                        casa[1] = comida.getToolTip(tabuleiro);
                    }else {
                        casa[0] = "blank.png";
                        casa[1] = "Vazio";
                    }
                }else {
                    casa[0] = "blank.png";
                    casa[1] = "Vazio";
                }
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
        String[] thisPlayer = new String[5];
        Jogador thisJogador = tabuleiro.getCurrentPlayer();
        thisPlayer[0] = thisJogador.getId() + "";
        thisPlayer[1] = thisJogador.getName();
        thisPlayer[2] = thisJogador.getSpecies().getIdentifier() + "";
        thisPlayer[3] = thisJogador.getEnergy() + "";
        thisPlayer[4] = thisJogador.getSpecies().getMinSpeed() + ".." + thisJogador.getSpecies().getMaxSpeed();

        return thisPlayer;
    }

    public String[][] getPlayersInfo() {
        String[][] thesePlayers = new String[tabuleiro.getJogadores().size()][5];
        if (tabuleiro != null) {
            for (int i = 0; i < tabuleiro.getJogadores().size(); i++) {
                Jogador thisJogador = tabuleiro.getJogadores().get(i);
                Especie thisSpecies = thisJogador.getSpecies();
                thesePlayers[i][0] = thisJogador.getId() + "";
                thesePlayers[i][1] = thisJogador.getName();
                thesePlayers[i][2] = thisSpecies.getIdentifier() + "";
                thesePlayers[i][3] = thisJogador.getEnergy() + "";
                thesePlayers[i][4] = thisSpecies.getMinSpeed() + ".." + thisSpecies.getMaxSpeed();
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

    public String[] getWinnerInfo() {

        if (!tabuleiro.getWinner()) {
            return null;
        }
        Jogador winner = tabuleiro.getPlayerWin();
        Especie species = winner.getSpecies();
        return new String[]{
                winner.getId() + "", winner.getName(),
                species.getIdentifier() + "", winner.getEnergy() + "", species.getMinSpeed() + ".." + species.getMaxSpeed()};
    }

    public ArrayList<String> getGameResults() {
        ArrayList<String> players = new ArrayList<>();
        int counter = 1;

        if (tabuleiro.getCasas()[tabuleiro.getCasas().length-1].getJogadores().size() != 0) {
            Jogador player = tabuleiro.getPlayerWin();
            players.add("#" + counter + " " + player.getName() + ", " + player.getSpecies().getName() + ", " +
                    (player.getPosition() + 1) + ", " + player.getDistancia() + ", " + player.getNumAlimentos());
            counter++;
        }

        ArrayList<Jogador> sortedPlayers;

        for (int i = tabuleiro.getCasas().length - 2; i >= 0; --i) {
            if (tabuleiro.getCasas()[i].getJogadores().size() != 0) {
                sortedPlayers = tabuleiro.getCasas()[i].getJogadores();
                sortedPlayers.sort(Comparator.comparingInt(Jogador::getId));
                for(Jogador player : sortedPlayers){
                    players.add("#" + counter + " " + player.getName() + ", " + player.getSpecies().getName() + ", " +
                            (player.getPosition() + 1) + ", " + player.getDistancia() + ", " + player.getNumAlimentos());
                    counter++;
                }
            }
            if(counter > tabuleiro.getJogadores().size()){
                break;
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

    public boolean saveGame(File file) {
        try{
            FileWriter fwp = new FileWriter(file);
            fwp.write(tabuleiro.getSize()+","+tabuleiro.getJogadores().size()+","+tabuleiro.getCurrentPlayer().getId()+","+tabuleiro.getTurns()+"\n");
            for (int i = 0; i < tabuleiro.getCasas().length; i++) {
                Casa casa = tabuleiro.getCasas()[i];
                String toAdd = "";
                for(int j = 0; j < casa.getJogadores().size(); ++j){
                    Jogador player = casa.getJogadores().get(j);
                    toAdd += player.getId()+","+player.getName()+","+player.getNumAlimentos()+","+player.getPosition()+
                            ","+player.getEnergy()+","+player.getHasEatenBanana()+","+player.getSpecies().getIdentifier()+","+player.getDistancia()+"~";
                }
                if(toAdd.length() > 0){
                    toAdd = toAdd.substring(0, toAdd.length()-1);
                    fwp.write(toAdd);
                }
                fwp.write("/");
                for(int k = 0; k < casa.getComida().size(); ++k){
                    Food comida = casa.getComida().get(k);
                    if(k < casa.getComida().size() - 1){
                        fwp.write(comida.getId()+",");
                    }else{
                        fwp.write(comida.getId());
                    }
                }
                fwp.write("\n");
            }
            fwp.close();
        }catch(IOException e){
            return false;
        }
        return true;
    }

    public void setPlayersPositions(String[][] players, String[] playersHouse, String[] playersDistance){
        Jogador player = tabuleiro.getCurrentPlayer();
        for(int k = 0; k < tabuleiro.getJogadores().size(); ++k){
            for(int b = 0; b < players.length; ++b){
                if(players[b][0].equals(tabuleiro.getJogadores().get(k).getId()+"")){
                    moveCurrentPlayer(Integer.parseInt(playersHouse[b]) ,true);
                    player.setDistancia(Integer.parseInt(playersDistance[b]));
                    tabuleiro.decreaseTurn();
                    break;
                }
            }
        }
    }

    public void setPlayersEnergy(ArrayList<String> energia){
        for(int l = 0; l < tabuleiro.getJogadores().size(); ++l){
            for(int m = 0; m < energia.size(); ++m){
                if(tabuleiro.getJogadores().get(l).getId() == Integer.parseInt(energia.get(m).split(" ")[0])){
                    tabuleiro.getJogadores().get(l).setEnergy(Integer.parseInt(energia.get(m).split(" ")[1]));
                }
            }
        }
    }

    public void setCurrentPlayer(int turn, int currentPlayerId){
        tabuleiro.setTurn(turn-1);
        tabuleiro.nextTurn();
        for(int l = 0; l < tabuleiro.getJogadores().size(); ++l){
            if(tabuleiro.getJogadores().get(l).getId() == currentPlayerId) {
                tabuleiro.setCurrentPlayer(tabuleiro.getJogadores().get(l));
            }
        }
    }

    public void addMultiplePlayers(String[][] players, String text, int i, ArrayList<String> energia, String[] playersHouse){
        players[i-1][0] = text.split(",")[0];
        players[i-1][1] = text.split(",")[1];
        players[i-1][2] = text.split(",")[6];
        energia.add(text.split(",")[0] + " " + text.split(",")[4]);
        playersHouse[i-1] = text.split(",")[3];
    }

    public void addSinglePlayer(String[][] players, String read, int i, ArrayList<String> energia, String[] playersHouse, String[] playersDistance){
        players[i-1][0] = read.split(",")[0];
        players[i-1][1] = read.split(",")[1];
        players[i-1][2] = read.split(",")[6];
        energia.add(read.split(",")[0] + " " + read.split(",")[4]);
        playersHouse[i-1] = read.split(",")[3];
        playersDistance[i-1] = read.split(",")[7].substring(0, read.split(",")[7].indexOf("/"));
    }
    public boolean loadGame(File file) {
        try{
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String read, size = "";
            int i = 0, a = 0, jogadoresSize, currentPlayerId = 0, turn = 0;
            String[][] players = null;
            String[] playersHouse = null, playersDistance = null;
            ArrayList<String> comida = new ArrayList<>(), energia = new ArrayList<>();
            while((read = bf.readLine()) != null){
                if(i == 0){
                    size = read.split(",")[0];
                    jogadoresSize = Integer.parseInt(read.split(",")[1]);
                    players = new String[jogadoresSize][3];
                    playersHouse = new String[jogadoresSize];
                    playersDistance = new String[jogadoresSize];
                    currentPlayerId = Integer.parseInt(read.split(",")[2]);
                    turn = Integer.parseInt(read.split(",")[3]);
                    i++;
                }else{
                    if(read.split(",").length > 6){
                        if(read.contains("~")){
                            for(int v = 0; v < read.split("~").length; ++v){
                                String text = read.split("~")[v];
                                addMultiplePlayers(players, text, i, energia, playersHouse);
                                if(v != read.split("~").length-1) {
                                    playersDistance[i-1] = text.split(",")[7];
                                }else{
                                    playersDistance[i-1] = text.split(",")[7].substring(0, text.split(",")[7].indexOf("/"));
                                }
                                i++;
                            }
                        }else{
                            addSinglePlayer(players, read, i, energia, playersHouse, playersDistance);
                            i++;
                        }
                    }
                }
                if(read.split("/").length > 1){
                    for(int j = 0; j < read.split("/")[1].split(",").length; ++j){
                        comida.add(a + " " + read.split("/")[1].split(",")[j]);
                    }
                }
                a++;
            }
            String[][] foodArray = new String[comida.size()][2];
            for(int k = 0; k < foodArray.length; k++){
                foodArray[k][0] = comida.get(k).split(" ")[1];
                foodArray[k][1] = comida.get(k).split(" ")[0];
            }
            tabuleiro = new Tabuleiro(Integer.parseInt(size));
            if(createInitialJungle(Integer.parseInt(size), players, foodArray) != null){
                return false;
            }
            setPlayersPositions(players, playersHouse, playersDistance);
            setPlayersEnergy(energia);
            setCurrentPlayer(turn, currentPlayerId);
        }catch(IOException e){
            return false;
        }
        return true;
    }
}
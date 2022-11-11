package pt.ulusofona.lp2.deisiJungle;

import static junit.framework.TestCase.assertEquals;

public class Test {
    @org.junit.Test
     public void TestNr1(){
        GameManager a = new GameManager();
        String[][] playersInfo = new String[4][3];
        int player1 = 0;
        int player2 = 1;
        int player3 = 2;
        int player4 = 3;
        int id = 0;
        int nome = 1;
        int species = 2;
        playersInfo[player1][id] = "1";
        playersInfo[player1][nome] = "John";
        playersInfo[player1][species] = "E";
        playersInfo[player2][id] = "2";
        playersInfo[player2][nome] = "Ketchup";
        playersInfo[player2][species] = "S";
        playersInfo[player3][id] = "3";
        playersInfo[player3][nome] = "Heinz";
        playersInfo[player3][species] = "E";
        playersInfo[player4][id] = "4";
        playersInfo[player4][nome] = "Tomato";
        playersInfo[player4][species] = "Z";


        assertEquals(true, a.createInitialJungle(8,20,playersInfo));
    }

}

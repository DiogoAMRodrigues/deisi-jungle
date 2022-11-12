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

   @org.junit.Test
   public void TestNr2(){
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

      a.createInitialJungle(8,20,playersInfo);

      assertEquals(true, a.moveCurrentPlayer(9, true));
   }

   @org.junit.Test
   public void TestNr3(){
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

      a.createInitialJungle(8,20,playersInfo);
      a.moveCurrentPlayer(9, true);
      String[] winnerExpected = new String[]{playersInfo[player1][id], playersInfo[player1][nome],
              playersInfo[player1][species], a.tabuleiro.getJogadores().get(0).getEnergy() + "" };
      String[] winner = a.getWinnerInfo();
      assertEquals(winnerExpected[0],winner[0]);
      assertEquals(winnerExpected[1],winner[1]);
      assertEquals(winnerExpected[2],winner[2]);
   }
   @org.junit.Test
   public void TestNr4(){
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

      a.createInitialJungle(8,20,playersInfo);
      a.moveCurrentPlayer(9, true);
      String[] winnerExpected = new String[]{playersInfo[player1][id], playersInfo[player1][nome],
              playersInfo[player1][species], a.tabuleiro.getJogadores().get(0).getEnergy() + "" };
      String[] winner = a.getWinnerInfo();

      assertEquals(winnerExpected[1],winner[1]);
   }

   //Normal instant Wins each one

   @org.junit.Test
   public void TestNr5(){ // 1st guy wins instantly
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

      a.createInitialJungle(8,20,playersInfo);
      a.moveCurrentPlayer(9, true);
      String[] winnerExpected = new String[]{playersInfo[player1][id], playersInfo[player1][nome],
              playersInfo[player1][species], a.tabuleiro.getJogadores().get(0).getEnergy() + "" };
      String[] winner = a.getWinnerInfo();

      assertEquals(winnerExpected[nome],winner[nome]);
   }

   @org.junit.Test
   public void TestNr6(){ // 2nd guy wins instantly
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

      a.createInitialJungle(8,20,playersInfo);
      a.moveCurrentPlayer(1, true);
      a.moveCurrentPlayer(9, true);
      String[] winnerExpected = new String[]{playersInfo[player2][id], playersInfo[player2][nome],
              playersInfo[player2][species], a.tabuleiro.getJogadores().get(1).getEnergy() + "" };
      String[] winner = a.getWinnerInfo();

      assertEquals(winnerExpected[nome],winner[nome]);
   }

   @org.junit.Test
   public void TestNr7(){ // 3rd guy wins instantly
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

      a.createInitialJungle(8,20,playersInfo);
      a.moveCurrentPlayer(1, true);
      a.moveCurrentPlayer(1, true);
      a.moveCurrentPlayer(9, true);
      String[] winnerExpected = new String[]{playersInfo[player3][id], playersInfo[player3][nome],
              playersInfo[player3][species], a.tabuleiro.getJogadores().get(2).getEnergy() + "" };
      String[] winner = a.getWinnerInfo();

      assertEquals(winnerExpected[nome],winner[nome]);
   }

   @org.junit.Test
   public void TestNr8(){ // 4th guy wins instantly
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

      a.createInitialJungle(8,20,playersInfo);
      a.moveCurrentPlayer(1, true);
      a.moveCurrentPlayer(1, true);
      a.moveCurrentPlayer(1, true);
      a.moveCurrentPlayer(9, true);
      String[] winnerExpected = new String[]{playersInfo[player4][id], playersInfo[player4][nome],
              playersInfo[player4][species], a.tabuleiro.getJogadores().get(3).getEnergy() + "" };
      String[] winner = a.getWinnerInfo();

      assertEquals(winnerExpected[nome],winner[nome]);
   }

   //Win through multiple moves
   @org.junit.Test
   public void TestNr9(){ // 4th guy wins with time
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

      a.createInitialJungle(8,20,playersInfo);
      for (int i = 0; i < 5; i++) {
         a.moveCurrentPlayer(1, false);
         a.moveCurrentPlayer(1, false);
         a.moveCurrentPlayer(1, false);
         a.moveCurrentPlayer(2, false);
      }
      String[] winnerExpected = new String[]{playersInfo[player4][id], playersInfo[player4][nome],
              playersInfo[player4][species], a.tabuleiro.getJogadores().get(3).getEnergy() + "" };
      String[] winner = a.getWinnerInfo();

      assertEquals(winnerExpected[nome],winner[nome]);
   }

   @org.junit.Test
   public void TestNr10(){ // 4th guy wins with too far move
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

      a.createInitialJungle(8,20,playersInfo);
      for (int i = 0; i < 5; i++) {
         a.moveCurrentPlayer(1, false);
         a.moveCurrentPlayer(1, false);
         a.moveCurrentPlayer(1, false);
         a.moveCurrentPlayer(3, false);
      }
      String[] winnerExpected = new String[]{playersInfo[player4][id], playersInfo[player4][nome],
              playersInfo[player4][species], a.tabuleiro.getJogadores().get(3).getEnergy() + "" };
      String[] winner = a.getWinnerInfo();

      assertEquals(winnerExpected[nome],winner[nome]);
   }

   @org.junit.Test
   public void TestNr11(){ // 3rd guy wins with too far move and 4th would win next right after him
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

      a.createInitialJungle(8,20,playersInfo);
      for (int i = 0; i < 5; i++) {
         a.moveCurrentPlayer(1, false);
         a.moveCurrentPlayer(1, false);
         a.moveCurrentPlayer(3, false);
         a.moveCurrentPlayer(3, false);
      }
      String[] winnerExpected = new String[]{playersInfo[player3][id], playersInfo[player3][nome],
              playersInfo[player3][species], a.tabuleiro.getJogadores().get(2).getEnergy() + "" };
      String[] winner = a.getWinnerInfo();

      assertEquals(winnerExpected[nome],winner[nome]);
   }

   @org.junit.Test
   public void TestNr12(){ // Outta energy all same house
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

      a.createInitialJungle(50,10,playersInfo);
      for (int i = 0; i < 10; i++) {
         a.moveCurrentPlayer(1, false);
         a.moveCurrentPlayer(1, false);
         a.moveCurrentPlayer(1, false);
         a.moveCurrentPlayer(1, false);
      }
      String[] winnerExpected = new String[]{playersInfo[player1][id], playersInfo[player1][nome],
              playersInfo[player1][species], a.tabuleiro.getJogadores().get(0).getEnergy() + "" };
      String[] winner = a.getWinnerInfo();

      assertEquals(winnerExpected[nome],winner[nome]);
   }

   @org.junit.Test
   public void TestNr13(){ // Outta energy 3rd guy closest to finishline
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

      a.createInitialJungle(50,10,playersInfo);
      for (int i = 0; i < 10; i++) {
         a.moveCurrentPlayer(1, false);
         a.moveCurrentPlayer(2, false);
         a.moveCurrentPlayer(4, false);
         a.moveCurrentPlayer(3, false);
      }
      String[] winnerExpected = new String[]{playersInfo[player3][id], playersInfo[player3][nome],
              playersInfo[player3][species], a.tabuleiro.getJogadores().get(2).getEnergy() + "" };
      String[] winner = a.getWinnerInfo();

      assertEquals(winnerExpected[nome],winner[nome]);
   }
}

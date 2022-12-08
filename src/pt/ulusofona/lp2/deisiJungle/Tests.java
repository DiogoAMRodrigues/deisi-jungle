package pt.ulusofona.lp2.deisiJungle;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Tests {
   @Test
   public void createSpecies_01(){
      Elefante e = new Elefante();
      char identifier = e.getIdentifier();
      String name = e.getName();
      String image = e.getImage();
      int startEnergy = e.getStartEnergy();
      int energyConsumption = e.getEnergyConsumption();
      int energyGain = e.getEnergyGain();
      int minSpeed = e.getMinSpeed();
      int maxSpeed = e.getMaxSpeed();
      assertEquals('E', identifier);
      assertEquals("Elefante", name);
      assertEquals("elephant.png", image);
      assertEquals(180, startEnergy);
      assertEquals(4, energyConsumption);
      assertEquals(10, energyGain);
      assertEquals(1, minSpeed);
      assertEquals(6, maxSpeed);


      Leao l = new Leao();
      identifier = l.getIdentifier();
      name = l.getName();
      image = l.getImage();
      startEnergy = l.getStartEnergy();
      energyConsumption = l.getEnergyConsumption();
      energyGain = l.getEnergyGain();
      minSpeed = l.getMinSpeed();
      maxSpeed = l.getMaxSpeed();
      assertEquals('L', identifier);
      assertEquals("Leão", name);
      assertEquals("lion.png", image);
      assertEquals(80, startEnergy);
      assertEquals(2, energyConsumption);
      assertEquals(10, energyGain);
      assertEquals(4, minSpeed);
      assertEquals(6, maxSpeed);

      Tartaruga t = new Tartaruga();
      identifier = t.getIdentifier();
      name = t.getName();
      image = t.getImage();
      startEnergy = t.getStartEnergy();
      energyConsumption = t.getEnergyConsumption();
      energyGain = t.getEnergyGain();
      minSpeed = t.getMinSpeed();
      maxSpeed = t.getMaxSpeed();
      assertEquals('T', identifier);
      assertEquals("Tartaruga", name);
      assertEquals("turtle.png", image);
      assertEquals(150, startEnergy);
      assertEquals(1, energyConsumption);
      assertEquals(5, energyGain);
      assertEquals(1, minSpeed);
      assertEquals(3, maxSpeed);

      Passaro p = new Passaro();
      identifier = p.getIdentifier();
      name = p.getName();
      image = p.getImage();
      startEnergy = p.getStartEnergy();
      energyConsumption = p.getEnergyConsumption();
      energyGain = p.getEnergyGain();
      minSpeed = p.getMinSpeed();
      maxSpeed = p.getMaxSpeed();
      assertEquals('P', identifier);
      assertEquals("Pássaro", name);
      assertEquals("bird.png", image);
      assertEquals(70, startEnergy);
      assertEquals(4, energyConsumption);
      assertEquals(50, energyGain);
      assertEquals(5, minSpeed);
      assertEquals(6, maxSpeed);

      Tarzan z = new Tarzan();
      identifier = z.getIdentifier();
      name = z.getName();
      image = z.getImage();
      startEnergy = z.getStartEnergy();
      energyConsumption = z.getEnergyConsumption();
      energyGain = z.getEnergyGain();
      minSpeed = z.getMinSpeed();
      maxSpeed = z.getMaxSpeed();
      assertEquals('Z', identifier);
      assertEquals("Tarzan", name);
      assertEquals("tarzan.png", image);
      assertEquals(70, startEnergy);
      assertEquals(2, energyConsumption);
      assertEquals(20, energyGain);
      assertEquals(1, minSpeed);
      assertEquals(6, maxSpeed);

      Cobra c = new Cobra();
      identifier = c.getIdentifier();
      name = c.getName();
      image = c.getImage();
      startEnergy = c.getStartEnergy();
      energyConsumption = c.getEnergyConsumption();
      energyGain = c.getEnergyGain();
      minSpeed = c.getMinSpeed();
      maxSpeed = c.getMaxSpeed();
      assertEquals('C', identifier);
      assertEquals("Cobra", name);
      assertEquals("snake.png", image);
      assertEquals(100, startEnergy);
      assertEquals(10, energyConsumption);
      assertEquals(30, energyGain);
      assertEquals(3, minSpeed);
      assertEquals(6, maxSpeed);
   }

   @Test
   public void getSpeciestest_02(){
      GameManager gameManager = new GameManager();
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

      String testString = "";
      for (int i = 0; i < species.length; i++){
         for (int j = 0; j < species[i].length; j++){
            testString += species[i][j];
         }
      }

      String[][] actualSpecies = gameManager.getSpecies();
      String actualString = "";
      for (int i = 0; i < actualSpecies.length; i++){
         for (int j = 0; j < actualSpecies[i].length; j++){
            actualString += actualSpecies[i][j];
         }
      }

      assertEquals(testString, actualString);
   }

   @Test
   public void getFoodTypes_03(){
      GameManager gameManager = new GameManager();
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

      String expected = "";
      for(int i = 0; i < foodTypes.length; i++){
         for(int j = 0; j < foodTypes[i].length; j++){
            expected += foodTypes[i][j];
         }
      }

      String[][] actualTypes = gameManager.getFoodTypes();
      String actual = "";
      for(int i = 0; i < actualTypes.length; i++){
         for(int j = 0; j < actualTypes[i].length; j++){
            actual += actualTypes[i][j];
         }
      }
      assertEquals(expected, actual);
   }


}

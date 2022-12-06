package pt.ulusofona.lp2.deisiJungle;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class Tests {
    @Test
     public void createAnimalsGetSpeed_01(){
        Elefante e = new Elefante();
        int thisSpeedTest = e.getSpeed();
        assertTrue(thisSpeedTest > 0 && thisSpeedTest < 7);

        Leao l = new Leao();
        thisSpeedTest = l.getSpeed();
        assertTrue(thisSpeedTest > 3 && thisSpeedTest < 7);

        Tartaruga t = new Tartaruga();
        thisSpeedTest = t.getSpeed();
        assertTrue(thisSpeedTest > 0 && thisSpeedTest < 4);

        Passaro p = new Passaro();
        thisSpeedTest = p.getSpeed();
        assertTrue(thisSpeedTest > 4 && thisSpeedTest < 7);

        Tarzan tarz = new Tarzan();
        thisSpeedTest = tarz.getSpeed();
        assertTrue(thisSpeedTest > 0 && thisSpeedTest < 7);

        Cobra c = new Cobra();
        thisSpeedTest = c.getSpeed();
        assertTrue(thisSpeedTest > 2 && thisSpeedTest < 7);
    }

}

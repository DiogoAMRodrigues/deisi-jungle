package pt.ulusofona.lp2.deisiJungle;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class Tests {
    @Test
     public void createAnimalsGetIdentifier_01(){
        Elefante e = new Elefante();
        char identifier = e.getIdentifier();
        assertEquals('E', identifier);

        Leao l = new Leao();
        identifier = l.getIdentifier();
        assertEquals('L', identifier);

        Tartaruga t = new Tartaruga();
        identifier = t.getIdentifier();
        assertEquals('T', identifier);

        Passaro p = new Passaro();
        identifier = p.getIdentifier();
        assertEquals('P', identifier);

        Tarzan tarz = new Tarzan();
        identifier = tarz.getIdentifier();
        assertEquals('Z', identifier);

        Cobra c = new Cobra();
        identifier = c.getIdentifier();
        assertEquals('C', identifier);
    }

}

package abdullah.mola.zugapplication;

import static org.junit.Assert.*;

import static abdullah.mola.zugapplication.Lokomotive.Antriebsarten.Dampf;
import static abdullah.mola.zugapplication.Lokomotive.Antriebsarten.Diesel;
import static abdullah.mola.zugapplication.Lokomotive.Antriebsarten.Elektrisch;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

public class LokomotiveTest {
    Lokomotive lokomotiveDiesel = new Lokomotive(Diesel, "Rechteckig", "", 558, 50,  2000, 2, 100, 100, 50, 55, 55);
    Lokomotive lokomotive = new Lokomotive(Elektrisch, "Rechteckig", "", 558, 50,  2000, 2, 100, 100, 50, 55, 55);
    Lokomotive lokomotiveDampf = new Lokomotive(Dampf, "Rechteckig", "", 558, 50,  2000, 2, 100, 100, 50, 55, 55);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void zugkraft() {

        assertEquals(52, lokomotive.zugkraft());
        assertEquals(52, lokomotiveDiesel.zugkraft());
        assertEquals(52, lokomotiveDampf.zugkraft());
    }


}
package abdullah.mola.zugapplication;

import static org.junit.Assert.*;
import static abdullah.mola.zugapplication.Lokomotive.Antriebsarten.Dampf;
import static abdullah.mola.zugapplication.Lokomotive.Antriebsarten.Diesel;
import static abdullah.mola.zugapplication.Lokomotive.Antriebsarten.Elektrisch;
import static abdullah.mola.zugapplication.Waggon.ArtenVonWagons.Güterwagen;
import static abdullah.mola.zugapplication.Waggon.ArtenVonWagons.Personenwagen;
import static abdullah.mola.zugapplication.Waggon.ArtenVonWagons.Schlafwagen;
import static abdullah.mola.zugapplication.Waggon.ArtenVonWagons.Speisewagen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class ZugTest {

    private ArrayList<Waggon> waggonArrayList;
    private ArrayList<Lokomotive> lokomotiveArrayList;
    private Zug zug, zugOhneWaggon;
    private Lokomotive lokomotiveElektrisch, lokomotiveDiesel, lokomotiveDampf;
    private Waggon schlafwagen, speisewagen, güterwagen, personenwagen;

    @Before
    public void setUpArrayList() {
        waggonArrayList = new ArrayList<>();
        lokomotiveArrayList = new ArrayList<>();
    }

    @Test
    public void testArrayListInit() {
        assertFalse(waggonArrayList.isEmpty());
        assertFalse(lokomotiveArrayList.isEmpty());
        assertFalse(waggonArrayList.size() == 0);
        assertFalse(lokomotiveArrayList.size() == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCapacity() {
        waggonArrayList = new ArrayList<>(-1);
        lokomotiveArrayList = new ArrayList<>(-1);
    }

    @Before
    public void testAddElements() {
        waggonArrayList.add(0, personenwagen);
        waggonArrayList.add(1, schlafwagen);
        waggonArrayList.add(2, speisewagen);
        waggonArrayList.add(3, güterwagen);
        assertEquals(personenwagen, waggonArrayList.get(0));
        assertEquals(schlafwagen, waggonArrayList.get(1));
        assertEquals(speisewagen, waggonArrayList.get(2));
        assertEquals(güterwagen, waggonArrayList.get(3));
        assertTrue(waggonArrayList.size() == 4);
        lokomotiveArrayList.add(0, lokomotiveDampf);
        lokomotiveArrayList.add(1, lokomotiveDiesel);
        lokomotiveArrayList.add(2, lokomotiveElektrisch);
        assertEquals(lokomotiveDampf, lokomotiveArrayList.get(0));
        assertEquals(lokomotiveDiesel, lokomotiveArrayList.get(1));
        assertEquals(lokomotiveElektrisch, lokomotiveArrayList.get(2));
    }

    @Test(expected = NullPointerException.class)
    public void testAddElementNull() {
        waggonArrayList.add(0, null);
    }

    @Test(expected = NullPointerException.class)
    public void testSetElementNull() {
        waggonArrayList.add(0, personenwagen);
        waggonArrayList.set(0, null);
    }

    @Before
    public void setUp() throws Exception {
        lokomotiveDampf = new Lokomotive(Dampf, "Rechteckig", "", 558, 505, 2000, 5, 100, 100, 50, 55, 55);
        lokomotiveElektrisch = new Lokomotive(Elektrisch, "Rechteckig", "", 558, 505, 2000, 10, 100, 100, 50, 55, 55);
        lokomotiveDiesel = new Lokomotive(Diesel, "Rechteckig", "", 558, 505, 2000, 2, 100, 100, 50, 55, 55);
        schlafwagen = new Waggon(Schlafwagen, "Rechteckig", "BMW", 1999, 516, 60, 20, 150, 100, 100, 50, 55);
        speisewagen = new Waggon(Speisewagen, "Rechteckig", "BMW", 1985, 527, 50, 20, 150, 100, 100, 50, 55);
        güterwagen = new Waggon(Güterwagen, "Rechteckig", "BMW", 1990, 538, 70, 20, 150, 100, 100, 50, 55);
        personenwagen = new Waggon(Personenwagen, "Rechteckig", "BMW", 2010, 539, 30, 20, 150, 100, 100, 50, 55);
        zug = new Zug(waggonArrayList, lokomotiveArrayList, 55);
        zugOhneWaggon = new Zug(lokomotiveArrayList, 120);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void remove() {
        zug.remove(waggonArrayList, lokomotiveArrayList);
        zugOhneWaggon.remove(null, lokomotiveArrayList);
    }

    @Test
    public void add() {
        zug.add(waggonArrayList, lokomotiveArrayList);
        zugOhneWaggon.add(null, lokomotiveArrayList);
    }

    @Test
    public void leergewichtZuges() {
        assertEquals(227, zug.leergewichtZuges());
        assertEquals(17, zugOhneWaggon.leergewichtZuges());
    }

    @Test
    public void leergewichtZugesNotEQuals() {

        assertNotEquals(0, zug.leergewichtZuges());
    }

    @Test
    public void maximaleAnzahlPassagierenProZug() {
        assertEquals(765, zug.maximaleAnzahlPassagierenProZug());
        assertEquals(165, zugOhneWaggon.maximaleAnzahlPassagierenProZug());
    }

    @Test
    public void maximaleZuladungsgewichtfürGüterproZug() {
        assertEquals(370, zug.maximaleZuladungsgewichtfürGüterproZug());
        assertEquals(150, zugOhneWaggon.maximaleZuladungsgewichtfürGüterproZug());

    }

    @Test
    public void maximaleZuladungZuges() {
        assertEquals(57745, zug.maximaleZuladungZuges());
        assertEquals(12525, zugOhneWaggon.maximaleZuladungZuges());
    }

    @Test
    public void maximaleGesamtgewichtZuges() {
        assertEquals(57972, zug.maximaleGesamtgewichtZuges());
        assertEquals(12542, zugOhneWaggon.maximaleGesamtgewichtZuges());
    }

    @Test
    public void längedesZuges() {
        assertEquals(380, zug.längedesZuges());
        assertEquals(300, zugOhneWaggon.längedesZuges());
    }

    @Test
    public void geprüftFalse() {
        assertFalse(zug.geprüft());
        assertFalse(zugOhneWaggon.geprüft());
    }

    @Test
    public void maximalbenötigtenSchaffnerproZug() {
        assertEquals(16, zug.maximalbenötigtenSchaffnerproZug());
        assertEquals(4, zugOhneWaggon.maximalbenötigtenSchaffnerproZug());
    }

    @Test
    public void minmumbenötigtenSchaffnerproZug() {
        assertEquals(1, zug.minmumbenötigtenSchaffnerproZug());
        assertEquals(1, zugOhneWaggon.minmumbenötigtenSchaffnerproZug());
    }
}

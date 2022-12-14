package abdullah.mola.zugapplication;

import java.util.Date;
import java.util.*;

public class Lokomotive {

    enum Antriebsarten {
        Diesel,
        Dampf,
        Elektrisch
    }

    public Antriebsarten antriebsarten;
    private String typenbezeichnung, hersteller;
    public int xPosition;
    private UUID serienNummer;
    private int baujahr;
    public final int leerGwicht, länge;
    public int anzahlPassagieren, maximalesZuladungsgewicht;
    public int maximaleAnzahlPassagieren;
    public UUID ZugSerialNumber;


    public Lokomotive(Antriebsarten antriebsarten, String typenbezeichnung, String hersteller, int xPosition, int serienNummer, int baujahr, int leerGwicht, int länge, int anzahlPassagieren, int maximalesZuladungsgewicht, int maximaleAnzahlPassagieren, int zugSerialNumber) {
        this.antriebsarten = antriebsarten;
        this.typenbezeichnung = typenbezeichnung;
        this.hersteller = hersteller;
        this.xPosition = xPosition;
        this.serienNummer = UUID.randomUUID();
        this.baujahr = baujahr;
        this.leerGwicht = leerGwicht;
        this.länge = länge;
        this.anzahlPassagieren = anzahlPassagieren;
        this.maximalesZuladungsgewicht = maximalesZuladungsgewicht;
        this.maximaleAnzahlPassagieren = maximaleAnzahlPassagieren;
        this.ZugSerialNumber = UUID.randomUUID();
    }
    public int zugkraft() {
        return maximalesZuladungsgewicht += leerGwicht;
    }

    public Antriebsarten getAntriebsarten() {
        return antriebsarten;
    }

    public void setAntriebsarten(Antriebsarten antriebsarten) {
        this.antriebsarten = antriebsarten;
    }

    public String getTypenbezeichnung() {
        return typenbezeichnung;
    }

    public void setTypenbezeichnung(String typenbezeichnung) {
        this.typenbezeichnung = typenbezeichnung;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public UUID getSerienNummer() {
        return serienNummer;
    }

    public void setSerienNummer(UUID serienNummer) {
        this.serienNummer = serienNummer;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }

    public int getLeerGwicht() {
        return leerGwicht;
    }

    public int getLänge() {
        return länge;
    }

    public int getAnzahlPassagieren() {
        return anzahlPassagieren;
    }

    public void setAnzahlPassagieren(int anzahlPassagieren) {
        this.anzahlPassagieren = anzahlPassagieren;
    }

    public int getMaximalesZuladungsgewicht() {
        return maximalesZuladungsgewicht;
    }

    public void setMaximalesZuladungsgewicht(int maximalesZuladungsgewicht) {
        this.maximalesZuladungsgewicht = maximalesZuladungsgewicht;
    }

    public int getMaximaleAnzahlPassagieren() {
        return maximaleAnzahlPassagieren;
    }

    public void setMaximaleAnzahlPassagieren(int maximaleAnzahlPassagieren) {
        this.maximaleAnzahlPassagieren = maximaleAnzahlPassagieren;
    }

    public UUID getZugSerialNumber() {
        return ZugSerialNumber;
    }

    public void setZugSerialNumber(UUID zugSerialNumber) {
        ZugSerialNumber = zugSerialNumber;
    }

}

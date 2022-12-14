package abdullah.mola.zugapplication;

import java.util.*;

class Waggon {
    public enum ArtenVonWagons {
        Personenwagen, Schlafwagen, Speisewagen, Güterwagen
    }

    private ArtenVonWagons waggonType;
    private String typenbezeichnung, hersteller;
    private int baujahr;
    private UUID serienNummer;
    public UUID ZugSerialNumber;
    public final int leerGwicht, länge;
    public int maximaleAnzahlPassagieren;
    public int xPosition;
    public int anzahlPassagieren, maximalesZuladungsgewicht;

    public Waggon(ArtenVonWagons waggonType, String typenbezeichnung, String hersteller, int baujahr, int serienNummer, int leerGwicht, int länge, int maximaleAnzahlPassagieren, int zugSerialNumber, int xPosition, int anzahlPassagieren, int maximalesZuladungsgewicht) {
        this.waggonType = waggonType;
        this.typenbezeichnung = typenbezeichnung;
        this.hersteller = hersteller;
        this.baujahr = baujahr;
        this.serienNummer = UUID.randomUUID();
        this.leerGwicht = leerGwicht;
        this.länge = länge;
        this.maximaleAnzahlPassagieren = maximaleAnzahlPassagieren;
        this.ZugSerialNumber = UUID.randomUUID();
        this.xPosition = xPosition;
        this.anzahlPassagieren = anzahlPassagieren;
        this.maximalesZuladungsgewicht = maximalesZuladungsgewicht;
    }
//    public Waggon(){}

    public ArtenVonWagons getWaggonType() {
        return waggonType;
    }

    public void setWaggonType(ArtenVonWagons waggonType) {
        this.waggonType = waggonType;
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

    public int getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }

    public UUID getSerienNummer() {
        return serienNummer;
    }

    public void setSerienNummer(UUID serienNummer) {
        this.serienNummer = serienNummer;
    }

    public int getLeerGwicht() {
        return leerGwicht;
    }

    public int getLänge() {
        return länge;
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

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
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


}
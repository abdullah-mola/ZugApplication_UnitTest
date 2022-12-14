package abdullah.mola.zugapplication;


import static abdullah.mola.zugapplication.Lokomotive.Antriebsarten.Dampf;
import static abdullah.mola.zugapplication.Waggon.ArtenVonWagons.Schlafwagen;

import java.util.*;

public class Zug {
    private ArrayList<Waggon> waggonList;
    private ArrayList<Lokomotive> lokomotiveListe;
    public UUID SerialNumber;

    public Zug(ArrayList<Lokomotive> lokomotiveListe, int serialNumber) {
        this.lokomotiveListe = lokomotiveListe;
        SerialNumber = UUID.randomUUID();
    }

    public Zug(ArrayList<Waggon> waggonList, ArrayList<Lokomotive> lokomotiveListe, int serialNumber) {
        this.waggonList = waggonList;
        this.lokomotiveListe = lokomotiveListe;
        SerialNumber = UUID.randomUUID();
    }

    public void remove(ArrayList<Waggon> waggonArrayList, ArrayList<Lokomotive> lokomotiveList) {
        if (waggonArrayList != null) {
            waggonList.forEach(x -> x.ZugSerialNumber = new UUID(0, 0));
            lokomotiveListe.forEach(x -> x.ZugSerialNumber = new UUID(0, 0));
            waggonList.removeAll(waggonArrayList);
            lokomotiveListe.remove(lokomotiveList);
        } else {
            lokomotiveListe.forEach(x -> x.ZugSerialNumber = new UUID(0, 0));
            lokomotiveListe.remove(lokomotiveList);
        }
    }

    public void add(ArrayList<Waggon> waggonArrayList, ArrayList<Lokomotive> lokomotiveList) {
        if (waggonArrayList != null) {
            waggonList.forEach(x -> x.ZugSerialNumber = this.SerialNumber);
            lokomotiveListe.forEach(x -> x.ZugSerialNumber = this.SerialNumber);
            waggonList.addAll(waggonArrayList);
            lokomotiveListe.addAll(lokomotiveList);
        } else {
            lokomotiveListe.forEach(x -> x.ZugSerialNumber = this.SerialNumber);
            lokomotiveListe.addAll(lokomotiveList);
        }
    }

    public int leergewichtZuges() {
        if (waggonList != null) {
            return waggonList.stream().mapToInt(x -> x.leerGwicht).sum() +
                    lokomotiveListe.stream().mapToInt(x -> x.leerGwicht).sum();
        } else {
            return lokomotiveListe.stream().mapToInt(x -> x.leerGwicht).sum();
        }
    }

    public int maximaleAnzahlPassagierenProZug() {
        if (waggonList != null) {
            return waggonList.stream().mapToInt(x -> x.maximaleAnzahlPassagieren).sum() +
                    lokomotiveListe.stream().mapToInt(x -> x.maximaleAnzahlPassagieren).sum();
        } else {
            return lokomotiveListe.stream().mapToInt(x -> x.maximaleAnzahlPassagieren).sum();
        }
    }

    public int maximaleZuladungsgewichtfürGüterproZug() {
        if (waggonList != null) {
            return waggonList.stream().mapToInt(x -> x.maximalesZuladungsgewicht).sum() +
                    lokomotiveListe.stream().mapToInt(x -> x.maximalesZuladungsgewicht).sum();
        } else {
            return lokomotiveListe.stream().mapToInt(x -> x.maximalesZuladungsgewicht).sum();
        }
    }

    public int maximaleZuladungZuges() {
        return maximaleAnzahlPassagierenProZug() * 75 + maximaleZuladungsgewichtfürGüterproZug();

    }

    public int maximaleGesamtgewichtZuges() {
        if (waggonList != null) {
            return maximaleZuladungZuges() +
                    waggonList.stream().mapToInt(x -> x.leerGwicht).sum() +
                    lokomotiveListe.stream().mapToInt(x -> x.leerGwicht).sum();
        } else {
            return maximaleZuladungZuges() + lokomotiveListe.stream().mapToInt(x -> x.leerGwicht).sum();
        }
    }

    public int längedesZuges() {
        if (waggonList != null) {
            return waggonList.stream().mapToInt(x -> x.länge).sum() +
                    lokomotiveListe.stream().mapToInt(x -> x.länge).sum();
        } else {
            return lokomotiveListe.stream().mapToInt(x -> x.länge).sum();
        }
    }

    public boolean geprüft() {
        if (waggonList != null) {
            return maximaleAnzahlPassagierenProZug() * 75 +
                    lokomotiveListe.stream().mapToInt(x -> x.leerGwicht).sum() +
                    lokomotiveListe.stream().mapToInt(x -> x.maximalesZuladungsgewicht).sum() +
                    waggonList.stream().mapToInt(x -> x.leerGwicht).sum() +
                    waggonList.stream().mapToInt(x -> x.maximalesZuladungsgewicht).sum() <=
                    lokomotiveListe.stream().mapToInt(x -> x.zugkraft()).sum();
        } else {
            return maximaleAnzahlPassagierenProZug() * 75 +
                    lokomotiveListe.stream().mapToInt(x -> x.leerGwicht).sum() +
                    lokomotiveListe.stream().mapToInt(x -> x.maximalesZuladungsgewicht).sum() <=
                    lokomotiveListe.stream().mapToInt(x -> x.zugkraft()).sum();
        }
    }

    public int maximalbenötigtenSchaffnerproZug() {
        int maxPassenger = maximaleAnzahlPassagierenProZug();
        return maxPassenger == 0 ? 0 :
                maxPassenger % 50 > 0 ? maxPassenger / 50 + 1 : maxPassenger / 50;

    }

    public int minmumbenötigtenSchaffnerproZug() {
        return maximaleAnzahlPassagierenProZug() > 0 ? 1 : 0;

    }

    public ArrayList<Waggon> getWaggonList() {
        return waggonList;
    }

    public void setWaggonList(ArrayList<Waggon> waggonList) {
        this.waggonList = waggonList;
    }

    public ArrayList<Lokomotive> getLokomotiveListe() {
        return lokomotiveListe;
    }

    public void setLokomotiveListe(ArrayList<Lokomotive> lokomotiveListe) {
        this.lokomotiveListe = lokomotiveListe;
    }

    public UUID getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(UUID serialNumber) {
        SerialNumber = serialNumber;
    }
}





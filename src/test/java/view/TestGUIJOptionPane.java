package view;

import API.APIOutput;
import API.UserInteraction;

import javax.swing.*;

public class TestGUIJOptionPane {

    public static void main(String[] args) {

        String start = null, ziel = null;

        start = JOptionPane.showInputDialog("Bitte geben Sie für eine genaue Routenberechnung Straßenname Hausnummer, Postleitzahl und Stadt ihres STARTPUNKTES ein\n Beispiel: Davertweg 25, 48308 Senden");
        if(start != null && !start.equals("")) ziel = JOptionPane.showInputDialog("Bitte geben Sie für eine genaue Routenberechnung Straßenname Hausnummer, Postleitzahl und Stadt ihres ZIELPUNKTES ein\n Beispiel: Gievenbecker Reihe 32, 48161 Münster");

        Object[] vehicles = {"car", "foot", "bike", "scooter"};
        Object fahrzeug = null;
        if(ziel != null && !ziel.equals("")) fahrzeug = JOptionPane.showInputDialog(null, "Welches Fahrzeug moechten Sie nutzen?", "Eingabe", JOptionPane.INFORMATION_MESSAGE, null, vehicles, vehicles[0]);
        String fahrzeugS = null;
        Object eingabe = null;
        if(fahrzeug != null) {
            fahrzeugS = fahrzeug.toString();
            Object[] options = {"Routenberechung starten", "Abbrechen"};
            eingabe = JOptionPane.showInputDialog(null, "Was moechten Sie tun?", "Eingabe", JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        }


        if (eingabe != null && eingabe.equals("Routenberechung starten")) {

            UserInteraction anfrage = new UserInteraction(start, ziel, fahrzeugS);
            APIOutput Route = anfrage.getOutput();
            System.out.println("Wegbeschreibung: ");

            for (int i = 0; i < Route.getRoutenStruktur().size() - 1; i++) {

                String a = i + ":";
                String b = Route.getStrukturdistance().get(i).intValue() + " m";
                String c = Route.getStrukturtime().get(i).getTime();
                String d = "    " + Route.getRoutenStruktur().get(i);

                System.out.printf("%-10s %10s %15s %-10s \n", a, b, c, d);
            }
            System.out.println("");
            System.out.println(Route.getRoutenStruktur().get(Route.getRoutenStruktur().size() - 1));
            System.out.print("Distanz in Meter: ");
            System.out.println(Route.getTotalDistanceInMetres());
            System.out.print("Distanz in Kilometer: ");
            System.out.println(Route.getTotalDistanceInKilometres());
            System.out.print("Reisezeit: ");
            System.out.println(Route.getTotalTime().getTime());

        }


    }

}

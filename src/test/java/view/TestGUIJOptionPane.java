package view;

import API.APIOutput;
import API.UserInteraction;

import javax.swing.*;
import java.awt.*;

public class TestGUIJOptionPane {

    public static void main(String[] args) {

        String start = null, ziel = null;

        start = JOptionPane.showInputDialog("Bitte geben Sie für eine genaue Routenberechnung Straßenname Hausnummer, Postleitzahl und Stadt ihres STARTPUNKTES ein\n Beispiel: Musterstraße 99, 12345 Musterstadt");
        if(start != null && !start.equals("")) ziel = JOptionPane.showInputDialog("Bitte geben Sie für eine genaue Routenberechnung Straßenname Hausnummer, Postleitzahl und Stadt ihres ZIELPUNKTES ein\n Beispiel: Musterstraße 99, 12345 Musterstadt");

        Object[] vehicles = {"car", "foot", "bike", "scooter"};
        Object fahrzeug = null;
        if(ziel != null && !ziel.equals("")) fahrzeug = JOptionPane.showInputDialog(null, "Welches Fahrzeug moechten Sie nutzen?", "Eingabe", JOptionPane.INFORMATION_MESSAGE, null, vehicles, vehicles[0]);
        String fahrzeugS = null;
        int eingabe = 1;
        if(fahrzeug != null) {
            fahrzeugS = fahrzeug.toString();
            //Object[] options = {"Routenberechung starten", "Abbrechen"};
            eingabe = JOptionPane.showConfirmDialog(null, "Routenberechnung starten?", "Routenberechnung", JOptionPane.YES_NO_OPTION, 1);
        }


        if (eingabe == 0) {

            UserInteraction anfrage = new UserInteraction(start, ziel, fahrzeugS);
            APIOutput Route = anfrage.getOutput();
            String e = "Wegbeschreibung:\n";

            for (int i = 0; i < Route.getRoutenStruktur().size() - 1; i++) {

                String a = i + ":";
                a = "      ".substring(a.length()) + a;
                String b = Route.getStrukturdistance().get(i).intValue() + " m";
                b = "          ".substring(b.length()) + b;
                String c = Route.getStrukturtime().get(i).getTime();
                c = "           ".substring(c.length()) + c;
                String d = "    " + Route.getRoutenStruktur().get(i);

                e = e +  a + b + c + d + "\n";
            }
            String metadaten = Route.getRoutenStruktur().get(Route.getRoutenStruktur().size() - 1) + "\n" +
                    "Distanz in Metern: " + Route.getTotalDistanceInMetres() + "\n" +
                    "Distanz in Kilometern: " + Route.getTotalDistanceInKilometres() + "\n" +
                    "Reisezeit: " + Route.getTotalTime().getTime();

            JTextArea textArea = new JTextArea(e + "\n" + metadaten);
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
            JOptionPane.showMessageDialog(null, scrollPane, "Wegbeschreibung",
                    JOptionPane.OK_OPTION, null);

        }


    }

}

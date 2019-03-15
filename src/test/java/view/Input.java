package view;

import java.sql.SQLOutput;
import java.util.Scanner;
import API.*;


public class Input {

    private String start,ziel,fahrzeug;

    public static void main(String[] args)
    {
        // Erzeugung eines neuen Objektes
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte geben Sie für eine genaue Routenberechnung Straßenname Hausnummer, Postleitzahl und Stadt ihres Starts und Ziels ein");
        System.out.print("start: ");
        String start = sc.nextLine();
        System.out.print("ziel: ");
        String ziel = sc.nextLine();
        System.out.print("fahrzeug: ");
        String fahrzeug = sc.nextLine();

        // Einlesen der Eingabe in den String "eingabe"
        while (sc.hasNext()){
        String eingabe = sc.nextLine();

        // Schließen des Scanners (nicht nötig, aber empfohlen)

        // Ausgabe der Eingabe

        if(eingabe.toLowerCase().equals("exit")){
            sc.close();
            return;
        }
        if(eingabe.equals("help")){
            System.out.println("help - Zeigt die Hilfe an");
            System.out.println("start - Input für Start");
            System.out.println("ziel - Input für Ziel");
            System.out.println("Verfügbare Fahrzeuge: car -> Auto, foot -> Zu Fuß, bike -> Fahrrad und scooter -> Mopped " );

        }

        if (eingabe.equals("berechne")) {
                UserInteraction anfrage = new UserInteraction( start, ziel, fahrzeug);
                APIOutput Route =anfrage.getOutput();
                System.out.print("Wegbeschreibung: ");
                //System.out.println(Route.getRoutenStruktur());
                for(String r : Route.getRoutenStruktur()){
                    System.out.println(r);
                }
                System.out.print("Distanz in Meter: ");
                System.out.println(Route.getTotalDistanceInMetres());
                System.out.print("Distanz in Kilometer: ");
                System.out.println(Route.getTotalDistanceInKilometres());
                System.out.print("Zeit in Minuten: ");
                System.out.println(Route.getTotalTime());
        }
    if (eingabe.equals("help start")){



    }




    }

    }
    public Input ()
    {
        // Erzeugung eines neuen Objektes
        Scanner sc = new Scanner(System.in);
      // Einlesen der Eingabe in den String "eingabe"
        String eingabe = sc.nextLine();
        System.out.println(eingabe);
      // Schließen des Scanners (nicht nötig, aber empfohlen)
        sc.close();

      // Ausgabe der Eingabe
        System.out.println(eingabe);

    }
}

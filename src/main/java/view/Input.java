package main.java.view;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;
import main.java.API.*;



public class Input {

    private String start,ziel,fahrzeug;

    public static void main(String[] args)
    {
        // Erzeugung eines neuen Objektes
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte geben Sie für eine genaue Routenberechnung Straßenname Hausnummer, Postleitzahl und Stadt ihres Starts und Ziels ein");
        System.out.print("start: ");
        String start = sc.nextLine();
        if(start.equals("")) start="Bruchtal";
        System.out.print("ziel: ");
        String ziel = sc.nextLine();
        if(ziel.equals("")) ziel="Mordor";
        System.out.print("fahrzeug: ");
        String fahrzeug = sc.nextLine();
        if(fahrzeug.equals("")) fahrzeug="foot";

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


        if (eingabe.equals("exec")||eingabe.equals("")) {
            exec(start, ziel, fahrzeug);
        }




        /**
 * {
 UserInteraction anfrage = new UserInteraction( start, ziel, fahrzeug);
 APIOutput Route =anfrage.getOutput();
 System.out.println("Wegbeschreibung: ");

 //System.out.println(Route.getRoutenStruktur());

 for(int i=0;i<Route.getRoutenStruktur().size()-1;i++){
 String a = i+":";
 String b = Route.getStrukturdistance().get(i).intValue()+" m";
 String c = Route.getStrukturtime().get(i).getTime();
 String d = "    "+Route.getRoutenStruktur().get(i);

 System.out.printf("%-10s %10s %15s %-10s \n" , a, b, c, d);
 //System.out.println("");

 //System.out.print("Weg in Meter:");
 //System.out.print(i+":   ");
 //System.out.print("   "+Route.getStrukturdistance().get(i).intValue()+" m");
 //System.out.print("   "+Route.getStrukturtime().get(i).longValue());
 //System.out.print("   "+Route.getRoutenStruktur().get(i));
 }
 System.out.println("");
 System.out.println(Route.getRoutenStruktur().get(Route.getRoutenStruktur().size()-1));
 System.out.print("Distanz in Meter: ");
 System.out.println(Route.getTotalDistanceInMetres());
 System.out.print("Distanz in Kilometer: ");
 System.out.println(Route.getTotalDistanceInKilometres());
 System.out.print("Reisezeit: ");
 System.out.println(Route.getTotalTime().getTime());
 }*/

    if (eingabe.equals("start-f")){
        System.out.print("Startpunkt angeben: ");
        eingabe = sc.nextLine();

        List<String> auswahl = GeoCoding.getList(eingabe);
        for(String j : auswahl)
        {
            System.out.printf("%-3s %s \n", (auswahl.indexOf(j)+1)+":", j);
        }
        System.out.print("Bitte Vorschlagsnummer angeben: ");
        System.out.println("");
        int index = sc.nextInt()-1;
        System.out.println(auswahl.get(index));

        String startf = auswahl.get(index);




        System.out.print("Zielpunkt angeben: ");
        sc.nextLine();

        String eingabez = sc.nextLine();

        List<String> auswahlz = GeoCoding.getList(eingabez);
        for(String j : auswahlz)
        {
            System.out.printf("%-3s %s \n", (auswahlz.indexOf(j)+1)+":", j);
        }
        System.out.print("Bitte Vorschlagsnummer angeben: ");
        int indexz = sc.nextInt();
        indexz--;
        System.out.println(auswahlz.get(indexz));
        String zielf = auswahlz.get(indexz);

        System.out.print("Fahrzeug angeben: ");
        sc.nextLine();
        String fahrzeugf = sc.nextLine();

        exec(startf, zielf, fahrzeugf);



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

    private static void exec(String start, String ziel, String fahrzeug) {
        UserInteraction anfrage = new UserInteraction(start, ziel, fahrzeug);
        APIOutput Route = anfrage.getOutput();
        System.out.println("Wegbeschreibung: ");

        //System.out.println(Route.getRoutenStruktur());

        for (int i = 0; i < Route.getRoutenStruktur().size() - 1; i++) {
            String a = i + ":";
            String b = Route.getStrukturdistance().get(i).intValue() + " m";
            String c = Route.getStrukturtime().get(i).getTime();
            String d = "    " + Route.getRoutenStruktur().get(i);

            System.out.printf("%-10s %10s %15s %-10s \n", a, b, c, d);
            //System.out.println("");

            //System.out.print("Weg in Meter:");
            //System.out.print(i+":   ");
            //System.out.print("   "+Route.getStrukturdistance().get(i).intValue()+" m");
            //System.out.print("   "+Route.getStrukturtime().get(i).longValue());
            //System.out.print("   "+Route.getRoutenStruktur().get(i));
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

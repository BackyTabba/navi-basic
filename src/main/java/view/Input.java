package main.java.view;

import java.util.List;
import java.util.Scanner;
import main.java.API.*;

import static jdk.nashorn.internal.runtime.ScriptingFunctions.exec;


public class Input
{
    /**
     * A main method which creates a console input.
     * There you can enter the start, finish and mode of transportation for a desired route.
     * Then you will get printed version of the description of route and the total time and distance travelled
     * @param args commandline parameters
     */
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte geben Sie für eine genaue Routenberechnung Straßenname Hausnummer, Postleitzahl und Stadt ihres Starts und Ziels ein");

        System.out.print("start: ");
        String start = sc.nextLine();
        if(start.equals("")) start="Bruchtal";

        //testgelände!!!!
        boolean search = false;
        int nrOfWords = start.split( "(\\s|\\p{Punct})+" ).length;
        System.out.println( nrOfWords );
        if(nrOfWords == 1) search = true;
        if(nrOfWords == 2) search = false;//hat funktioniert!!!!hghghghghgh
        if(nrOfWords == 3) search = true;
        if(nrOfWords >= 4) search = false;
        //testgelände!!!!




        //if (start.equals("search"))         alte Frage
        if(search == true)                  //neue Frage
        {
            System.out.print("Startpunkt angeben: ");
            String eingabe = sc.nextLine();

            List<String> auswahl = UserInteraction.getList(eingabe);
            for(int i = 0; i < auswahl.size(); i++)
            {
                System.out.printf("%-4s %s \n", (i+1)+":", auswahl.get(i));
            }
            System.out.print("Bitte Vorschlagsnummer angeben: ");
            System.out.println("");
            int index = sc.nextInt()-1;
            System.out.println(auswahl.get(index));

            String startf = auswahl.get(index);

            System.out.print("Zielpunkt angeben: ");
            sc.nextLine();

            String eingabez = sc.nextLine();

            List<String> auswahlz = UserInteraction.getList(eingabez);
            for(int i = 0; i < auswahlz.size(); i++)
            {
                System.out.printf("%-4s %s \n", (i+1)+":", auswahlz.get(i));
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

            sc.close();

        }

        System.out.print("ziel: ");
        String ziel = sc.nextLine();
        if(ziel.equals("")) ziel="Mordor";
        System.out.print("fahrzeug: ");
        String fahrzeug = sc.nextLine();
        if(fahrzeug.equals("")) fahrzeug="foot";


        while (sc.hasNext())
        {
            String eingabe = sc.nextLine();


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

            if (eingabe.equals("exec")||eingabe.equals(""))
            {
                exec(start, ziel, fahrzeug);
            }

        }

    }

    /**
     * A method for calling the navi-basic API. It needs a String of the start, the finish and vehicle of route.
     * It prints of the properties of the route-object on to the console.
     * @param start The starting adress of your desired route as a String
     * @param ziel The adress of your planned goalpoint as a String
     * @param fahrzeug The mode of transportation you wish to use as a String
     */
    private static void exec(String start, String ziel, String fahrzeug)
    {
        UserInteraction anfrage = new UserInteraction(start, ziel, fahrzeug);
        APIOutput Route = anfrage.getOutput();
        System.out.println("Wegbeschreibung: ");

        //System.out.println(Route.getRoutenStruktur());

        for (int i = 0; i < Route.getRoutenStruktur().size() - 1; i++)
        {
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

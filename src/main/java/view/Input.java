package main.java.view;

import java.io.IOException;
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
     * @param args
     */
    public static void main(String[] args){

        //Asking for input "start"
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte geben sie ihre Startadresse an.");
        System.out.print("Start: ");
        String start = sc.nextLine();

        //Asks if start is precise or not
        boolean search = false;
        boolean breaker = false;
        int nrOfWords = start.split( "(\\s|\\p{Punct})+" ).length;
        if(start.split( "(\\s|\\p{Punct})+" )[0].equals("")) nrOfWords--;
        if(nrOfWords == 0) {
            search = false;
            System.out.println("Sie haben nichts eingegeben.\n Möchten sie das Programm neu starten?\n Andernfalls wird es beendet.\n (j/n)");
            String input = sc.nextLine();
            if(input.equals("j")) main(new String[0]);
                else if(!input.equals("n")) {
                    while(!input.equals("j") && !input.equals("n")) {
                        System.out.println("Das machst du doch extra! Ich lass mich aber nicht veräppeln! Du versuchst das jetzt nocheinmal!");
                        input = sc.nextLine();
                    }
                System.err.print("Ich beende mich jetzt trotzdem.");
                }
            breaker = true;
        }
        if(nrOfWords == 1) search = true;
        if(nrOfWords == 2) search = false;
        if(nrOfWords == 3) search = true;
        if(nrOfWords >= 4) search = false;

        //If start is not precise, give options to the user.
        if(search && !breaker){
            System.out.println("Bitte warten, Vorschläge werden gesucht.");
            List<String> auswahl = UserInteraction.getList(start);
            if(auswahl.size() != 0) {
                for (int i = 0; i < auswahl.size(); i++) {
                    System.out.printf("%-4s %s \n", (i + 1) + ":", auswahl.get(i));
                }
                System.out.print("Bitte Vorschlagsnummer angeben: ");
                System.out.println("");
                int index = sc.nextInt() - 1;
                System.out.println(auswahl.get(index));
                start = auswahl.get(index);
                sc.nextLine();
            }else{
                System.out.println("Leider konnten keine vorschläge für die Anfrage gestellt werden.\n Das Programm wird neu gestartet...");
                main(new String[0]);
                breaker = true;
            }
        }

        //Asking for input "ziel"
        String ziel = "";
        if(!breaker) {
            System.out.println("Bitte geben sie ihren Zielpunkt an.");
            System.out.print("Ziel: ");
            ziel = sc.nextLine();

            //Asks if ziel is precise or not
            nrOfWords = ziel.split("(\\s|\\p{Punct})+").length;
            if(ziel.split( "(\\s|\\p{Punct})+" )[0].equals("")) nrOfWords--;
            if(nrOfWords == 0) {
                search = false;
                System.out.println("Sie haben nichts eingegeben.\n Möchten sie das Programm neu starten?\n Andernfalls wird es beendet.\n (j/n)");
                String input = sc.nextLine();
                if(input.equals("j")) main(new String[0]);
                else if(!input.equals("n")) {
                    while(!input.equals("j") && !input.equals("n")) {
                        System.out.println("Das machst du doch extra! Ich lass mich aber nicht veräppeln! Du versuchst das jetzt nocheinmal!");
                        input = sc.nextLine();
                    }
                    System.err.print("Ich beende mich jetzt trotzdem.");
                }
                breaker = true;
            }
            if (nrOfWords == 1) search = true;
            if (nrOfWords == 2) search = false;
            if (nrOfWords == 3) search = true;
            if (nrOfWords >= 4) search = false;
        }

        //If ziel is not precise, give options to the user.
        if(search && !breaker) {
            System.out.println("Bitte warten, Vorschläge werden gesucht.");
            List<String> auswahl = UserInteraction.getList(ziel);
            if(auswahl.size() != 0) {
                for (int i = 0; i < auswahl.size(); i++) {
                    System.out.printf("%-4s %s \n", (i + 1) + ":", auswahl.get(i));
                }
                System.out.print("Bitte Vorschlagsnummer angeben: ");
                System.out.println("");
                int index = sc.nextInt() - 1;
                System.out.println(auswahl.get(index));
                ziel = auswahl.get(index);
                sc.nextLine();
            }else{
                System.out.println("Leider konnten keine vorschläge für die Anfrage gestellt werden.\n Das Programm wird neu gestartet...");
                main(new String[0]);
                breaker = true;
            }
        }

        //Asks for a "fahrzeug"
        if(!breaker) {
            System.out.println("Bitte geben sie das Fahrzeug an, mit dem sie reisen möchen.");
            System.out.print("Fahrzeug: ");
            String vehicle = sc.nextLine();

            //If fahrzeug is not precise, ask again, repeat 5 times.
            int versuche = 5;
            while ((versuche != 0) && (!vehicle.equals("car")) && (!vehicle.equals("foot")) && (!vehicle.equals("bike")) && (!vehicle.equals("scooter"))) {
                if (versuche > 1)
                    System.out.println("Das angegebene Fahrzeug kenne ich nicht. Bitte geben sie eines der folgenden an: 'car', 'foot', 'bike', 'scooter'." +
                            " Noch " + versuche + " Versuche übrig.");
                else
                    System.out.println("Das angegebene Fahrzeug kenne ich nicht. Bitte geben sie eines der folgenden an: 'car', 'foot', 'bike', 'scooter'." +
                            " Sie haben noch einen Versuch!");
                System.out.println("Fahrzeug: ");
                vehicle = sc.nextLine();
                versuche--;
            }

            //If everything is clear, call exec.
            if ((versuche != 0) && ((vehicle.equals("car")) || (vehicle.equals("foot")) || (vehicle.equals("bike")) || (vehicle.equals("scooter")))) {
                System.out.println("start: " + start + " Ziel: " + ziel + " vehicle: " + vehicle);
                exec(start, ziel, vehicle);
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
        System.out.println("marker");
        APIOutput Route = anfrage.getOutput();
        System.out.println("Wegbeschreibung: ");


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

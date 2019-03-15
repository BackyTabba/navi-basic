public class main {
public main(){


    /**
     *Erstellt ein UserInteraction Objekt.
     *Das UserInteraction Objekt erstellt ein APIOutput Objekt, das es zusammen mit alles Parametern an Connection weiterreicht.
     *Connection ruft Translator auf.
     *Translator uebersetzt die Antwort der externen API und fuellt APIOutput ueber die setter Methoden.
     *UserInteraction kennt die ganze Zeit das APIOutput Objekt, darum kann die Klasse das auch zurueck geben.
     */
    }
    public static void main(String[] args){
        UserInteraction userInteraction = new UserInteraction(51.960447, 51.964801, 7.581380, 7.599747, "car");
        System.out.println(userInteraction.getOutput().getTotalDistanceInMetres() + " finished");
    }
}

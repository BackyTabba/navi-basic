package API;

public class main {
public main(){


    /**
     *Erstellt ein API.UserInteraction Objekt.
     *Das API.UserInteraction Objekt erstellt ein API.APIOutput Objekt, das es zusammen mit alles Parametern an API.Connection weiterreicht.
     *API.Connection ruft API.Translator auf.
     *API.Translator uebersetzt die Antwort der externen API und fuellt API.APIOutput ueber die setter Methoden.
     *API.UserInteraction kennt die ganze Zeit das API.APIOutput Objekt, darum kann die Klasse das auch zurueck geben.
     */
    }
    public static void main(String[] args){
        UserInteraction userInteraction = new UserInteraction(51.960447, 51.964801, 7.581380, 7.599747, "car");
    }
}

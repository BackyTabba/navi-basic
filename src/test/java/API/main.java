package API;

//import org.apache.commons.lang3.StringUtils;

//import org.apache.commons.lang.StringUtils.*;

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
    public static void mann(String[] args){

        Long mil = 1040701L;
        Time time = new Time(mil);
        System.out.println(time.getHours());
        System.out.println(time.getMinutes());
        System.out.println(time.getSeconds());
        System.out.println(time.getMilliseconds());
        System.out.println(time.getTime());


    }

    public static void main(String args[]){
        String test = "hello";
        String filler = "          ".substring(test.length()) + test;
        System.out.println(test);
        System.out.println(filler);
    }
}

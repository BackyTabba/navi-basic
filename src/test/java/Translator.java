import com.graphhopper.directions.api.client.model.ResponseInstruction;
import com.graphhopper.directions.api.client.model.ResponseInstructions;
import com.graphhopper.directions.api.client.model.RouteResponse;
import com.graphhopper.directions.api.client.model.RouteResponsePath;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * Ein Klasse zur Realisierung von Translator Objekten.
 * Ein Translator Objekt wird durch die Angabe eines rohroute und einer Translation instantiiert.
 */
public class Translator {

     private RouteResponse rohroute;
     private ArrayList<String> instructions;
     private double totalTimeInMinutes;
     private double totalDistanceInMetres;
     private double totalDistanceInKilometres;



    /**
     * Der Konstruktor der Translator-Klasse anhand einer rohroute.
     * Zudem wird das translation-Attribut des Objektes durch die Translate-Methode erzeugt.
     * @param rohroute Die rohroute als RouteResponse Objekt.
     */
     public Translator(APIOutput route, RouteResponse rohroute)
     {
         this.rohroute    = rohroute;
         this.instructions = translateInstructions(this.rohroute);
         this.totalTimeInMinutes   = translateTotalTimeInMinutes(this.rohroute);
         this.totalDistanceInMetres = translateTotalDistanceInMetres(this.rohroute);
         this.totalDistanceInKilometres = translateTotalDistanceInKilometres((this.rohroute));



         route.setRoutenStruktur(this.instructions);
         route.setTotalTime(this.totalTimeInMinutes);
         route.setTotalDistanceInMetres(this.totalDistanceInMetres);
         route.setTotalDistanceInKilometres(this.totalDistanceInKilometres);
         //Route route = new Route(this.instructions, this.totalTimeInMinutes, this.totalDistanceInMetres, this.totalDistanceInKilometres);

     }

    /**
     * Methode zur Erstellung einer Routenbeschreibung aus einem RouteResponse-Objekt.
     * @param rohroute Die rohroute als RouteResponse-Objekt
     * @return Die Routenbeschreibung als ArrayList mit String-Objekten
     */
     public ArrayList<String> translateInstructions(RouteResponse rohroute)
     {
         RouteResponsePath path = rohroute.getPaths().get(0);
         ResponseInstructions instr = path.getInstructions();
         ArrayList<String> translation = new ArrayList<String>();

         for(int i = 0; i < instr.size(); i++)
         {
            translation.add(i, instr.get(i).getText());
         }


         //System.out.println(translation); debugging only
         return translation;
     }

     public double translateTotalTimeInMinutes(RouteResponse rohroute){

        RouteResponsePath path = rohroute.getPaths().get(0);
        return path.getTime()/60000;
     }

     public double translateTotalDistanceInMetres(RouteResponse rohroute){
         RouteResponsePath path = rohroute.getPaths().get(0);
         return path.getDistance();
     }

     public double translateTotalDistanceInKilometres(RouteResponse rohroute){
         RouteResponsePath path = rohroute.getPaths().get(0);
         return path.getDistance()/1000;
     }
}

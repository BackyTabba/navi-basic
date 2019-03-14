import com.graphhopper.directions.api.client.model.ResponseInstruction;
import com.graphhopper.directions.api.client.model.ResponseInstructions;
import com.graphhopper.directions.api.client.model.RouteResponse;
import com.graphhopper.directions.api.client.model.RouteResponsePath;

import java.util.ArrayList;
import java.util.List;

/**
 * Ein Klasse zur Realisierung von Translator Objekten.
 * Ein Translator Objekt wird durch die Angabe eines rohroute und einer Translation instantiiert.
 */
public class Translator {

     private RouteResponse rohroute;
     private ArrayList<String> translation;

    /**
     * Der Konstruktor der Translator-Klasse anhand einer rohroute.
     * Zudem wird das translation-Attribut des Objektes durch die Translate-Methode erzeugt.
     * @param rohroute Die rohroute als RouteResponse Objekt.
     */
     public Translator(RouteResponse rohroute)
     {
         this.rohroute    = rohroute;
         this.translation = translate(this.rohroute);

     }

    /**
     * Methode zur Erstellung einer Routenbeschreibung aus einem RouteResponse-Objekt.
     * @param rohroute Die rohroute als RouteResponse-Objekt
     * @return Die Routenbeschreibung als ArrayList mit String-Objekten
     */
     public ArrayList<String> translate(RouteResponse rohroute)
     {
         RouteResponsePath path = rohroute.getPaths().get(0);
         ResponseInstructions instr = path.getInstructions();
         ArrayList<String> translation = new ArrayList<String>();

         for(int i = 0; i < instr.size(); i++)
         {
            translation.add(i, instr.get(i).getText());
         }


         System.out.println(translation);
         return translation;
     }
}

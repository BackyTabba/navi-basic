import com.graphhopper.directions.api.client.model.RouteResponse;

/**
 * Ein Klasse zur Realisierung von Translator Objekten.
 * Ein Translator Objekt wird durch die Angabe eines rohroute und einer Translation instantiiert.
 */
public class Translator {

     private RouteResponse rohroute;
     private String translation;

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
     * @return Die Routenbeschreibung als String
     */
     public String translate(RouteResponse rohroute)
     {
         System.out.println("Wir haben es geschafft!");
         return null;
     }
}

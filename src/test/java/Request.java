import com.graphhopper.directions.api.client.ApiException;
import com.graphhopper.directions.api.client.api.RoutingApi;
import com.graphhopper.directions.api.client.model.RouteResponse;

import java.util.Arrays;
import java.util.List;

/**
 * Eine Klasse zur Realisierung von Request-Objekten.
 * Ein Request-Objekt wird durch die Anagbe eines Starts, eines Ziels, eines Fahrzeuges sowie einer Response instantiiert.
 */
public class Request {

    private String start;
    private String ziel;
    private String fahrzeug;
    private RouteResponse response;

    /**
     * Der Konstruktor der Request-Klasse anhand eines Starts, eines Ziels und eines Fahrzeugs.
     * Zusaetzlich wird der Response Wert des Objektes mit der Methode anfrage generiert.
     * Und es wir ein Translator mit dieser Response instantiiert.
     * @param start Der Start-Wert des Request-Objektes als String
     * @param ziel Der Ziel-Wert des Request-Objektes als String
     * @param fahrzeug Der fahrzeug-Wert des Request-Objektes als String
     */
    public Request(String start, String ziel, String fahrzeug)
    {
        this.start    = start;
        this.ziel     = ziel;
        this.fahrzeug = fahrzeug;

        this.response = anfrage(start, ziel, fahrzeug);

        Translator translator = new Translator(this.response);
    }


    /**
     * Eine Methode welche der Graphhoppper API eine Anfrage über die schnellste Route zwischen zwei Koordinaten mit beliebigem Fortbewegungsmittel auf Deutsch.
     * @param punkt1 Der Startpunkt im Koordinatenformat(Breitengrad, Laengengrad) der Route als String
     * @param punkt2 Der Zielpunkt im Koordinatenformat(Breitengrad, Laengengrad) der Route als String
     * @param fortbewegung Die gewuenschte Fortbewegungsmethode als String in der Abkuerzungformat der Graphhopper API
     * @return Die gesuchte Route als RouteResponse Objekt
     */
    public RouteResponse anfrage( String punkt1, String punkt2, String fortbewegung ){

        RoutingApi apiInstance = new RoutingApi();
        List<String> point = Arrays.asList(punkt1, punkt2);
        String key = "603dac65-1037-453a-916f-fb788bebabf5";
        String vehicle = fortbewegung;

        try {
            RouteResponse result = apiInstance.routeGet(point, false, key, "de", true, vehicle, true, true, Arrays.<String>asList(), false, "fastest", null, null, null, null, null,null,null, null, null, null, null,null);
            //System.out.println(result);
            return result;

        } catch (ApiException e) {
            System.err.println("Exception when calling RoutingApi#routeGet");
            e.printStackTrace();
            return null;
        }
    }
}

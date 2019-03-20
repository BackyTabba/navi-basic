package main.java.API;

import com.graphhopper.directions.api.client.ApiException;
import com.graphhopper.directions.api.client.api.GeocodingApi;
import com.graphhopper.directions.api.client.model.GeocodingLocation;
import com.graphhopper.directions.api.client.model.GeocodingPoint;
import com.graphhopper.directions.api.client.model.GeocodingResponse;

import java.util.List;


/**
 * A class for the realisation of GeoCoding tasks.
 */
public class GeoCoding {

    /**
     * A method to get a List of GeoccdingLocations  from the Graphhoppper API.
     * To get the location which is to be geocoded you have to enter a String of the adress.
     * @param adress The adress of the location you wish to geocode
     * @return List of GeocodingLocations which fit your adress
     */
    public static List<GeocodingLocation> getResult(String adress)
    {
        GeocodingApi apiInstance = new GeocodingApi();
        String key = "603dac65-1037-453a-916f-fb788bebabf5";
        String locale = "de";
        Integer limit = 100;
        Boolean reverse = false;
        String point = "";
        String provider = "default";
        try {
            GeocodingResponse result = apiInstance.geocodeGet(key, adress, locale, limit, reverse, point, provider);

            return result.getHits();

        } catch (ApiException e) {
            System.err.println("An Critical error occured in the Response by Graph Hopper.\n Please check the input!");
            return null;
        }
    }

    /**
     * A method for the determination of the coordinates of an specific adress.
     * @param adress The adress for which you want the coordinates as a String
     * @return the coordinates as String in the format "Latitude,Longitude"
     */
    public static String geocode(String adress)

    {
        if(adress != null && !adress.equals("")) {
            GeocodingPoint punkt = getResult(adress).get(0).getPoint();
            String x = punkt.getLat().toString();
            String y = punkt.getLng().toString();

            String coordinates = x + "," + y;

            return coordinates;
        }else{
            System.err.println("The String adress should contain informations and can't be null or empty.");
            return null;
        }
    }
}

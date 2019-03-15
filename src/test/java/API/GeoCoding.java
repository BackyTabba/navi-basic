package API;

import com.graphhopper.directions.api.client.ApiException;
import com.graphhopper.directions.api.client.api.GeocodingApi;
import com.graphhopper.directions.api.client.model.GeocodingLocation;
import com.graphhopper.directions.api.client.model.GeocodingPoint;
import com.graphhopper.directions.api.client.model.GeocodingResponse;


/**
 *
 *
 */
public class GeoCoding {

private static double breite=1000,lang=1000;

    public static void main(String[] args)
    {
        geocode("Münster");
    }

    public static double getBreite() {
        return breite;
    }

    public static double getLang() {
        return lang;
    }

    public static String geocode(String q)

    {
        GeocodingApi apiInstance = new GeocodingApi();
        String key = "603dac65-1037-453a-916f-fb788bebabf5"; // String | Get your key at graphhopper.com
        //q = "Heisenbergstraße 2"; // String | If you do forward geocoding, then this would be a textual description of the adress you are looking for. If you do reverse geocoding this would be in lat,lon.
        String locale = "de"; // String | Display the search results for the specified locale. Currently French (fr), English (en), German (de) and Italian (it) are supported. If the locale wasn't found the default (en) is used.
        Integer limit = 100; // Integer | Specify the maximum number of returned results
        Boolean reverse = false; // Boolean | Set to true to do a reverse Geocoding request
        String point = ""; // String | The location bias in the format 'latitude,longitude' e.g. point=45.93272,11.58803
        String provider = "default"; // String | Can be either, default, nominatim, opencagedata
        try {
            GeocodingResponse result = apiInstance.geocodeGet(key, q, locale, limit, reverse, point, provider);

            GeocodingPoint punkt =result.getHits().get(0).getPoint();
            String coordinates =punkt.toString();

            return coordinates;

            //System.out.println(result.getHits().size());
            //for(GeocodingLocation g : result.getHits()){
                //System.out.println(g.getName() +" : "+  g.getPoint().getLat()+","+g.getPoint().getLng());
            //}
            //System.out.println(result.getHits().get(0).getCity()+" "+breite+","+lang);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeocodingApi#geocodeGet");
            e.printStackTrace();
            return "";
        }

    }
}

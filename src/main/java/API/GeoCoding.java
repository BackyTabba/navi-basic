package main.java.API;

import com.graphhopper.directions.api.client.ApiException;
import com.graphhopper.directions.api.client.api.GeocodingApi;
import com.graphhopper.directions.api.client.model.GeocodingLocation;
import com.graphhopper.directions.api.client.model.GeocodingPoint;
import com.graphhopper.directions.api.client.model.GeocodingResponse;

import java.util.ArrayList;
import java.util.List;


/**
 *
 *
 */
public class GeoCoding {

private static double breite=1000,lang=1000;


    public static void main(String[] args)
    {
        for ( String f :getList("Münster")){
            System.out.println(f);
        }
    }

    private static List<GeocodingLocation> getResult(String q)
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

            return result.getHits();
            //System.out.println(result.getHits().size());
            //for(GeocodingLocation g : result.getHits()){
            //System.out.println(g.getName() +" : "+  g.getPoint().getLat()+","+g.getPoint().getLng());
            //}
            //System.out.println(result.getHits().get(0).getCity()+" "+breite+","+lang);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeocodingApi#geocodeGet");
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> getList(String f)
    {
        List<GeocodingLocation> results = getResult(f);
        List<String> rueckgabe = new ArrayList<String>();

        for (int i = 0; i < results.size();i++)
        {
            String temp= results.get(i).getName();
            if (results.get(i).getStreet() != null) temp=temp+", "+results.get(i).getStreet();
            if (results.get(i).getHousenumber() != null) temp=temp+" "+results.get(i).getHousenumber();
            if (results.get(i).getPostcode() != null) temp=temp+ ", "+results.get(i).getPostcode();
            if (results.get(i).getCity() != null) temp=temp+" "+results.get(i).getCity();
            if (results.get(i).getCity() == null && results.get(i).getPostcode() != null) temp = temp+" "+results.get(i).getName();
            if (results.get(i).getCountry() != null) temp=temp+", "+results.get(i).getCountry();

                rueckgabe.add(i ,temp);
        }

        return  rueckgabe;
    }


    public static String geocode(String q)

    {
            GeocodingPoint punkt =getResult(q).get(0).getPoint();
            String x = punkt.getLat().toString();
            String y = punkt.getLng().toString();

            String coordinates = x+","+y;

            return coordinates;
    }
}

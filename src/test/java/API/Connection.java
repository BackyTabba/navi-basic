package API;

import com.graphhopper.directions.api.client.ApiException;
import com.graphhopper.directions.api.client.api.RoutingApi;
import com.graphhopper.directions.api.client.model.RouteResponse;


import java.util.Arrays;
import java.util.List;

/**
 * The class API.Connection calls the external API Graph hopper and creates a API.Translator object, giving the answer to it.
 */
public class Connection {

    /**
     * The konstruktor creates a API.Translator object and calls the class anfrage.
     * @APIOutput route should be the APIRoute object created in API.UserInteraction.
     * @String start should be the coordinates of the starting point.
     * @String ziel should be the coordinates of the destination point.
     * @String fahrzeug should be the vehicle you are using.
     */
    public Connection(APIOutput route, String start, String ziel, String fahrzeug)
    {
        Translator translator = new Translator(route, anfrage(start, ziel, fahrzeug));
    }


    /**
     * This Method calls the external API Graph Hopper to compute given arguments.
     * @param punkt1 should be the starting point.
     * @param punkt2 should be the destination point.
     * @param fortbewegung should be the vehicle used for the route.
     * @return RouteResponse will be an object returned by the external API.
     */
    public RouteResponse anfrage( String punkt1, String punkt2, String fortbewegung ){

        RoutingApi apiInstance = new RoutingApi();
        List<String> point = Arrays.asList(punkt1, punkt2);
        String key = "603dac65-1037-453a-916f-fb788bebabf5";
        String vehicle = fortbewegung;

        try {
            RouteResponse result = apiInstance.routeGet(point, false, key, "de", true, vehicle, true, true, Arrays.<String>asList(), false, "fastest", null, null, null, null, null,null,null, null, null, null, null,null);
            return result;


        } catch (ApiException e) {
            System.err.println("Exception when calling RoutingApi#routeGet");
            e.printStackTrace();
            return null;
        }
    }
}

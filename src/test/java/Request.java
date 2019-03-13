import com.graphhopper.directions.api.client.ApiException;
import com.graphhopper.directions.api.client.api.RoutingApi;
import com.graphhopper.directions.api.client.model.RouteResponse;

import java.util.Arrays;
import java.util.List;

public class Request {

    private String start;
    private String ziel;
    private String fahrzeug;

    public Request(String start, String ziel, String fahrzeug)
    {
        this.start = start;
        this.ziel  = ziel;
        this.fahrzeug = fahrzeug;

        anfrage(start, ziel, fahrzeug);
    }



    public void anfrage( String punkt1, String punkt2, String fortbewegung ){

        RoutingApi apiInstance = new RoutingApi();
        List<String> point = Arrays.asList(punkt1, punkt2); // List<String> | Specify multiple points for which the route should be calculated. The order is important. Specify at least two points.
        Boolean pointsEncoded = false; // Boolean | IMPORTANT- TODO - currently you have to pass false for the swagger client - Have not found a way to force add a parameter. If `false` the coordinates in `point` and `snapped_waypoints` are returned as array using the order [lon,lat,elevation] for every point. If `true` the coordinates will be encoded as string leading to less bandwith usage. You'll need a special handling for the decoding of this string on the client-side. We provide open source code in [Java](https://github.com/graphhopper/graphhopper/blob/d70b63660ac5200b03c38ba3406b8f93976628a6/web/src/main/java/com/graphhopper/http/WebHelper.java#L43) and [JavaScript](https://github.com/graphhopper/graphhopper/blob/d70b63660ac5200b03c38ba3406b8f93976628a6/web/src/main/webapp/js/ghrequest.js#L139). It is especially important to use no 3rd party client if you set `elevation=true`!
        String key = "603dac65-1037-453a-916f-fb788bebabf5"; // String | Get your key at graphhopper.com
        String locale = "de"; // String | The locale of the resulting turn instructions. E.g. `pt_PT` for Portuguese or `de` for German
        Boolean instructions = true; // Boolean | If instruction should be calculated and returned
        String vehicle = fortbewegung; // String | The vehicle for which the route should be calculated. Other vehicles are foot, bike, motorcycle, hike, ...
        Boolean elevation = true; // Boolean | If `true` a third dimension - the elevation - is included in the polyline or in the GeoJson. If enabled you have to use a modified version of the decoding method or set points_encoded to `false`. See the points_encoded attribute for more details. Additionally a request can fail if the vehicle does not support elevation. See the features object for every vehicle.
        Boolean calcPoints = true; // Boolean | If the points for the route should be calculated at all printing out only distance and time.
        List<String> pointHint = Arrays.asList(); // List<String> | Optional parameter. Specifies a hint for each `point` parameter to prefer a certain street for the closest location lookup. E.g. if there is an address or house with two or more neighboring streets you can control for which street the closest location is looked up.
        Boolean chDisable = false; // Boolean | Use this parameter in combination with one or more parameters of this table
        String weighting = "fastest"; // String | Which kind of 'best' route calculation you need. Other option is `shortest` (e.g. for `vehicle=foot` or `bike`), `short_fastest` if time and distance is expensive (e.g. for `vehicle=truck`) and `curvature` (only for `vehicle=motorcycle`)
        Boolean edgeTraversal = null; // Boolean | Use `true` if you want to consider turn restrictions for bike and motor vehicles. Keep in mind that the response time is roughly 2 times slower.
        String algorithm = null; // String | The algorithm to calculate the route. Other options are `dijkstra`, `astar`, `astarbi`, `alternative_route` and `round_trip`
        Integer heading = null; // Integer | Favour a heading direction for a certain point. Specify either one heading for the start point or as many as there are points. In this case headings are associated by their order to the specific points. Headings are given as north based clockwise angle between 0 and 360 degree. This parameter also influences the tour generated with `algorithm=round_trip` and force the initial direction.
        Integer headingPenalty = null; // Integer | Penalty for omitting a specified heading. The penalty corresponds to the accepted time delay in seconds in comparison to the route without a heading.
        Boolean passThrough = null; // Boolean | If `true` u-turns are avoided at via-points with regard to the `heading_penalty`.
        Integer roundTripDistance = null; // Integer | If `algorithm=round_trip` this parameter configures approximative length of the resulting round trip
        Long roundTripSeed = null; // Long | If `algorithm=round_trip` this parameter introduces randomness if e.g. the first try wasn't good.
        Integer alternativeRouteMaxPaths = null; // Integer | If `algorithm=alternative_route` this parameter sets the number of maximum paths which should be calculated. Increasing can lead to worse alternatives.
        Integer alternativeRouteMaxWeightFactor = null; // Integer | If `algorithm=alternative_route` this parameter sets the factor by which the alternatives routes can be longer than the optimal route. Increasing can lead to worse alternatives.
        Integer alternativeRouteMaxShareFactor = null; // Integer | If `algorithm=alternative_route` this parameter specifies how much alternatives routes can have maximum in common with the optimal route. Increasing can lead to worse alternatives.
        List<String> details = null; // List<String> | Specify multiple points for which the route should be calculated. The order is important. Specify at least two points.
        String avoid = null;
        try {
            RouteResponse result = apiInstance.routeGet(point, pointsEncoded, key, locale, instructions, vehicle, elevation, calcPoints, pointHint, chDisable, weighting, edgeTraversal, algorithm, heading, headingPenalty, passThrough,details,roundTripDistance, roundTripSeed, alternativeRouteMaxPaths, alternativeRouteMaxWeightFactor, alternativeRouteMaxShareFactor,avoid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling RoutingApi#routeGet");
            e.printStackTrace();
        }
    }
}

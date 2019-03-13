        import com.graphhopper.directions.api.client.ApiException;
        import com.graphhopper.directions.api.client.api.RoutingApi;
        import com.graphhopper.directions.api.client.model.ResponseInstruction;
        import com.graphhopper.directions.api.client.model.RouteResponse;
        import com.graphhopper.directions.api.client.model.RouteResponsePath;

        import java.util.Arrays;

/**
 * A simple example for querying the Routing API.
 */
public class Routingexample {
    public static void main(String[] args) {
        new Routingexample().start();
    }

    private void start() {
        RoutingApi routing = new RoutingApi();
        String key = System.getProperty("graphhopper.key", "603dac65-1037-453a-916f-fb788bebabf5");
        try {
            RouteResponse rsp = routing.routeGet(Arrays.asList("48.58467,11.57753", "48.572859,11.592464"), false, key,
                    "de", true, "car", true, true, Arrays.<String>asList(), false,
                    "fastest", null, null, null, null, null,
                    null, null, null, null, null, null, null);
            RouteResponsePath path = rsp.getPaths().get(0);
            ResponseInstruction instr = path.getInstructions().get(0);
            System.out.println(instr.getText());
        } catch (ApiException ex) {
            System.out.println(ex.getResponseBody());
            throw new RuntimeException(ex);
        }
    }
}


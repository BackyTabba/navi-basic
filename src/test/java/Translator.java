import com.graphhopper.directions.api.client.model.ResponseInstructions;
import com.graphhopper.directions.api.client.model.RouteResponse;
import com.graphhopper.directions.api.client.model.RouteResponsePath;

import java.util.ArrayList;

/**
 * This class computes the RouteResponse to a usable format.
 */
public class Translator {

    /**
     * The konstructor calls methods of his own class and fills the APIOutput object with the results.
     * @param route should be the APIOutput object witch is createt in UserInteraction.
     * @param rohroute should be the RouteResponse object, given by the external API.
     */
     public Translator(APIOutput route, RouteResponse rohroute)
     {
         route.setRoutenStruktur(translateInstructions(rohroute));
         route.setTotalTime(translateTotalTimeInMinutes(rohroute));
         route.setTotalDistanceInMetres(translateTotalDistanceInMetres(rohroute));
         route.setTotalDistanceInKilometres(translateTotalDistanceInKilometres(rohroute));
     }

    /**
     * This method dragges the instructions out of RouteResponse.
     * @param rohroute should be the RouteResponse object given by the external API.
     * @return ArrayList<String> will be the dragged out ArrayList.
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

    /**
     * This method dragges the totalTimeInMs out of RouteResponse and computes it to Mintues.
     * @param rohroute should be the RouteResponse object given by the external API.
     * @return double will be the amount of needed minutes to travel the route.
     */
     public double translateTotalTimeInMinutes(RouteResponse rohroute){

        RouteResponsePath path = rohroute.getPaths().get(0);
        return path.getTime()/60000;
     }

    /**
     * This method dragges the total amount of metres needed to travel the route.
     * @param rohroute should be the RouteResponse object given by the external API
     * @return double will be the amount of metres needed to travel the route.
     */
     public double translateTotalDistanceInMetres(RouteResponse rohroute){
         RouteResponsePath path = rohroute.getPaths().get(0);
         return path.getDistance();
     }

    /**
     * This method dragges the needed meters out of RouteResponse and convertes it to kilometres.
     * @param rohroute should be the RouteResponse object given by the external API
     * @return double will be the kilometers needed to travel to arrive the destination.
     */
     public double translateTotalDistanceInKilometres(RouteResponse rohroute){
         RouteResponsePath path = rohroute.getPaths().get(0);
         return path.getDistance()/1000;
     }
}

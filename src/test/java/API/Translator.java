package API;

import com.graphhopper.directions.api.client.model.ResponseInstructions;
import com.graphhopper.directions.api.client.model.RouteResponse;
import com.graphhopper.directions.api.client.model.RouteResponsePath;



import java.util.ArrayList;
import java.util.Date;




/**
 * This class computes the RouteResponse to a usable format.
 */
public class Translator {

    /**
     * The konstructor calls methods of his own class and fills the API.APIOutput object with the results.
     * @param route should be the API.APIOutput object witch is createt in API.UserInteraction.
     * @param rohroute should be the RouteResponse object, given by the external API.
     */
     public Translator(APIOutput route, RouteResponse rohroute)
     {
         translateInstructions(route, rohroute);
         route.setTotalTimeAsDate(translateTotalTimeAsDate(rohroute));
         route.setTotalDistanceInMetres(translateTotalDistanceInMetres(rohroute));
         route.setTotalDistanceInKilometres(translateTotalDistanceInKilometres(rohroute));
     }



    /**
     * This method dragges the instructions out of RouteResponse.
     * @param rohroute should be the RouteResponse object given by the external API.
     * @return ArrayList<String> will be the dragged out ArrayList.
      */
     public void translateInstructions(APIOutput route,RouteResponse rohroute)
     {
         RouteResponsePath path = rohroute.getPaths().get(0);
         ResponseInstructions instr = path.getInstructions();
         ArrayList<String> EText = new ArrayList<String>();
         ArrayList<Integer> EZeit = new ArrayList<Integer>();
         ArrayList<Double> EWeg = new ArrayList<Double>();

         for(int i = 0; i < instr.size(); i++)
         {
            EText.add(i, instr.get(i).getText());
            EWeg.add(i, instr.get(i).getDistance());
            EZeit.add(i, instr.get(i).getTime());

         }
         route.setRoutenStruktur(EText);
         route.setStrukturdistance(EWeg);
         route.setStrukturtime(EZeit);

         //System.out.println(translation); debugging only

     }

    /**
     * This method dragges the totalTimeInMs out of RouteResponse and computes it to Mintues.
     * @param rohroute should be the RouteResponse object given by the external API.
     * @return double will be the amount of needed minutes to travel the route.
     */
     public Date translateTotalTimeAsDate(RouteResponse rohroute){

         RouteResponsePath path = rohroute.getPaths().get(0);
         Date result = new Date(path.getTime().longValue());
         return result;
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

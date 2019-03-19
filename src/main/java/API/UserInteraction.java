package main.java.API;

import com.graphhopper.directions.api.client.model.GeocodingLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class API.UserInteraction stores the userinput given to run the API.
 * Then it creates an API.APIOutput Object and finaly creates an API.Connection object, giving all informations with it.
 */
public class UserInteraction{

    /**
    * Declaration of needed Objects and Variables
    * @double x1, x2, y1, y2 are Coordinates witch will be set in the Konstruktor.
    * @vehicle will be the used vehicle.
     * @route will be an empty API.APIOutput object witch will be filled in API.Translator.
     */
    private double x1,x2,y1,y2;
    private String vehicle;
    APIOutput route = new APIOutput();




    /**
    * The konstruktor creates all needed variables, creates an API.APIOutput Object and reaches everything to the finaly created API.Connection object.
    * @double x1, x2, y1, y2 should be the start(x1,y1) and the finish(x2,y2) coordinates.
    * @String vehicle should be the used vehicle.
     */
    public UserInteraction(double x1, double x2, double y1, double y2, String vehicle){
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        this.vehicle=vehicle;

        String startX = String.valueOf(this.x1);
        String startY = String.valueOf(this.y1);

        String destinationX = String.valueOf(this.x2);
        String destinationY = String.valueOf(this.y2);


        String start = startX + "," + startY;
        String destination = destinationX + "," + destinationY;



        Connection request = new Connection(this.route, start, destination, vehicle);

    }

    public UserInteraction(String x, String y, String vehicle){
        Connection request = new Connection(this.route, GeoCoding.geocode(x), GeoCoding.geocode(y), vehicle);
    }

    /**
     * @return API.APIOutput will be the calculated route.
     */
    public APIOutput getOutput(){
        return route;
    }

    public static List<String> getList(String f)
    {
        List<GeocodingLocation> results = GeoCoding.getResult(f);
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

}

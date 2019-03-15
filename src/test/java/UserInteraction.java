/**
 * The Class UserInteraction stores the userinput given to run the API.
 * Then it creates an APIOutput Object and finaly creates an Connection object, giving all informations with it.
 */
public class UserInteraction{

    /**
    * Declaration of needed Objects and Variables
    * @double x1, x2, y1, y2 are Coordinates witch will be set in the Konstruktor.
    * @vehicle will be the used vehicle.
     * @route will be an empty APIOutput object witch will be filled in Translator.
     */
    private double x1,x2,y1,y2;
    private String vehicle;
    APIOutput route = new APIOutput();




    /**
    * The konstruktor creates all needed variables, creates an APIOutput Object and reaches everything to the finaly created Connection object.
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

    /**
     * @return APIOutput will be the calculated route.
     */
    public APIOutput getOutput(){
        return route;
    }
}

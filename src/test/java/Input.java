/*
The Class Input stores the userinput given to run the API
 */
public class Input{

    /*
    Deklarierung der Variablen und Objekte
    Deklaration and initialisation of needed variables and objects.
    @double x1, x2, y1, y2 are Coordinates witch will be set in the Konstruktor.
    @Route route is the Route-object, witch will be dragged through the Programm and ejected at the End.
    @vehicle will be the used vehicle.
     */
    private double x1,x2,y1,y2;
    private String vehicle;


    /*
    The Konstruktor asks and initializes the needed variables for the rout-computing in the external API, then it opens creates Test_API-object.
    @double x1, x2, y1, y2 should be the start(x1,y1) and the finish(x2,y2) coordinates.
    @String vehicle should be the used vehicle.
     */
    public Input (double x1, double x2, double y1, double y2, String vehicle){
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
        //System.out.println(start);            debuggmode only
        //System.out.println(destination);      debuggmode only

        Request request = new Request(start, destination, vehicle);
    }

    /*
    Returns Array with values : {x1,x2,y1,y2}
    @return double {x1,x2,y1,y2}
     */
    public double[] getValues(){
        double[] ruck = {x1,x2,y1,y2};
        return ruck;
    }
}

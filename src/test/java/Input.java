/*
The Class Input stores the userinput given to run the API
 */
public class Input{

    /*
    Deklarierung der Variablen und Objekte
    Deklaration and initialisation of needed variables and objects.
    @double x1, x2, y1, y2 are Coordinates witch will be set in the Konstruktor.
    @Route route is the Route-object, witch will be dragged through the Programm and ejected at the End.
     */
    private double x1,x2,y1,y2;
    private Route route = new Route();

    /*
    The Konstruktor asks and initializes the needed variables for the rout-computing in the external API.
    @double x1, x2, y1, y2 should be the start(x1,y1) and the finish(x2,y2) coordinates.
     */
    public Input (double x1, double x2, double y1, double y2){
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
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

/*
Needed archives are imported here.
@java.util.ArrayList
 */
import java.util.ArrayList;

/*
This Class Contains the route-detials wich are ejected to the user in the end.
 */
public class APIOutput {

    /*
    Declaration and inizialisation of the needed variables
    @List<String> routenStruktur will contain informations given in the konstruktor about the route.
    @DateTimeFormater totalTime will contain informations given in the konstruktor about the time needed to travel the route.
    @double totalDistanceInMeters will contain informations about the route total travel distance.
    @double totalDistanceInKilometres will contain informations about the route total travel distance.
     */
    private ArrayList<String> routenStruktur;
    private double totalTime;
    private double totalDistanceInMetres;
    private double totalDistanceInKilometres;



    /*
    This is the "Konstruktor".
    @List<String> routenStruktur should contain instruktions about the route.
    @DateTimeFormater totalTime should be the time you need to travel the route.
    @double totalDistanceInMeters should be the distance to travel to reach the destination in metres.
    @double totalDistanceInKilometres should be the distance to travel to reach the destination in kilometres.
     */
    public APIOutput(){}

    /**
    *Returns RoutenStruktur.
    *@return ArrayList<String> RoutenStruktur
     */
    public ArrayList<String> getRoutenStruktur(){
        return this.routenStruktur;
    }

    /**
     * Sets RoutenStruktur.
     * @ArrayList<String> RoutenStruktur
     */
    public void setRoutenStruktur(ArrayList<String> pRoutenStruktur){
        this.routenStruktur = pRoutenStruktur;
    }

    /**
    *Returns totaltime.
    *@return double totalTime
     */
    public double getTotalTime(){
        return this.totalTime;
    }

    /**
     * Sets totalTime.
     * @double totalTime
     */
    public void setTotalTime(double pTotalTime){
        this.totalTime = pTotalTime;
    }

    /**
    *Returns totalDistanceInMetres.
    *@return double totelDistanceInMetres
     */
    public double getTotalDistanceInMetres(){
        return this.totalDistanceInMetres;
    }

    /**
     * Sets totalDistanceInMetres.
     * @double totalDistanceInMetres
     */
    public void setTotalDistanceInMetres(double pTotalDistanceInMetres){
        this.totalDistanceInMetres = pTotalDistanceInMetres;
    }

    /**
    *Returns totalDistanceInKilometres.
    *@return double totelDistanceInKilometres
     */
    public double getTotalDistanceInKilometres(){
        return this.totalDistanceInKilometres;
    }

    /**
     * Sets totalDistanceInKilometres.
     * @double pDistanceInKilometres
     */
    public void setTotalDistanceInKilometres(double pTotalDistanceInKilometres){
        this.totalDistanceInKilometres = pTotalDistanceInKilometres;
    }


}

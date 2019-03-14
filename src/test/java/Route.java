/*
Needed archives are imported here.
@java.util.ArrayList
@java.util.List
 */
import org.threeten.bp.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

/*
This Class Contains the route-detials wich are ejected to the user in the end.
 */
public class Route {

    /*
    Declaration and inizialisation of the needed variables
    @List<String> routenStruktur will contain informations given in the konstruktor about the route.
    @DateTimeFormater totalTime will contain informations given in the konstruktor about the time needed to travel the route.
    @double totalDistanceInMeters will contain informations about the route total travel distance.
    @double totalDistanceInKilometres will contain informations about the route total travel distance.
     */
    private List<String> routenStruktur;
    private DateTimeFormatter totalTime;
    private double totalDistanceInMetres;
    private double totalDistanceInKilometres;

    /*
    This is the Konstruktor.
    @List<String> routenStruktur should contain instruktions about the route.
    @DateTimeFormater totalTime should be the time you need to travel the route.
    @double totalDistanceInMeters should be the distance to travel to reach the destination in metres.
    @double totalDistanceInKilometres should be the distance to travel to reach the destination in kilometres.
     */
    public Route(List<String> pRoutenStruktur, DateTimeFormatter pTotalTime, double pTotalDistanceInMetres, double pTotalDistanceInKilometres){
        this.routenStruktur = pRoutenStruktur;
        this.totalTime = pTotalTime;
        this.totalDistanceInMetres = pTotalDistanceInMetres;
        this.totalDistanceInKilometres = pTotalDistanceInKilometres;
    }

    /*
    Returns RoutenStruktur.
    @return List<String> RoutenStruktur
     */
    public List<String> getRoutenStruktur(){
        return this.routenStruktur;
    }

    /*
    Returns totaltime.
    @return DateTimeFormatter totalTime
     */
    public DateTimeFormatter totalTime(){
        return this.totalTime;
    }

    /*
    Returns totalDistanceInMetres.
    @return double totelDistanceInMetres
     */
    public double totelDistanceInMetres(){
        return this.totalDistanceInMetres;
    }

    /*
    Returns totalDistanceInKilometres.
    @return double totelDistanceInKilometres
     */
    public double totelDistanceInKilometres(){
        return this.totalDistanceInKilometres;
    }
}

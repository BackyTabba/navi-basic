package main.java.API;

import java.util.ArrayList;
import java.util.List;


/**
 * This class contains all informations about the route.
 */
public class APIOutput {

    /**
     * Needed Variables are declarated here.
     * @routenStruktur will contain instructions to travel the route.
     * @totalTime will be the total amount of minutes needed to travel the route.
     * @totalDistanceInMetres will contain the total amount of metres needed to travel the route.
     * @totalDistanceInKilometres will contain the total amount of kilometres needed to travel the route.
     */
    private ArrayList<String> routenStruktur;
    private ArrayList<Double> strukturdistance;
    private ArrayList<Time> strukturtime;
    private ArrayList<String> strukturBemerkung;
    private ArrayList<String> strukturStraße;
    private Time totalTime;
    private double totalDistanceInMetres;
    private double totalDistanceInKilometres;


    /**
     * The konstructor do nothing.
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

    public ArrayList<Double> getStrukturdistance() {
        return strukturdistance;
    }

    public void setStrukturdistance(ArrayList<Double> strukturdistance) {
        this.strukturdistance = strukturdistance;
    }

    public ArrayList<Time> getStrukturtime() {
        return strukturtime;
    }

    public void setStrukturtime(ArrayList<Time> strukturtime) {
        this.strukturtime = strukturtime;
    }

    /**
    *Returns totaltime.
    *@return double totalTime
     */
    public Time getTotalTime(){
        return this.totalTime;
    }

    /**
     * Sets totalTime.
     * @double totalTime
     */
    public void setTotalTimeAsDate(Time pTotalTime){
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

    public void setStrukturBemerkung(ArrayList<String> strukturBemerkung) {
        this.strukturBemerkung = strukturBemerkung;
    }

    public ArrayList<String> getStrukturBemerkung() {
        return strukturBemerkung;
    }

    public void setStrukturStraße(ArrayList<String> strukturStraße) {
        this.strukturStraße = strukturStraße;
    }

    public ArrayList<String> getStrukturStraße() {
        return strukturStraße;
    }

    public List<OutputPoints>toPoints()
    {
        List<OutputPoints> punkteListe = new ArrayList<OutputPoints>();
        for(int i = 0; i < this.routenStruktur.size()-1;i++)
        {
            String text = this.getRoutenStruktur().get(i);
            String zeit = this.getStrukturtime().get(i).getTime();
            double distanz = this.getStrukturdistance().get(i);
            String straße = this.getStrukturStraße().get(i);
            String bemerkung = this.getStrukturBemerkung().get(i);
            OutputPoints punkt = new OutputPoints(text,distanz,zeit,straße,bemerkung,i);

            punkteListe.add(i, punkt);
        }
        OutputPoints last = new OutputPoints("Gesamt",this.getTotalDistanceInKilometres(),this.getTotalTime().getTime(),null,null,this.routenStruktur.size()+1);
        punkteListe.add(last);
        return punkteListe;
    }


}

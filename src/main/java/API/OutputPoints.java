package main.java.API;

public class OutputPoints {

    private int schritt;
    private String text;
    private double distance;
    private String time;
    private String straße;
    private String bemerkung;


    public OutputPoints(String text, double distance, String time, String straße,String bemerkung, int schritt)
    {
        this.text = text;
        this.distance = distance;
        this.time = time;
        this.schritt = schritt;
        this.straße = straße;
        this.bemerkung = bemerkung;
    }

    public String getText() {
        return text;
    }

    public String getStraße() {
        return straße;
    }
}

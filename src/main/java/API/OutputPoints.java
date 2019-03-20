package main.java.API;

public class OutputPoints {

    private int schritt;
    private String text;
    private double distance;
    private String time;


    public OutputPoints(String text, double distance, String time, int schritt)
    {
        this.text = text;
        this.distance = distance;
        this.time = time;
        this.schritt = schritt;
    }

    public String getText() {
        return text;
    }


}

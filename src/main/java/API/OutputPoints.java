package main.java.API;

public class OutputPoints {
    private String text;
    private double distance;
    private Time time;

    public OutputPoints(String text, double distance, Time time)
    {
        this.text = text;
        this.distance = distance;
        this.time = time;
    }

    public String getText() {
        return text;
    }


}

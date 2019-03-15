package API;

public class Time {

    private Long timeInMs;

    public Time(Long pTimeInMs){

        this.timeInMs = pTimeInMs;

    }

    public Long getMilliseconds(){
        return timeInMs;
    }

    public Long getSeconds(){
        return timeInMs/1000;
    }

    public double getMinutes(){
        return timeInMs/60000;
    }

    public double getHours(){
        return timeInMs/3600000;
    }

    public double getDays(){
        return timeInMs/86400000;
    }
}

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

    public Long getMinutes(){
        return timeInMs/60000;
    }

    public Long getHours(){
        return timeInMs/3600000;
    }

    public Long getDays(){
        return timeInMs/86400000;
    }

    /**
     * Returns String in an individual Timeformat.
     * @return String
     */
    public String getTime(){
        if(Math.round(getHours()) != 0 && Math.round(getMinutes()) != 0)
            return Math.round(getHours()) + ":" + Math.round(getMinutes()%(getHours()*60)) + ":" + Math.round((getSeconds()%(getMinutes()*60)));
        else if(Math.round(getHours()) != 0)
            return Math.round(getMinutes()) + ":" + Math.round(getSeconds());
        else
            return "" + Math.round(getSeconds());
    }
}

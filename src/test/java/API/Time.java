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
        long h,m,s;
        h=getHours();
        m=getMinutes()%60;
        s=getSeconds()%60;
        String hh,mm,ss,ff;
        if(false) hh = "0" + h;
            else hh = "" + h;
        if(m<10&&h>0) mm="0"+m;
            else mm=""+m;
        if(s<10&& m>0 || h>0) ss = "0" + s;
            else ss = "" + s;
            if (h>0) ff=hh + ":" + mm + ":" + ss + " " +"h  ";
                    else if (m>0) ff = mm + ":" + ss + " " + "min";
                        else ff = ss + " " + "sec";

        return ff;
    }
}

package main.java.API;


import com.graphhopper.directions.api.client.model.RouteResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static java.lang.Float.MAX_VALUE;

/**
 * Test class.
 * @version test
 */
public class TestClass {

    public TestClass(){}

    @Before
    public void setUp(){}

    @After
    public void tearDown(){}

    /**
     * Testing Time class
     */
    @Test
    public void checkTimeClass(){
        new Time(Long.MAX_VALUE);
        new Time(0L);
        Time time = new Time(-Long.MAX_VALUE);
        time.getDays();
        time.getHours();
        time.getMinutes();
        time.getSeconds();
        time.getMilliseconds();
    }

    /**
     * Testing Translator class
     */
    @Test
    public void checkTranslatorClass(){
        new Translator(null, null);
        new Translator(new APIOutput(), new RouteResponse());
    }

    /**
     * Testing APIOutput class
     */
    @Test
    public void checkAPIOutputClass(){
        APIOutput apioutput = new APIOutput();

        //Method .setRoutenstruktur(ArrayList<String>())
        apioutput.setRoutenStruktur(null);
        apioutput.setRoutenStruktur(new ArrayList<String>());

        //Method .setStrukturDistance(ArrayList<double>).
        //apioutput.getStrukturdistance(null);
        //apioutput.getStrukturdistance(new ArrayList<Double>());

        //Methoden get- und setStrukturTime.

        //Methoden getTotalTime und setTotalTimeAsDate.
        apioutput.getTotalTime();
        apioutput.setTotalTimeAsDate(null);
        apioutput.getTotalTime();
        apioutput.setTotalTimeAsDate(new Time(Long.MAX_VALUE));
        apioutput.getTotalTime();

        //Methoden get- und setTotalDistanceInMetres.
        double distance = MAX_VALUE;
        apioutput.getTotalDistanceInMetres();
        apioutput.setTotalDistanceInMetres(null);
        apioutput.getTotalDistanceInMetres();
        apioutput.setTotalDistanceInMetres(distance);
        apioutput.getTotalDistanceInMetres();

        //Methoden get- und setTotalDistanceInKilometres.
        apioutput.getTotalDistanceInKilometres();
        apioutput.setTotalDistanceInKilometres(null);
        apioutput.getTotalDistanceInKilometres();
        apioutput.setTotalDistanceInKilometres(distance);
        apioutput.getTotalDistanceInKilometres();

        //Methoden get- und set






        apioutput.getStrukturdistance();
        apioutput.getStrukturtime();
        apioutput.getTotalDistanceInKilometres();
        apioutput.getTotalDistanceInMetres();
        apioutput.getTotalTime();


    }
}

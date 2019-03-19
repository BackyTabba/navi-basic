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
    public void setUp(){ System.out.println("Ich fange an zu Testen."); }

    @After
    public void tearDown(){ System.out.println("Ich hoffe, alle Tests waren erfolgreich!"); }

    @Test
    public void checkTimeClass(){
        Time time = new Time(Long.MAX_VALUE);
        time.getTime();
        time.getDays();
        time = new Time(0L);
        time.getTime();
        time.getDays();
        time = new Time(-Long.MAX_VALUE);
        time.getTime();
        time.getDays();
    }

    @Test
    public void checkTranslatorClass(){
        Translator tl;
        tl = new Translator(null, null);
        tl = new Translator(null, new RouteResponse());
        tl = new Translator(new APIOutput(), null);
        tl = new Translator(new APIOutput(), new RouteResponse());
    }

    @Test
    public void checkAPIOutputClass(){
        APIOutput apioutput = new APIOutput();

        //Methoden get- und setRoutenstruktur.
        apioutput.getRoutenStruktur();
        apioutput.setRoutenStruktur(null);
        apioutput.getRoutenStruktur();
        apioutput.setRoutenStruktur(new ArrayList<String>());
        apioutput.getRoutenStruktur();

        //Methoden get- und setStrukturDistance.
       // apioutput.getStrukturDistance();
       // apioutput.setStrukturDistance(null);
       // apioutput.getStrukturDistance();
       // apioutput.setStrukturDistance(ArrayList<>)

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

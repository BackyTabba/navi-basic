package main.java.API;


import com.graphhopper.directions.api.client.model.GeocodingResponse;
import com.graphhopper.directions.api.client.model.RouteResponse;
import com.sun.org.apache.xerces.internal.xs.StringList;
import com.thoughtworks.xstream.mapper.Mapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.annotation.XmlSeeAlso;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

import static com.sun.xml.internal.ws.api.message.Packet.Status.Request;
import static java.lang.Float.MAX_VALUE;
import static java.lang.Float.MIN_VALUE;

/**
 * Test class.
 * @version 0.0.2
 */
public class TestClass {

    public TestClass(){}

    @Before
    public void setUp(){}

    @After
    public void tearDown(){}

    /**
     * Testing the Time class.
     * case1: calling konstruktor with Long.MAX_VALUE.
     * case2: calling konstruktor with 0L.
     * case3: calling konstruktor with Long.MAX_VALUE.
     * calling every getter method.
     */
    @Test
    public void checkTimeClass(){

        //Konstruktor
        Time time;
        new Time(Long.MAX_VALUE);
        new Time(0L);
        time = new Time(-Long.MAX_VALUE);

        //Every getter method.
        time.getDays();
        time.getHours();
        time.getMinutes();
        time.getSeconds();
        time.getMilliseconds();
    }

    /**
     * Testing the Translator class.
     * case1: calling konstruktor with null, null.
     * case2: calling konstruktor with empty APIOutput object, empty RouteResponse object.
     */
    @Test
    public void checkTranslatorClass(){

        //Konstruktor
        new Translator(null, null);
        new Translator(new APIOutput(), new RouteResponse());
    }

    /**
     * Testing the APIOutput class.
     * Calling the konstruktor.
     * case1: calling .setRoutenStruktur(ArrayList<String>) first with null and then with an empty ArrayList<String>.
     * case2: calling .setStrukturDistance(ArrayList<Double>) first with null and then with an empty ArrayList<Double>.
     * case3: calling .setStrukturTime(ArrayList<Long>) first with null and then with an empty ArrayList<Time>.
     * case4: calling .setTotalTimeAsDate(Long) first with null and then with Time object.
     * case5: calling .setTotalDistanceInMetres(double) with double values 1: MAX_VALUE 2: 0L 3: MIN_VALUE.
     * case6: calling .setTotalDistanceInKilometres(double) with double values 1. MAX_VALUE 2: 0L 3: MIN_VALUE.
     * case7: calling every getter method.
     */
    @Test
    public void checkAPIOutputClass(){

        //Konstruktor
        APIOutput apioutput = new APIOutput();

        //Method setRoutenstruktur.
        apioutput.setRoutenStruktur(null);
        apioutput.setRoutenStruktur(new ArrayList<String>());


        //Method setStrukturDistance.
        apioutput.setStrukturdistance(null);
        apioutput.setStrukturdistance(new ArrayList<Double>());

        //Method setStrukturTime.
        apioutput.setStrukturtime(null);
        apioutput.setStrukturtime(new ArrayList<Time>());

        //Method setTotalTimeAsDate.
        apioutput.setTotalTimeAsDate(null);
        apioutput.setTotalTimeAsDate(new Time(Long.MAX_VALUE));

        //Method setTotalDistanceInMetres.
        double distanceMAX = MAX_VALUE;
        double distanceNegativeMax = MIN_VALUE;
        double distanceZero = 0.0;
        apioutput.setTotalDistanceInMetres(distanceMAX);
        apioutput.setTotalDistanceInMetres(distanceNegativeMax);
        apioutput.setTotalDistanceInMetres(distanceZero);

        //Method setTotalDistanceInKilometres.
        apioutput.setTotalDistanceInKilometres(distanceMAX);
        apioutput.setTotalDistanceInKilometres(distanceNegativeMax);
        apioutput.setTotalDistanceInKilometres(distanceZero);

        //Every getter method.
        apioutput.getRoutenStruktur();
        apioutput.getStrukturtime();
        apioutput.getStrukturdistance();
        apioutput.getTotalDistanceInKilometres();
        apioutput.getTotalDistanceInMetres();
        apioutput.getTotalTime();
    }

    /**
     * Testing Connection class.
     * case1: calling konstruktor with null, null, null, null.
     * case2: calling konstruktor with empty objects.
     */
    @Test()
    public void checkConnectionClass(){

        //Konstruktor
        new Connection(null, null, null, null);
        new Connection(new APIOutput(), "", "", "");
    }

    /**
     * Testing GeoConding class.
     * case1: calling .geocode(String) with newSting() / "" / nonsense String.
     * case2: calling .getResult(String) with newString() / "" / nonsense String.
     */
    @Test
    public void checkGeoCodingClass(){

        //Method .geocode(String)
        GeoCoding.geocode(new String());
        GeoCoding.geocode("");
        GeoCoding.geocode("abcde");

        //Method .getResult(String)
        GeoCoding.getResult(new String());
        GeoCoding.getResult("");
        GeoCoding.getResult("abcde");
    }

    /**
     * Testing UserInteraction class.
     * case1: calling Konstruktor with 0.0,0.0,0.0,0.0,new String
     * case2: calling konstruktor with MIN_VALUE,..., empty String.
     * case3: calling konstruktor with MAX_VALUE,..., nonsense String.
     * case4: calling konstruktor with new String,...,....
     * case5: calling konstruktor wit nonsense String,...,.....
     * case6: calling method .getOutput();
     */
    @Test
    public void checkUserInteractionClass(){

        //Konstruktor (double, double, double, double, String)
        //new UserInteraction(0.0, 0.0, 0.0,0.0,  new String());
        //new UserInteraction(MIN_VALUE, MIN_VALUE, MIN_VALUE, MIN_VALUE, "");
        //new UserInteraction(MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE, "abcde");

        //Konstruktor (String, String, String)
        //new UserInteraction(new String(), new String(), new String());
        new UserInteraction("", "", "");
        //new UserInteraction("abcde", "abcde", "abcde");

        //Method getOutput
        //new UserInteraction("","","").getOutput();
    }

    /**
     * Testing XmlChanger class.
     * case1: calling .ichMachXML(List<OutputPoints>) with null, empty ArrayList, empty LinkedList, empty Vector, empty Stack.
     */
    @Test
    public void checkXmlChangerClass(){
        XmlChanger.ichMachXML(null);
        XmlChanger.ichMachXML(new ArrayList<OutputPoints>());
        XmlChanger.ichMachXML(new LinkedList<OutputPoints>());
        XmlChanger.ichMachXML(new Vector<OutputPoints>());
        XmlChanger.ichMachXML(new Stack<OutputPoints>());
    }

    /**
     * Testing OutputPoints class.
     * case1: calling konstruktor with null, zero, null.
     * case2: calling konstruktor with empty String, maximal double value, Time object.
     * case3: calling konstruktor wit nonsense String, minimal double value, Time object.
     * case4: calling .getText()
     */
    @Test
    public void checkOutputPointsClass(){
        new OutputPoints(null,0.0, "",null,null, 1);
        new OutputPoints(null, MAX_VALUE,null,null, new Time(5L).getTime(),0);
        new OutputPoints(null,MIN_VALUE,"",null,null, 5678);
    }
}

























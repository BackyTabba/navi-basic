package main.java.API;

import com.graphhopper.directions.api.client.model.Response;
import com.graphhopper.directions.api.client.model.RouteResponsePath;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.util.List;
import javax.xml.bind.JAXB;

public class XML_Changer {

    public void tablegenerator(List<RouteResponsePath>)
    {
        Room room = new Room();
        room.setPaths(Connection.anfrage("Münster", "München", "car").getPaths());
        Marshaller
    }
}

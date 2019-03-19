package main.java.API;

import com.graphhopper.directions.api.client.model.RouteResponsePath;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Room {

    private List<RouteResponsePath> paths = new ArrayList<RouteResponsePath>();

    @XmlElement (name = "path")
    public List<RouteResponsePath> getPaths()
    {
        return this.paths;
    }

    public void setPaths(List<RouteResponsePath> paths)
    {
        this.paths = paths;
    }
}

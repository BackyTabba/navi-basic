import java.util.ArrayList;
import java.util.List;

public class Route {
    private List<String> RoutenStruktur = new ArrayList<String>();

    public Route(){


    }
    /*
    returns ein List<String>-Objekt, dass die Routenanweisungen enthält
     */
    public List<String> getRoutenStruktur(){
        return RoutenStruktur;
    }

    public void setRoutenStruktur(List<String> pRoutenStruktur){
        this.RoutenStruktur = pRoutenStruktur;
    }
}

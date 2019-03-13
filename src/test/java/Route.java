/*
Needed archives are imported here.
@java.util.ArrayList
@java.util.List
 */
import java.util.ArrayList;
import java.util.List;

/*
This Class Contains the route-detials wich are ejected to the user in the end.
 */
public class Route {

    /*
    Declaration and inizialisation of the needed variables
    @List<String> RoutenStruktur will contain informations given about the route.
     */
    private List<String> RoutenStruktur = new ArrayList<String>();

    /*
    This is the Konstruktor. It does nothing.
     */
    public Route(){

    }

    /*
    Returns RoutenStruktur.
    @return List<String> RoutenStruktur
     */
    public List<String> getRoutenStruktur(){
        return RoutenStruktur;
    }
    /*
    Sets the RoutenStruktur.
    @List<String> pRoutenStrukur the RoutenStruktur to set.
     */
    public void setRoutenStruktur(List<String> pRoutenStruktur){
        this.RoutenStruktur = pRoutenStruktur;
    }
}

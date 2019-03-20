package main.java.API;


import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.Mapper;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.List;


public class XmlChanger {




    /**
     *@param liste
     *@since
     */
    public static void ichMachXML(List<OutputPoints> liste, String a, String b) {
        XStream xs = new XStream(new DomDriver());

        xs.alias("Wegbeschreibung", OutputPoints.class);
        xs.aliasField("Schritt", OutputPoints.class, "schritt");
        xs.aliasField("Beschreibung", OutputPoints.class, "text");
        xs.aliasField("Distanz", OutputPoints.class, "distance");
        xs.aliasField("Zeit", OutputPoints.class, "time");
        xs.aliasField("Straße", OutputPoints.class, "straße");
        xs.aliasField("Bemerkung", OutputPoints.class, "bemerkung");

        try
        {
            String userhome = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();

            String filename = userhome+ File.separator+a+" nach "+b+".xml";
            FileOutputStream fos = new FileOutputStream(filename);

            xs.toXML(liste, fos);
        }catch(FileNotFoundException e)
        {
            System.err.println("The determined filepath was not found.");
            //e.printStackTrace();
        }catch(IndexOutOfBoundsException i){
            System.err.println("The given List<> should not be empty.");
        }catch(NullPointerException r){
            System.err.println("The given object should not be null.");
        }

    }


}


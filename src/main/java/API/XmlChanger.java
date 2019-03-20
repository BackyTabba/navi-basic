package main.java.API;


import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.DomDriver;

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
    public static void ichMachXML(List<OutputPoints> liste) {
        XStream xs = new XStream(new DomDriver());

        xs.alias("Wegbeschreibung", OutputPoints.class);
        try
        {

            String userhome = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            String filename = userhome+ File.separator+liste.get(0).getStraße()+" nach "+liste.get(liste.size()-1).getStraße()+".xml";
            FileOutputStream fos = new FileOutputStream(filename);

            xs.toXML(liste, fos);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }
}


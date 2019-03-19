package main.java.API;


import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;


public class XmlChanger {

    public static void ichMachXML(List<OutputPoints> Liste) {
        XStream xs = new XStream(new DomDriver());

        xs.alias("Wegbeschreibung", OutputPoints.class);

        try
        {

            String filename = "C:\\Users\\fabia\\OneDrive\\Desktop\\"+"Von "+Liste.get(0).getText()+" nach "+Liste.get(Liste.size()-1).getText()+".xml";
            FileOutputStream fos = new FileOutputStream(filename);

            xs.toXML(Liste, fos);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }
}


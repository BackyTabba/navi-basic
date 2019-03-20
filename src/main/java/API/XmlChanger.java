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
    public static void ichMachXML(List<OutputPoints> liste) {
        XStream xs = new XStream(new DomDriver());

        xs.alias("Wegbeschreibung", OutputPoints.class);
        try
        {
            String userhome = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            List<OutputPoints> druck = lastStreet(liste);
            String filename = userhome+ File.separator+druck.get(0).getStraße()+" nach "+liste.get(druck.size()-2).getStraße()+".xml";
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

    private static List<OutputPoints> lastStreet(List<OutputPoints> list)
    {
        for(int i = 1; i<list.size()-1; i++)
        {
            if (list.get(i).getStraße() == null || list.get(i).getStraße().equals("") ) {
                list.get(i).setStraße(list.get(i - 1).getStraße());
                System.out.println(i+" angepasst");
            }
        }
        return list;
    }
}


package fiuba.algo3.persistencia;


//import fiuba.algo3.modelo.Posicion;
import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


import java.io.File;
import java.io.FileOutputStream;

public class WriteXMLFile {

    public static void main(String argv[]) {

        ContenidoMapa mapa = new ContenidoMapa();

        try {
            mapa.agregar(new Posicion(1,2));
            mapa.agregar(new Posicion(3,4));

        } catch (Exception e) {}


        Document docContenidoMapa = new Document(mapa.serializar());

        try{



            XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());

            FileOutputStream file = new FileOutputStream("mapa.xml");
            out.output(docContenidoMapa,file);


            file.flush();
            file.close();

            out.output(docContenidoMapa,System.out);

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}






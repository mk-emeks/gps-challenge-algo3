package fiuba.algo3.persistencia;


import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReaderXML {

    public static void main(String argv[]) throws IOException, JDOMException {

        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(new FileInputStream("mapa.xml"));
        Element raiz = doc.getRootElement();
        ContenidoMapa mapa = new ContenidoMapa(raiz);


        /** para que se vea por consola que se pudo levantar **/
        ArrayList<Posicion> listaPosicionesValidas = mapa.getPosicionesValidas();
        Iterator<Posicion> iterator = listaPosicionesValidas.iterator();

        while (iterator.hasNext()) {

            Posicion posicionValida = iterator.next();
            System.out.println("coordX" + posicionValida.getPosicionX() + " " + "coordY" + posicionValida.getPosicionY());
        }


    }
}

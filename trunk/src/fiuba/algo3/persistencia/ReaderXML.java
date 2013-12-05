package fiuba.algo3.persistencia;


import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ReaderXML {

    public static void main(String argv[]) throws IOException, JDOMException {

        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(new FileInputStream("mapa.xml"));
        Element raiz = doc.getRootElement();
        ContenidoMapa mapa = new ContenidoMapa(raiz);


    }
}

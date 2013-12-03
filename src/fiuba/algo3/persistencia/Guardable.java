package fiuba.algo3.persistencia;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.util.Map;

public interface Guardable {

    public Element guardar (Element contenedor);

    public Guardable cargar(Map<String, Node> atributos);
}

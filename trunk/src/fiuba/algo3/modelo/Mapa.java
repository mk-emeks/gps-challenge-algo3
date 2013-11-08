package fiuba.algo3.modelo;


import java.util.ArrayList;
import java.util.List;

public class Mapa {

    private List<Posicionable> contenido;
    private List<Posicion> posicionesValidas;

    public Mapa() {
        this.posicionesValidas = new ArrayList<Posicion>();
        this.contenido = new ArrayList<Posicionable>();

    }

    public void agregar(Posicionable posicionable) {
        this.contenido.add(posicionable);
    }
}

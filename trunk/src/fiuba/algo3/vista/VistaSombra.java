package fiuba.algo3.vista;



import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.dibujables.Figura;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

import java.awt.*;


public class VistaSombra implements ObjetoDibujable {

    Figura unFigura;
    boolean neblina;
    ObjetoPosicionable representacionDeSombra;


    public VistaSombra(ObjetoPosicionable representacionDeSombra) {

        this.representacionDeSombra = representacionDeSombra;
        /** suponemos que el objetoPosicionable que se pasa es un RepresentacionDePosicionable **/
        int tamanio = ((RepresentacionDePosicionable)representacionDeSombra).getFactorDeEscala();

        /** un cuadrado no se le deberia poner solo una medida? a revisar definiciones muchachos... **/
        this.unFigura = new Cuadrado(tamanio,tamanio,representacionDeSombra);
        this.unFigura.setColor(Color.BLACK);
        neblina = true;
    }

    public void quitarNeblina() {

        this.neblina = false;
    }

    public void ponerNeblina() {

        this.neblina = true;
    }

    private boolean hayNeblina() {
        return this.neblina;
    }

    public void dibujar(SuperficieDeDibujo unaSuperficieDeDibujo) {

        if (hayNeblina()) {
            unFigura.dibujar(unaSuperficieDeDibujo);
        }

    }

    public ObjetoPosicionable getPosicionable() {

        return this.representacionDeSombra;
    }

}

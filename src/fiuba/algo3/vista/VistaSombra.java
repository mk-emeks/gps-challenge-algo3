/*package fiuba.algo3.vista;



import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.dibujables.Circulo;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

import java.awt.*;


public class VistaSombra implements ObjetoDibujable {

    Circulo unFigura;
    boolean neblina;
    ObjetoPosicionable representacionDeSombra;


    public VistaSombra(ObjetoPosicionable unRepresentacionDeSombra) {

        this.representacionDeSombra = unRepresentacionDeSombra;
        this.unFigura = new Circulo(150,unRepresentacionDeSombra);
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

}    */

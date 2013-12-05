package fiuba.algo3.vista;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

import java.net.URL;

public class VistaLlegada implements ObjetoDibujable {

    private Imagen imagen;

    public VistaLlegada(ObjetoPosicionable unPosicionable) {

        try {
            URL urlLlegada = this.getClass().getResource("imagenes/FIUBA.png");
            this.imagen = new Imagen(urlLlegada,unPosicionable);

        } catch (Exception e) {
            System.out.println("no se cargo el archivo de la imagen");
        }

    }


    public void dibujar(SuperficieDeDibujo unaSuperficeDeDibujo) {

        this.imagen.dibujar(unaSuperficeDeDibujo);

    }
}
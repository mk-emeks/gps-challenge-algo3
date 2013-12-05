package fiuba.algo3.vista;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

import java.net.URL;

public class VistaCalle implements ObjetoDibujable {

    private Imagen imagen;

    public VistaCalle(ObjetoPosicionable unPosicionable) {

        try {
            URL urlCalle = this.getClass().getResource("imagenes/calle.png");
            this.imagen = new Imagen(urlCalle,unPosicionable);

        } catch (Exception e) {
            System.out.println("no se cargo el archivo de la imagen");
        }

    }


    public void dibujar(SuperficieDeDibujo unaSuperficeDeDibujo) {

        this.imagen.dibujar(unaSuperficeDeDibujo);

    }
}

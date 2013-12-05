package fiuba.algo3.vista;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

import java.net.URL;

public class VistaInicio implements ObjetoDibujable {

    private Imagen imagen;

    public VistaInicio(ObjetoPosicionable unPosicionable) {

        try {
            URL urlInicio = this.getClass().getResource("imagenes/inicio.png");
            this.imagen = new Imagen(urlInicio,unPosicionable);

        } catch (Exception e) {
            System.out.println("no se cargo el archivo de la imagen");
        }

    }


    public void dibujar(SuperficieDeDibujo unaSuperficeDeDibujo) {

        this.imagen.dibujar(unaSuperficeDeDibujo);

    }
}
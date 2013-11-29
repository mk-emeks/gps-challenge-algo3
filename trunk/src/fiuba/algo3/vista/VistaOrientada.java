package fiuba.algo3.vista;


import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import java.net.URL;

public class VistaOrientada implements ObjetoDibujable {

    Imagen unaImagen;
    URL unaURL;
    ObjetoPosicionable unObjetoPosicionable;

    public void setObjetoPosicionable(ObjetoPosicionable unPosicionable) {
        this.unObjetoPosicionable = unPosicionable;
    }

    public void setNombreArchivoImagen(String unString) {
        unaURL = this.getClass().getResource(unString);
    }


    @Override
    public void dibujar(SuperficieDeDibujo superficieDeDibujo) {

        try {
            this.unaImagen = new Imagen(unaURL,unObjetoPosicionable);

        } catch (Exception e) {
            System.out.println("no se cargo el archivo de la imagen");
        }


        this.unaImagen.dibujar(superficieDeDibujo);
    }

}
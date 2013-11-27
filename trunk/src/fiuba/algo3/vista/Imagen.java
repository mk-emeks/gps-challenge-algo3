package fiuba.algo3.vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;


import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

import fiuba.algo3.titiritero.dibujables.SuperficiePanel;

/** Esta clase es un merge de codigo de la clase Imagen del titiritero version google codes y github **/

public abstract class Imagen implements ObjetoDibujable {

    private BufferedImage imagen;
    private ObjetoPosicionable posicionable;

    private String nombreArchivoImagen;

    /** En el constructor se pasa el ObjetoPosicionable que representa la vista **/

    public Imagen(ObjetoPosicionable posicionable) {

        this.posicionable = posicionable;

        /** PARTE DE LA OTRA IDEA **/
        /** this.imagenUrl = new URL("file","root",1,"/imagenes/imagenGenerica.png");
        this.imagen = ImageIO.read(this.imagenUrl); **/
    }

    /** Establece la imagen con la que se dibujará el objeto **/

    public void setNombreArchivoImagen(String nombreArchivoImagen) {

        this.nombreArchivoImagen = nombreArchivoImagen;

        try{
            URL imageUrl = this.getClass().getResource(this.nombreArchivoImagen);
            this.imagen = ImageIO.read(imageUrl);
        } catch(Exception exception) { System.out.println("no toma el archivo imagen"); }
    }

    @Override
    public void dibujar(SuperficieDeDibujo superficieDeDibujo) {

        Graphics grafico = ((SuperficiePanel)superficieDeDibujo).getBuffer();
        grafico.drawImage(this.imagen, this.posicionable.getX(), this.posicionable.getY(),null);

    }

    public ObjetoPosicionable getPosicionable() {
        return this.posicionable;
    }


}
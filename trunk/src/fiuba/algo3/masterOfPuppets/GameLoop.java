package fiuba.algo3.masterOfPuppets;



import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author MirkoSoft
 * Retornando de la muerte al GRAN ControladorDeJuego (by @NicoPaez) en forma de gameLoop logrando compatibilidad
 * con el nuevo titiritero
 */

public class GameLoop implements Runnable {


    /** Constructor **/
    public GameLoop(){
        this.objetosVivos = new ArrayList<ObjetoVivo>();
        this.dibujables = new ArrayList<ObjetoDibujable>();
        this.keyPressedObservadores = new ArrayList<KeyPressedObservador>();

    }

    /**  Control del gameLoop **/

    private long intervaloSimulacion;
    private boolean estaEnEjecucion;


    public boolean estaEnEjecucion(){
        return this.estaEnEjecucion;
    }

    public void comenzarJuego(){
        estaEnEjecucion = true;
        try{
            while(estaEnEjecucion){
                simular();
                dibujar();
                Thread.sleep(intervaloSimulacion);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Detiene el juego provocando la salida del gameloop.
     */
    public void detenerJuego(){
        this.estaEnEjecucion = false;
        /*if(reproductor!=null)
            this.reproductor.apagar();*/
    }

    /*public void comenzarJuegoAsyn(){
        Thread thread = new Thread(this);
        thread.start();
        if(this.estaReproductorActivo){
            this.reproductor.encender();
            this.hiloAudio =  new Thread(this.reproductor);
            this.hiloAudio.start();
        }
    } */

    /** (!) CONCURRENCIA **/
    private Thread hiloAudio;
    private boolean estaReproductorActivo;

    public void run() {
        this.comenzarJuego();
    }

    /** Para manejar la frecuencia de simulacion del gameLoop **/

    public long getIntervaloSimulacion() {
        return intervaloSimulacion;
    }

    public void setIntervaloSimulacion(long intervaloSimulacion) {
        this.intervaloSimulacion = intervaloSimulacion;
    }

    /**
     * Le da comienzo al juego poniendo en marcha el gameloop.
     * @param cantidadDeCiclos cantidad de ciclos que debe correr el gameloop..
     */
    /*public void comenzarJuego(int cantidadDeCiclos){
        int contador = 0;
        estaEnEjecucion = true;
        try{
            while(contador < cantidadDeCiclos && estaEnEjecucion){
                simular();
                dibujar();
                Thread.sleep(intervaloSimulacion);
                contador++;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    } */

    /** Objetos vivos y Dibujables del gameLoop **/

    private List<ObjetoVivo> objetosVivos;
    private List<ObjetoDibujable> dibujables;


    public void agregar(ObjetoVivo objetoVivo){
        objetosVivos.add(objetoVivo);
    }

    public void remover(ObjetoVivo objetoVivo){
        objetosVivos.remove(objetoVivo);
    }

    public void agregar(ObjetoDibujable unDibujable){
        dibujables.add(unDibujable);
    }

    public void remover(ObjetoDibujable unDibujable){
        dibujables.remove(unDibujable);
    }

    private void dibujar() {
        Iterator<ObjetoDibujable> iterador = dibujables.iterator();
        while(iterador.hasNext()){
            ObjetoDibujable dibujable = iterador.next();
            dibujable.dibujar(this.superficieDeDibujo);
        }
        this.superficieDeDibujo.actualizar();
    }

    /**
     * Ejecuta la simulacion recorriendo la coleccion de objetivos vivos.
     */
    private void simular() {
        //this.superficieDeDibujo.limpiar();       /** ojo cuando se borren **/
        Iterator<ObjetoVivo> iterador = objetosVivos.iterator();
        while(iterador.hasNext()){
            iterador.next().vivir();
        }
    }

    /** Superficie que controla el gameLoop **/

    private SuperficieDeDibujo superficieDeDibujo;

    public SuperficieDeDibujo getSuperficieDeDibujo() {
        return superficieDeDibujo;
    }

    public void setSuperficieDeDibujo(SuperficieDeDibujo superficieDeDibujo) {
        this.superficieDeDibujo = superficieDeDibujo;
        //this.superficiePanel = (SuperficiePanel)superficieDeDibujo; /**!**/
    }


    /** Para controlar el teclado **/

    private List<KeyPressedObservador> keyPressedObservadores;

    public void despacharKeyPress(KeyEvent event){
        for (KeyPressedObservador observador : this.keyPressedObservadores){
            observador.keyPressed(event);
        }
    }

    public void agregar(KeyPressedObservador unMouseClickObservador){
        this.keyPressedObservadores.add(unMouseClickObservador);
    }

    public void remover(KeyPressedObservador unMouseClickObservador){
        this.keyPressedObservadores.remove(unMouseClickObservador);
    }

}


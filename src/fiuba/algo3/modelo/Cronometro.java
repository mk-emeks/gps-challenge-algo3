package fiuba.algo3.modelo;


import fiuba.algo3.vista.VistaCronometro;

public class Cronometro implements Runnable {

    private int segundos;
    private int errorEnSegundos;
    private Conversor donConversor;
    private boolean estaEnEjecucion;

    //private VistaCronometro vistaTiempo;
    private Thread hilo;

    /*public void setVistaCronometro(VistaCronometro unVista) {
        this.vistaTiempo = unVista;
    }*/

    public Cronometro() {

        this.segundos = 0;
        this.errorEnSegundos = 2;
        this.donConversor = new Conversor();
    }

    public boolean estaEnEjecucion(){
        return this.estaEnEjecucion;
    }

    public void comenzarCronometro() {
        this.estaEnEjecucion = true;
        this.hilo = new Thread(this);
        this.hilo.start();
    }

    public void detenerCronometro() {
        this.estaEnEjecucion = false;
        this.hilo.interrupt();
    }

    public void reset() {

        this.segundos = 0;
        this.detenerCronometro();

    }

    public void run(){

        estaEnEjecucion = true;
        while (estaEnEjecucion) {

            this.contar();
            //vistaTiempo.setText(this.devolverTiempoComoString());

            try {
                hilo.sleep(850);
            } catch (InterruptedException e) {
                System.out.println("interrupcion al cronometro");
            }

        }

    }

    public void contar() {

        this.segundos++;
    }

    public synchronized String devolverTiempoComoString() {
        return this.donConversor.devolverTiempoComoString(this.segundos);
    }


    public synchronized int tiempoEnSegundos() {
        return this.segundos;
    }


    public void sumarSegundos(int unosSegundos) {
        this.segundos = this.segundos + unosSegundos;
    }


    public void variarPorcentaje(int unPorcentaje) {
        int segundosASumar = ((this.tiempoEnSegundos() * unPorcentaje) / 100);
        this.sumarSegundos(segundosASumar);
    }

    public int errorEnSegundos() {
        return this.errorEnSegundos;
    }
}
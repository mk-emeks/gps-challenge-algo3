package fiuba.algo3.modelo;


import fiuba.algo3.vista.VistaCronometro;

public class Cronometro implements Runnable {

    private int segundos;
    private int errorEnSegundos;
    private Conversor donConversor;
    private boolean pausa;

    private VistaCronometro vistaTiempo;
    private Thread hilo;

    /** el unico lugar donde se cochinea la vista: por ahora **/
    public void setVistaCronometro(VistaCronometro unVista) {
        this.vistaTiempo = unVista;
    }

    public Cronometro() {


        this.segundos = 0;
        this.errorEnSegundos = 2;
        this.donConversor = new Conversor();
        this.pausa = false;
    }


    public void pausar() {

        hilo.suspend();
        this.pausa = true;
    }


    public void reanudar() {

        this.iniciar();
    }


    public void reset(/*Thread hilo*/) {

        this.segundos = 0;
        this.pausar(/*hilo*/);

    }

    //Fin

    public void run(){
        try {
            while (!this.estaPausado()) {

                this.contar();
                vistaTiempo.setText(this.devolverTiempoComoString());

                try {
                    hilo.sleep(850);
                } catch (InterruptedException e) {
                    System.out.println("no carge el hilo del cronometro");
                    //e.printStackTrace();
                }

            }
        } catch(Exception e){}
    }

    public void iniciar(/*Thread hilo*/) {

        if (!this.pausa) {

            this.hilo = new Thread(this);
            this.hilo.start();
        }  else {
            this.pausa=false;
            this.hilo.resume();
        }
        /*if (!this.pausa) {
            hilo.start();
        }else {
            this.pausa=false;
            hilo.resume();
        }*/
    }

    public void contar() {

        this.segundos++;
    }


    public boolean estaPausado() {
        return this.pausa;
    }


    public synchronized String devolverTiempoComoString() { //throws Exception {
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
/**
package fiuba.algo3.modelo;



public class Cronometro {

    //private Thread hilo;

    private int segundos;
    private int minutos;
    private int horas;


    private boolean pausa;

    public Cronometro() {

        segundos = 0;
        minutos = 0;
        horas = 0;
        this.pausa = false;
    }

    //no usar estos metodos antes de iniciar cronometro, porque lo vas a romper
    public void pausar(Thread hilo) {

        hilo.suspend(); //mata el proceso? consecuencia en reanudar. Asi tmb es el finalizar
        pausa = true;
    }

    public void reanudar(Thread hilo) {

        //hilo.interrupt();
        //pausa = false;
        this.iniciar(hilo);
    }

    public void reset(Thread hilo) {

        this.pausar(hilo);
        segundos = 0;
        minutos = 0;
        horas = 0;
    }

    //Fin

    public void iniciar(Thread hilo) {

        if (!this.pausa) {
            hilo.start();
        }else {
            pausa=false;
            hilo.resume();
        }


    }

    public void contar() {

        this.segundos++;
        if (this.segundos == 60) {

            this.minutos++;
            this.segundos = 0;
            if (this.minutos == 60) {

                this.horas++;
                this.minutos = 0;
            }
        }
    }


    public boolean estaPausado(){return pausa;}

    public String devolverTiempoComoString() { //throws Exception {
        String hr;
        String min;
        String seg;

        if(this.segundos<10) {
            seg = "0" + this.segundos;
        }else {
            seg = String.valueOf(this.segundos);
        }

        if(this.minutos<10) {
            min = "0" + this.minutos;
        }else {
            min = String.valueOf(this.minutos);
        }

        if(this.horas<10) {
            hr = "0" + this.horas;
        }else {
            hr = String.valueOf(this.horas);
        }

        return (hr + ":" + min + ":" + seg);
    }

    //por testing es public
    public int tiempoEnSegundos() {
        return ( this.segundos + this.minutosEnSegundos() + this.horasEnSegundos() );
    }

    private int minutosEnSegundos() {
        return this.minutos*60;
    }

    private int horasEnSegundos() {
        return this.horas*3600;
    }

    private void sumarHoras(int unasHoras){
        this.horas = this.horas + unasHoras;
    }

    private void sumarMinutos(int unoMinutos){
        this.minutos = this.minutos + unoMinutos;
    }

     //por testing es public
    public void sumarSegundos(int unosSegundos) {
        this.segundos = this.segundos + unosSegundos;
    }

    private void agregarSegundos(int cantidadDeSegundos) {

        int horasASumar = (cantidadDeSegundos/3600);

        this.sumarHoras(horasASumar);
        cantidadDeSegundos = cantidadDeSegundos - (horasASumar*3600);

        int minutosASumar = (cantidadDeSegundos/60);

        this.sumarMinutos(minutosASumar);
        cantidadDeSegundos = cantidadDeSegundos - (minutosASumar*60);

        this.sumarSegundos(cantidadDeSegundos);

    }

    public void variarPorcentaje(int unPorcentaje) {
        int segundosASumar = ((this.tiempoEnSegundos() * unPorcentaje) / 100);
        this.agregarSegundos(segundosASumar);
    }
}**/

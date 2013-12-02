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
}

/**
public class Cronometro implements Runnable {

    private Thread hilo;

    private int segundos;
    private int minutos;
    private int horas;
    private int errorEnSegundos;


    private boolean pausa;

    public Cronometro() {

        segundos = 0;
        minutos = 0;
        horas = 0;
        errorEnSegundos = 2;
        this.pausa = true;
    }

    // no usar estos metodos antes de iniciar cronometro, porque lo vas a romper
    public void pausar() {

        hilo.interrupt(); //mata el proceso? consecuencia en reanudar. Asi tmb es el finalizar
        pausa = true;
    }

    public void reanudar() {

        //hilo.interrupt();
        //pausa = false;
        this.iniciar();
    }

    public void reset() {

        //hilo.interrupt();
        //this.pausa = true;
        this.pausar();
        segundos = 0;
        minutos = 0;
        horas = 0;
    }

    // fin

    public void iniciar() {

        this.pausa = false;
        hilo = new Thread (this);
        hilo.start();
    }

    private void contar() {

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

    public void run(){

        try {

            while (!pausa) {

                // calibrar espera:
                 //  no es exactamente un segundo(1000 milesimas) porque al llamar
                 // asincronicamente un metodo del cronometro corta antes. ver tests!

                Thread.sleep(980); // espera un 1 segundo y despues contalo, verificar tiene un error de -1s/-2s
                this.contar();
                System.out.println(this.devolverTiempoComoString());  // despues se borra, se usa en testing

            }
        }  catch(Exception e) {

            //this.reset(); peligroso?
        }
    }

    public String devolverTiempoComoString() throws Exception {
        return ("horas: " + horas + " " + "minutos: " + minutos + " " + "segundos: " + segundos);
    }

    // por testing es public
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

    // por testing es public
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

    public int errorEnSegundos() {
        return this.errorEnSegundos;
    }
} **/

package fiuba.algo3.modelo;

public class Cronometro implements Runnable {

    private Thread hilo;

    private int segundos;
    private int minutos;
    private int horas;


    private boolean pausa;

    public Cronometro() {

        segundos = 0;
        minutos = 0;
        horas = 0;
        this.pausa = true;
    }

    /** no usar estos metodos antes de iniciar cronometro, porque lo vas a romper **/
    public void pausar() throws Exception {

        hilo.interrupt(); //mata el proceso? consecuencia en reanudar. Asi tmb es el finalizar
        pausa = true;
    }

    public void reanudar() throws Exception {

        /*hilo.interrupt();
        pausa = false;*/
        this.iniciar();
    }

    public void reset() throws Exception {

        //hilo.interrupt();
        //this.pausa = true;
        this.pausar();
        segundos = 0;
        minutos = 0;
        horas = 0;

    }

    /** fin **/

    public void iniciar() {

        this.pausa = false;
        hilo = new Thread (this);
        hilo.start();

    }

    public void run(){

        try {

            while (!pausa) {

                /** calibrar espera:
                 *  no es exactamente un segundo(1000 milesimas) porque al llamar
                 *  asincronicamente un metodo del cronometro corta antes. ver tests!
                 * **/
                Thread.sleep(850); // espera un 1 segundo y despues contalo

                segundos++;
                if (segundos == 60) {

                    minutos++;
                    segundos = 0;
                    if (minutos == 60) {

                        horas++;
                        minutos = 0;
                    }
                }
                System.out.println(this.devolverTiempoComoString());  // despues se borra, se usa en testing

            }
        }  catch(Exception e) {

            //this.reset(); peligroso?
        }

    }

    public String devolverTiempoComoString() throws Exception {

        return ("horas: " + horas + " " + "minutos: " + minutos + " " + "segundos: " + segundos);

    }

    public int tiempoEnSegundos() {

        return ( this.segundos + this.minutosEnSegundos() + this.horasEnSegundos() );

    }

    private int minutosEnSegundos() {return this.minutos*60; }
    private int horasEnSegundos() {return this.horas*3600; }

    //public void agregarTiempo()

}

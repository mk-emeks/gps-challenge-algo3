package fiuba.algo3.modelo;


public class Cronometro implements Runnable {

    Thread hilo;

    private int milesimas;
    private int segundos;
    private int minutos;

    private boolean pausa;

    public Cronometro() {

        this.reset();
    }

    public void pausar() {
        pausa = true;
    }

    public void reanudar() {
        pausa = false;
    }

    public void reset() {

        milesimas = 0;
        segundos = 0;
        minutos = 0;

        this.pausar();
    }

    public void iniciar() {

        this.reanudar();
        hilo = new Thread (this);
        hilo.start();

    }

    public void run(){
        try {
            while (!pausa) {

                Thread.sleep((long)1000);
                this.milesimas++;
                if (milesimas == 1000) {

                    segundos++;
                    milesimas = 0;

                    if (segundos == 60) {

                        minutos++;
                        segundos = 0;
                    }
                }

                System.out.println(this.devolverTiempoComoString());
            }
        }  catch(Exception e) {

        }

    }


    public String devolverTiempoComoString() {

        return ("minutos: " + minutos + " " + "segundos: " + segundos + " " + "milesimas: " + milesimas);
    }

    //public void agregarTiempo()

}

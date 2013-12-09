package fiuba.algo3.modelo;


public class Conversor {

    public Conversor() {}


    public int convertirSegundosAHoras( int unosSegundos) {
        return (unosSegundos/3600);

    }

    public int convertirSegundosAMinutos( int unosSegundos) {
        return (unosSegundos/60);

    }

    public int convertirHorasASegundos( int unasHoras) {
        return (unasHoras*3600);

    }

    public int convertirMinutosASegundos( int unosMinutos) {
        return (unosMinutos*60);

    }

    public String devolverTiempoComoString(int unosSegundos) {

        String hr;
        String min;
        String seg;

        int segundos = unosSegundos;
        int horas = this.convertirSegundosAHoras(segundos);
        segundos = segundos - this.convertirHorasASegundos(horas);
        int minutos = this.convertirSegundosAMinutos(segundos);
        segundos = segundos - this.convertirMinutosASegundos(minutos);


        if(segundos<10) {
            seg = "0" + segundos;
        }else {
            seg = String.valueOf(segundos);
        }

        if(minutos<10) {
            min = "0" + minutos;
        }else {
            min = String.valueOf(minutos);
        }

        if(horas<10) {
            hr = "0" + horas;
        }else {
            hr = String.valueOf(horas);
        }

        return (hr + ":" + min + ":" + seg);

    }
}

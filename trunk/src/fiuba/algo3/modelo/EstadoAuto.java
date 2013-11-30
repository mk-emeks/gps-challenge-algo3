package fiuba.algo3.modelo;

public class EstadoAuto extends Estado {

    public void interactuarCon(Piloto piloto, Pozo pozo) {

        pozo.aplicarA(piloto,this);

    }

    public void interactuarCon(Piloto piloto, Piquete piquete) {

        piquete.aplicarA(piloto,this);
    }

    public void interactuarCon(Piloto piloto, ControlPolicial layuta) {

        layuta.aplicarA(piloto,this);

    }

    public void interactuarCon(Piloto piloto, SorpresaFavorable sorpresa) {
        sorpresa.aplicarA(piloto);
    }

    public void interactuarCon(Piloto piloto, SorpresaDesfavorable sorpresa) {
        sorpresa.aplicarA(piloto);

    }
    public void interactuarCon(Piloto piloto, SorpresaCambioDeVehiculo sorpresa) {
        sorpresa.aplicarA(piloto,this);

    }

}

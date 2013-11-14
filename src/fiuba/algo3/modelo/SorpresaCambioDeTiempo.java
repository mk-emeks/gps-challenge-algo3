package fiuba.algo3.modelo;


public abstract class SorpresaCambioDeTiempo extends Sorpresa {

    int porcentajeTiempo;

    public SorpresaCambioDeTiempo (int porcentaje, Posicion unaPosicion) {

        super(unaPosicion);
        this.porcentajeTiempo = porcentaje;

    }

    protected int devolverPorcentaje() {
        return this.porcentajeTiempo;
    }

}





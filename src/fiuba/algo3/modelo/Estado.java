package fiuba.algo3.modelo;

public abstract class Estado {

    /** es igual en todos, son distintos los this ver() **/
    public abstract void interactuarCon(Piloto piloto, Pozo pozo);
    public abstract void interactuarCon(Piloto piloto, Piquete piquete);
    public abstract void interactuarCon(Piloto piloto, ControlPolicial layuta);


}

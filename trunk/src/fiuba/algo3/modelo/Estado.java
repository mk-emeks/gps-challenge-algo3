package fiuba.algo3.modelo;

public abstract class Estado {

    public abstract void interactuarCon(Piloto piloto, Pozo pozo);
    public abstract void interactuarCon(Piloto piloto, Piquete piquete);
    public abstract void interactuarCon(Piloto piloto, ControlPolicial layuta);


}

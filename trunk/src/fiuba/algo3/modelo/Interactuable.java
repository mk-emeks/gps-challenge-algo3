package fiuba.algo3.modelo;


public interface Interactuable{

    /** y toda la lista de aplicables que haya o sea necesaria **/


    //public void interactuarCon(Aplicable unAplicable);
    public void interactuarCon(Piquete piquete);
    public void interactuarCon(Pozo pozo);
    public void interactuarCon(Sorpresa sorpresa);

}

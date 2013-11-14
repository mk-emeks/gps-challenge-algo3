package fiuba.algo3.modelo;


public class Estado4x4 extends Estado {


    public void interactuarCon(Piloto piloto, Pozo pozo) {

        pozo.aplicarA(piloto,this);
    }

}

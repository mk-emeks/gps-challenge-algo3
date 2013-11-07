package fiuba.algo3.modelo;


public interface Movible extends Posicionable {

    void moverEn(Tablero tablero) throws LaCasillaNoEsAlojable;

}

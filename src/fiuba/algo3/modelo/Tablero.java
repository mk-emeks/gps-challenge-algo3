package fiuba.algo3.modelo;

public class Tablero {

    private int tamanioColumna;
    private int tamanioFila;
    private Casilla[][] mapa;

    public Tablero (int cuadrasPorFila,int cuadrasPorColumna) {
        this.tamanioFila = (2*cuadrasPorFila -1);
        this.tamanioColumna = (2*cuadrasPorColumna -1);
        this.mapa = new Casilla[tamanioFila][tamanioColumna];

        for (int i = 0; i < this.tamanioFila; i++) {
            for (int j = 0; j < this.tamanioColumna; j++) {
                Posicion unaPosicion = new Posicion(i,j);
                this.mapa[i][j] = new Casilla(unaPosicion);
            }
        }
    }

    public boolean coordenadaDentroDelTablero(int x, int y) {
        return (x >= 0 && x < this.tamanioFila && y >= 0 && y < this.tamanioFila);
    }


    public Casilla getCasilla(int x, int y) {

        if (!this.coordenadaDentroDelTablero(x, y))
            return null;

        return this.mapa[x][y];
    }
}

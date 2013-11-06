package fiuba.algo3.modelo;


public class EditorTablero {

    private Pintor pintulin = new Pintor();
    private Ensamblador donEnsamble = new Ensamblador();

    public EditorTablero() {

    }

    public void darFormatoSimpleA(Tablero unTablero) {

        pintulin.pintarTableroSimple(unTablero);
        donEnsamble.ensambleSimpleDeTablero(unTablero); //NO ESTA PROBADO
    }


}



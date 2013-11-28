package fiuba.algo3.control;


import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Panel;

/**no**/
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Nivel;
import fiuba.algo3.modelo.Piloto;
/** no **/

public class ControlInicioPartida {


   public void cargarPartida(Panel panelDeMapa, Juego juego) {

       /**no deberian estar **/
       Mapa.limpiar();
       juego.setNivel( new Nivel() );
       juego.setPiloto( new Piloto("pilotin") );
       /** fin **/

       juego.setPartida(new Partida(panelDeMapa,juego.getNivel(),juego.getPiloto()));

       //juego.getPartida().iniciar();  /**!!**/

   }

    public void iniciarPartida(Juego unJuego) {

        unJuego.getPartida().iniciar();

    }

}


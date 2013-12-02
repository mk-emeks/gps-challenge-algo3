package fiuba.algo3.control;


import fiuba.algo3.modelo.Estado4x4;
import fiuba.algo3.modelo.EstadoAuto;
import fiuba.algo3.modelo.EstadoMoto;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.vista.VistasMenu.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class gpsChallenge {



    public static void main(String[] argv) {

        /** creo la partida **/
        Partida unaPartida = new Partida();

        /** Configuracion Ventana Principal **/
        JFrame unMarco = new JFrame("GPS Challenge");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        unMarco.setBounds(0, 0, screenSize.width, screenSize.height);
        unMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        unMarco.setLayout(null);

        /** BOTONES **/

        /** Stage 1 : Eleccion Usuario --------------------------------------------------------------------**/

        /** boton Soy Nuevo -> stage 1.A **/
        Boton botonSoyNuevo = new BotonSoyNuevo(unMarco,30,150,369,80);
        botonSoyNuevo.setVisible(true);


        /** boton Ingresar Usuario -> stage 1.B **/
        Boton botonIngresarUsuario = new BotonIngresarUsuario(unMarco,30,250,369,80);
        botonIngresarUsuario.setVisible(true);

        /** Stage 1.A : Usuario Nuevo ----------------------------------**/

        /** texto **/
        Texto mensajeParaUsuarioNuevo = new Texto(unMarco,80,200,250,40);
        mensajeParaUsuarioNuevo.setMensaje("Por favor eliga un nombre (10 caracteres max)");
        // ponerle color, o reemplazar por imagen
        mensajeParaUsuarioNuevo.setVisible(false);

        /** area IngresoNombreDelUsuario **/
        CampoTexto areaIngresoNombreDelUsuario = new CampoTexto(unMarco,140,260,150,30);
        areaIngresoNombreDelUsuario.setVisible(false);

        /** botonGuardar -> stage 2 **/
        Boton botonGuardar = new BotonGuardar(unMarco,30,300,369,80);
        botonGuardar.setVisible(false);

        /** Stage 1.B : Cargar Usuario ----------------------------------**/
        // check box elegir usuario existente
        // boton aceptar -> stage 2

        /** Stage 2 : Menu Principal --------------------------------------------------------------------**/

        /** botonComenzarPartida -> stage 2.A **/
        Boton botonComenzarPartida = new BotonComenzarPartida(unMarco,30,150,369,80);
        botonComenzarPartida.setVisible(false);

        /** botonReanudarPartidaGuardada -> carga Xmlmapa y acciona el juego **/
        Boton botonReanudarPartidaGuardada = new BotonReanudarPartidaGuardada(unMarco,30,250,369,80);
        botonReanudarPartidaGuardada.setVisible(false);

        /** botonVerPuntajes -> stage 2.B **/
        Boton botonVerPuntajes = new BotonVerPuntajes(unMarco,30,350,369,80);
        botonVerPuntajes.setVisible(false);

        /** Stage 2.A : Eleccion Mapa y Carruaje ----------------------------------**/

        /** checkBoxEleccionMapa **/
        BoxEleccionMapa boxEleccionMapa = new BoxEleccionMapa(unMarco,200,165,100,60);
        boxEleccionMapa.setVisible(false);

        /** checkBoxEleccionVehiculo **/
        BoxEleccionVehiculo boxEleccionVehiculo = new BoxEleccionVehiculo(unMarco,30,165,150,60);
        boxEleccionVehiculo.setVisible(false);

        /** botonJugar -> acciona el juego **/
        Boton botonJugar = new BotonJugar(unMarco,30,370,369,80);
        botonJugar.setVisible(false);

        /** botonVolverDesde2Ahacia2 -> stage 2 **/
        // cambiar nombre a la varialble!
        Boton botonVolver = new BotonVolver(unMarco,30,580,369,80);
        botonVolver.setVisible(false);

        /** Stage 2.B : Puntajes ----------------------------------**/
        // table puntajes -> se carga Xmlpuntajes
        // botonVolver (juega 2 veces) -> stage 2








        /** zona de juego **/
        JPanel zonaDeJuego = new SuperficiePanel();
        zonaDeJuego.setBounds(440,50,870, 620); /** lo que mejor le queda? **/
        zonaDeJuego.setBackground(new Color(127, 197, 110));
        // la agregamos
        unMarco.add(zonaDeJuego);
        unaPartida.asignarZonaDeJuego(zonaDeJuego);

        /**Creo fondo (tiene que ser al final) **/
        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/fondoMenuPrincipal.png"));
        fondo.setBounds(0,0,unMarco.getWidth(),unMarco.getHeight());
        unMarco.add(fondo);

        /** Una vez que se agrego lo que necesitamos al marco, se lo hace visible **/
        unMarco.setVisible(true);

        /** VAMOS A JUGAR**/

        //Mapa.limpiar();
        //Nivel nivel = new Nivel();
        //unaPartida.cargarNivel(nivel);
        //unaPartida.crearPiloto("pilotin");
        //unaPartida.asignarCarroceriaDelVehiculo(new EstadoMoto());
        //unaPartida.cargarVehiculoParaElPiloto();


        /**IMPORTANTE, EL MARCO ES EL QUE TIENE EL CONTROL DE MOVIMIENTOS -> pasandolo a la zona de juego tmb anda**/
        unMarco.setFocusable(true);
        unMarco.addKeyListener((new Pausa(unaPartida)));
        unMarco.addKeyListener(new ControlDeMovimiento(unaPartida));



        /** Listas con los Elementos de cada Stage **/

        ArrayList<VistaMenu> stageEleccionUsuario = new ArrayList<VistaMenu>();
        stageEleccionUsuario.add(botonSoyNuevo);
        stageEleccionUsuario.add(botonIngresarUsuario);

        ArrayList<VistaMenu> stageUsuarioNuevo = new ArrayList<VistaMenu>();
        stageUsuarioNuevo.add(mensajeParaUsuarioNuevo);
        stageUsuarioNuevo.add(areaIngresoNombreDelUsuario);
        stageUsuarioNuevo.add(botonGuardar);

        ArrayList<VistaMenu> stageMenuPrincipal = new ArrayList<VistaMenu>();
        stageMenuPrincipal.add(botonComenzarPartida);
        stageMenuPrincipal.add(botonReanudarPartidaGuardada);
        stageMenuPrincipal.add(botonVerPuntajes);

        ArrayList<VistaMenu> stageEleccionMapaYVehiculo = new ArrayList<VistaMenu>();
        stageEleccionMapaYVehiculo.add(boxEleccionMapa);
        stageEleccionMapaYVehiculo.add(boxEleccionVehiculo);
        stageEleccionMapaYVehiculo.add(botonJugar);
        stageEleccionMapaYVehiculo.add(botonVolver);

        /** controles de los botones **/

        /** stage 1 **/
        botonSoyNuevo.addMouseListener(new ControlDeClickBoton(stageUsuarioNuevo,stageEleccionUsuario));
        botonGuardar.addMouseListener(new ControlDeClickBotonGuardar(unaPartida,areaIngresoNombreDelUsuario,stageMenuPrincipal,stageUsuarioNuevo));

        /** stage 2 **/
        botonComenzarPartida.addMouseListener(new ControlDeClickBoton(stageEleccionMapaYVehiculo,stageMenuPrincipal));

        boxEleccionVehiculo.getBoxAuto().addMouseListener(new ControlDeClickEleccionVehiculo(unaPartida , new EstadoAuto(), boxEleccionVehiculo));
        boxEleccionVehiculo.getBoxMoto().addMouseListener(new ControlDeClickEleccionVehiculo(unaPartida , new EstadoMoto() , boxEleccionVehiculo));
        boxEleccionVehiculo.getBox4x4().addMouseListener(new ControlDeClickEleccionVehiculo(unaPartida , new Estado4x4() , boxEleccionVehiculo));

        boxEleccionMapa.getBoxFacil().addMouseListener(new ControlDeClickEleccionMapa(unaPartida /*,xmlMapa*/ , boxEleccionMapa));
        boxEleccionMapa.getBoxModerado().addMouseListener(new ControlDeClickEleccionMapa(unaPartida /*,xmlMapa*/ , boxEleccionMapa));
        boxEleccionMapa.getBoxDificil().addMouseListener(new ControlDeClickEleccionMapa(unaPartida /*,xmlMapa*/ , boxEleccionMapa));


        /** por ahora **/
        botonJugar.addMouseListener(new ControlDeClickBotonJugar(unaPartida,null,stageEleccionMapaYVehiculo));

    }
}


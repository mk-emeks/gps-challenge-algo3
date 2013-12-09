package fiuba.algo3.control;


import fiuba.algo3.modelo.Estado4x4;
import fiuba.algo3.modelo.EstadoAuto;
import fiuba.algo3.modelo.EstadoMoto;
import fiuba.algo3.persistencia.RegistroUsuarios;
import fiuba.algo3.persistencia.RegistroUsuariosConPuntuacion;
import fiuba.algo3.persistencia.UsuarioConPuntuacion;
import fiuba.algo3.sonido.MusicaDeFondo;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.vista.VistasMenu.*;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.ArrayList;


public class gpsChallenge {

    public static void main(String[] argv) {


        /** Configuracion Ventana Principal **/
        final JFrame unMarco = new JFrame("GPS Challenge");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        unMarco.setBounds(0, 0, screenSize.width, screenSize.height);
        unMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        unMarco.setLayout(null);

        /** creo la partida **/
        final Partida unaPartida = new Partida();

        /** cargamos el registro de usuarios **/
        RegistroUsuarios registroUsuarios = new RegistroUsuarios();

        try {
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new FileInputStream(RegistroUsuarios.getNombreDelArchivo()));
            Element raiz = doc.getRootElement();
            registroUsuarios = new RegistroUsuarios(raiz);

        } catch (Exception e) {System.out.println("no se pudo cargar el registro de usuarios");}

        /** BOTONES **/

        /** Stage 1 : Eleccion Usuario --------------------------------------------------------------------**/

        /** boton Soy Nuevo -> stage 1.A **/
        Boton botonSoyNuevo = new BotonSoyNuevo(unMarco,30,150,369,80);
        botonSoyNuevo.setVisible(true);


        /** boton Ingresar Usuario -> stage 1.B **/
        Boton botonIngresarUsuario = new BotonIngresarUsuario(unMarco,30,250,369,80);
        botonIngresarUsuario.setVisible(true);

        /** Stage 1.A : Usuario Nuevo ----------------------------------**/

        /** texto mensajeParaUsuarioNuevo **/
        Texto mensajeParaUsuarioNuevo = new Texto(unMarco,40,200,380,40);
        mensajeParaUsuarioNuevo.setMensaje("Por favor, eliga un nombre (10 caracteres max)");
        // ponerle color, o reemplazar por imagen
        mensajeParaUsuarioNuevo.setVisible(false);

        /** area IngresoNombreDelUsuario **/
        CampoTexto areaIngresoNombreDelUsuario = new CampoTexto(unMarco,140,260,150,30);
        areaIngresoNombreDelUsuario.setVisible(false);

        /** botonGuardar -> stage 2 **/
        Boton botonGuardar = new BotonGuardar(unMarco,30,300,369,80);
        botonGuardar.setVisible(false);

        /** Stage 1.B : Cargar Usuario ----------------------------------**/

        /** texto listaUsuariosExistenes **/
        Texto listaUsuariosExistenes = new Texto(unMarco,40,150,380,40);
        listaUsuariosExistenes.setMensaje("Usuarios:");
        // ponerle color, dejarlo lindo
        listaUsuariosExistenes.setVisible(false);

        /** boxUsuariosExistentes **/
        BoxUsuariosExistentes boxUsuariosExistentes = new BoxUsuariosExistentes(registroUsuarios,unMarco,100,200,150,60);
        // ponerle color, dejarlo lindo
        boxUsuariosExistentes.setVisible(false);

        /** botonAceptar -> stage 2 **/
        Boton botonAceptar = new BotonAceptar (unMarco,30,400,369,80);
        botonAceptar.setVisible(false);


        /** Stage 2 : Menu Principal --------------------------------------------------------------------**/

        /** botonComenzarPartida -> stage 2.A **/
        Boton botonComenzarPartida = new BotonComenzarPartida(unMarco,30,150,369,80);
        botonComenzarPartida.setVisible(false);

        /** botonReanudarPartidaGuardada -> carga Xmlmapa y acciona el juego **/
        /** todo **/
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

        /** botonJugar -> acciona el juego, pasa al stage 3 **/
        Boton botonJugar = new BotonJugar(unMarco,30,370,369,80);
        botonJugar.setVisible(false);

        /** botonVolver Stage 2.A --> Stage 2, Menu Principal**/
        Boton botonVolverAlMenuPrincipalSimple = new BotonVolver(unMarco,30,580,369,80);
        botonVolverAlMenuPrincipalSimple.setVisible(false);


        /** Stage 2.B : Puntajes ----------------------------------**/
        Texto listaDePuntajes = new Texto(unMarco,40,150,380,40);
        listaDePuntajes.setMensaje("Puntajes:");
        listaDePuntajes.setVisible(false);

        /** boxUsuariosConPuntajes **/
        BoxUsuariosConPuntajes boxUsuariosConPuntajes = new BoxUsuariosConPuntajes(unMarco,100,200,150,60);
        boxUsuariosConPuntajes.setVisible(false);

        /** botonVolverAlMenuPrincipalDesdePuntajes Stage 2.A --> Stage 2, Menu Principal**/
        Boton botonVolverAlMenuPrincipalDesdePuntajes = new BotonVolver(unMarco,30,580,369,80);
        botonVolverAlMenuPrincipalDesdePuntajes .setVisible(false);


        /** Stage 3 : Juego en Accion --------------------------------------------------------------------**/
        /** todo **/

        /** botonAnimadoCronometro **/

        /** vistaCronometro **/
        VistaCronometro vistaCronometro = new VistaCronometro(unaPartida.getPiloto().getCronometro(),unMarco,100,500,300,40);
        unaPartida.asignarVistaAlCronometro(vistaCronometro);
        vistaCronometro.setVisible(false);


        /** botonAnimadoVehiculo **/
        BotonAnimadoVehiculo botonAnimadoVehiculo = new BotonAnimadoVehiculo(unaPartida,unMarco,120,330,369,150);
        botonAnimadoVehiculo.setVisible(false);

        /**VistaFinalizada**/
        VistaFinalizacion vistaFinalizacion = new VistaFinalizacion(unaPartida);
        vistaFinalizacion.setVisible(false);

        /** botonGuargarPartida **/
        //Boton botonGuardarPartida = new BotonGuardar()

        /** botonVolverMenuPrincipalDesdeJuegoEnAccion **/
        Boton botonVolverMenuPrincipalDesdeJuegoEnAccion = new BotonVolver(unMarco,30,580,369,80);
        botonVolverMenuPrincipalDesdeJuegoEnAccion.setVisible(false);






        /** zona de juego **/
        JPanel zonaDeJuego = new SuperficiePanel();
        zonaDeJuego.setBounds(440,50,870, 620); /** lo que mejor le queda? **/
        zonaDeJuego.setBackground(Color.BLACK);
        //zonaDeJuego.setBackground(new Color(127, 197, 110));
        // la agregamos
        unMarco.add(zonaDeJuego);
        unaPartida.asignarZonaDeJuego(zonaDeJuego);

        /**Creo fondo (tiene que ser al final) **/
        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/fondoMenuPrincipal.png"));
        fondo.setBounds(0, 0, unMarco.getWidth(), unMarco.getHeight());
        unMarco.add(fondo);

        /** Una vez que se agrego lo que necesitamos al marco, se lo hace visible **/
        unMarco.setVisible(true);

        /** VAMOS A JUGAR**/
        // viejo, solo de referencia del orden de lo que se deberia hacer.

        //Mapa.limpiar();
        //
        //unaPartida.cargarNivel(nivel);
        //unaPartida.crearPiloto("pilotin");
        //unaPartida.asignarCarroceriaDelVehiculo(new EstadoMoto());
        //unaPartida.cargarVehiculoParaElPiloto();


        /**IMPORTANTE, EL MARCO ES EL QUE TIENE EL CONTROL DE MOVIMIENTOS -> pasandolo a la zona de juego tmb anda**/
        unMarco.setFocusable(true);
        unMarco.addKeyListener((new Pausa(unaPartida)));
        unMarco.addKeyListener(new ControlDeMovimiento(unaPartida));



        /** Listas con los Elementos de cada Stage **/

        /** Stage 1: Eleccion Usuario **/
        ArrayList<VistaMenu> stageEleccionUsuario = new ArrayList<VistaMenu>();
        stageEleccionUsuario.add(botonSoyNuevo);
        stageEleccionUsuario.add(botonIngresarUsuario);

        /**Stage 1.A: Usuario nuevo **/
        ArrayList<VistaMenu> stageUsuarioNuevo = new ArrayList<VistaMenu>();
        stageUsuarioNuevo.add(mensajeParaUsuarioNuevo);
        stageUsuarioNuevo.add(areaIngresoNombreDelUsuario);
        stageUsuarioNuevo.add(botonGuardar);

        /**Stage 2.B: Cargar Usuario **/
        ArrayList<VistaMenu> stageCargarUsuario  = new ArrayList<VistaMenu>();
        stageCargarUsuario.add(listaUsuariosExistenes);
        stageCargarUsuario.add(boxUsuariosExistentes);
        stageCargarUsuario.add(botonAceptar);

        /** Stage 2: Menu Principal  **/
        ArrayList<VistaMenu> stageMenuPrincipal = new ArrayList<VistaMenu>();
        stageMenuPrincipal.add(botonComenzarPartida);
        stageMenuPrincipal.add(botonReanudarPartidaGuardada);
        stageMenuPrincipal.add(botonVerPuntajes);

        /**Stage 2.A: Eleccion Mapa y Vehiculo**/
        ArrayList<VistaMenu> stageEleccionMapaYVehiculo = new ArrayList<VistaMenu>();
        stageEleccionMapaYVehiculo.add(boxEleccionMapa);
        stageEleccionMapaYVehiculo.add(boxEleccionVehiculo);
        stageEleccionMapaYVehiculo.add(botonJugar);
        stageEleccionMapaYVehiculo.add(botonVolverAlMenuPrincipalSimple);

        /** 2.B: Puntajes**/
        ArrayList<VistaMenu> stagePuntajes  = new ArrayList<VistaMenu>();
        stagePuntajes.add(listaDePuntajes);
        stagePuntajes.add(boxUsuariosConPuntajes);
        stagePuntajes.add(botonVolverAlMenuPrincipalDesdePuntajes);

        /** Stage 3 : Juego en Accion **/
        ArrayList<VistaMenu> stageJuegoEnAccion = new ArrayList<VistaMenu>();
        stageJuegoEnAccion.add(vistaCronometro);
        stageJuegoEnAccion.add(botonAnimadoVehiculo);
        stageJuegoEnAccion.add(vistaFinalizacion);
        stageJuegoEnAccion.add(botonVolverMenuPrincipalDesdeJuegoEnAccion);


        /** Controles de los botones segun stage **/

        /** Stage 1: Eleccion Usuario **/

        botonSoyNuevo.addMouseListener(new ControlDeClickBoton(stageUsuarioNuevo, stageEleccionUsuario));
        botonIngresarUsuario.addMouseListener(new ControlDeClickBoton(stageCargarUsuario,stageEleccionUsuario));

        /**Stage 1.A: Usuario nuevo **/

        botonGuardar.addMouseListener(new ControlDeClickBotonGuardar(registroUsuarios, unaPartida, areaIngresoNombreDelUsuario, stageMenuPrincipal, stageUsuarioNuevo));


        /**Stage 2.B: Cargar Usuario **/

        boxUsuariosExistentes.getItemBox1erNombre().addMouseListener(new ControlDeClickEleccionUsuarioExistente(boxUsuariosExistentes.getItemBox1erNombre() , unaPartida , boxUsuariosExistentes));
        boxUsuariosExistentes.getItemBox2doNombre().addMouseListener(new ControlDeClickEleccionUsuarioExistente( boxUsuariosExistentes.getItemBox1erNombre(), unaPartida , boxUsuariosExistentes));
        boxUsuariosExistentes.getItemBox3erNombre().addMouseListener(new ControlDeClickEleccionUsuarioExistente( boxUsuariosExistentes.getItemBox1erNombre() ,unaPartida  , boxUsuariosExistentes));

        botonAceptar.addMouseListener(new ControlDeClickBoton(stageMenuPrincipal, stageCargarUsuario));


        /** Stage 2: Menu Principal  **/

        botonComenzarPartida.addMouseListener(new ControlDeClickBoton(stageEleccionMapaYVehiculo, stageMenuPrincipal));
        botonVerPuntajes.addMouseListener(new ControlDeClickBoton(stagePuntajes, stageMenuPrincipal));

        /**Stage 2.A: Eleccion Mapa y Vehiculo**/

        boxEleccionVehiculo.getItemBoxAuto().addMouseListener(new ControlDeClickEleccionVehiculo(new EstadoAuto(), unaPartida , boxEleccionVehiculo));
        boxEleccionVehiculo.getItemBoxMoto().addMouseListener(new ControlDeClickEleccionVehiculo( new EstadoMoto(), unaPartida , boxEleccionVehiculo));
        boxEleccionVehiculo.getItemBox4x4().addMouseListener(new ControlDeClickEleccionVehiculo( new Estado4x4() ,unaPartida  , boxEleccionVehiculo));

        boxEleccionMapa.getItemBoxFacil().addMouseListener(new ControlDeClickEleccionMapa("mapaFacil.xml",unaPartida , boxEleccionMapa));
        boxEleccionMapa.getItemBoxModerado().addMouseListener(new ControlDeClickEleccionMapa("mapaModerado.xml" ,unaPartida , boxEleccionMapa));
        boxEleccionMapa.getItemBoxDificil().addMouseListener(new ControlDeClickEleccionMapa("mapaDificil.xml" ,unaPartida , boxEleccionMapa));

        botonJugar.addMouseListener(new ControlDeClickBotonJugar(boxEleccionMapa, boxEleccionVehiculo, vistaFinalizacion,botonAnimadoVehiculo, unaPartida, stageJuegoEnAccion, stageEleccionMapaYVehiculo));

        botonVolverAlMenuPrincipalSimple.addMouseListener(new ControlDeClickBoton(stageMenuPrincipal, stageEleccionMapaYVehiculo));

        /** 2.B: Puntajes**/

        botonVolverAlMenuPrincipalDesdePuntajes.addMouseListener(new ControlDeClickBoton(stageMenuPrincipal,stagePuntajes));





        /** musica de fondo, tiene que ir al final **/

        MusicaDeFondo.playMusic();

    }



}


package fiuba.algo3.sonido;

import javazoom.jlme.util.Player;
//import javazoom.jl.player.advanced.AdvancedPlayer;

public class MusicaDeFondo {

    public MusicaDeFondo() {}

    public static void playMusic() {
        try {
            Player reproductor = new Player(MusicaDeFondo.class.getResourceAsStream("bornToBeWild.mp3"));
            reproductor.play();
            }
            catch (Exception e) {
                System.out.println("no se encontro el archivo para reproducir");

            }
    }
}



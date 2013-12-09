package fiuba.algo3.sonido;

import javazoom.jlme.util.Player;

public class MusicaCheat {

    public MusicaCheat() {}

    public static void playMusic() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Player reproductor = new Player(MusicaDeFondo.class.getResourceAsStream("willy.mp3"));
                    reproductor.play();
                }
                catch (Exception e) {
                    System.out.println("no se encontro el archivo para reproducir");

                }

            }
        }).start();

    }

}

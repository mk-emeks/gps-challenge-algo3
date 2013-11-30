package fiuba.algo3.masterOfPuppets;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class KeyPressedObservable extends KeyAdapter implements KeyListener {
	
	private GameLoop gameLoop;
	
	public KeyPressedObservable(GameLoop gameLoop){
		this.gameLoop = gameLoop;
	}

	public void keyPressed(KeyEvent e) {
		this.gameLoop.despacharKeyPress(e);
	}

	public void keyReleased(KeyEvent e) {
		this.gameLoop.despacharKeyPress(e);
	}

}

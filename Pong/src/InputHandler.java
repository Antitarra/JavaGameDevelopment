import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

    public InputHandler(Game game) {
        game.addKeyListener(this);
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == e.VK_W) {//if pressed key is W
            Game.player.goingUp = true;
        }
        if (keyCode == e.VK_S) {//if pressed key is S
            Game.player.goingDown = true;
        }

        // Player 2 controls

        if (keyCode == KeyEvent.VK_UP) {//if pressed key is Up_Arrow
            Game.ai.goingUp = true;
        }

        if (keyCode == KeyEvent.VK_DOWN) {//if pressed key is Down_Arrow
            Game.ai.goingDown = true;
        }

        // Exit button *Esc*
        if (keyCode == KeyEvent.VK_ESCAPE) {//if pressed key is Escape

            Game.stop();
            new MainMenu();
        }
    }

    public void keyReleased(KeyEvent e) {//what happens when you release the key
        int keyCode = e.getKeyCode();

        // Player #1 controls
        if (keyCode == e.VK_W) {
            Game.player.goingUp = false;
        }
        if (keyCode == e.VK_S) {
            Game.player.goingDown = false;
        }

        // Player 2 controls

        if (keyCode == KeyEvent.VK_UP) {
            Game.ai.goingUp = false;
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            Game.ai.goingDown = false;
        }
    }

}

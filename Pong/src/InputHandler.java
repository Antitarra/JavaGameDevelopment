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

        if (keyCode == e.VK_W) {
            Game.player.goingUp = true;
        }
        if (keyCode == e.VK_S) {
            Game.player.goingDown = true;
        }

        // Player 2 controls

        if (keyCode == KeyEvent.VK_UP) {
            Game.ai.goingUp = true;
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            Game.ai.goingDown = true;
        }

        // Exit button *Esc*
        if (keyCode == KeyEvent.VK_ESCAPE) {

            new MainMenu();
        }
    }


    public void keyReleased(KeyEvent e) {
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

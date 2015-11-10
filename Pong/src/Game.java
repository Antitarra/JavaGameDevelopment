import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;

    public static PlayerPaddle player;
    public static AIPaddle ai;
    public static Ball ball;
    InputHandler IH;

    static JFrame frame; // Window of the game
    public final int WIDTH = 590; // Width of window
    public final int HEIGHT = WIDTH / 16 * 9; // Height of window
    public final Dimension gameSize = new Dimension(WIDTH, HEIGHT); // Size of
   // public  Image image;

    public final String TITLE = "Pong";

    BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
            BufferedImage.TYPE_INT_RGB);

    static boolean gameRunning = false;
    public static int p1Score, p2Score;
    final int WIN_POINTS = 5;
    boolean winner = false;

    public void run() {
        while (gameRunning) { // If gameRunning = true
            tick();
            render();

            try {
                Thread.sleep(7);
            }

            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void start() {
        p1Score = 0;
        p2Score = 0;
        gameRunning = true;
        new Thread(this).start();
    } // End start method

    public static synchronized void stop() {
        gameRunning = false;
        frame.dispose();
        //System.exit(0);

    } // End stop method
    public static synchronized void visible() {

    }

    public Game() {
        frame = new JFrame();
        setMinimumSize(gameSize);
        setPreferredSize(gameSize);
        setMaximumSize(gameSize);

        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close program when you click the cross , at the right top
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle(TITLE);
        frame.setLocationRelativeTo(null); // This put the frame in center

        try {
            image = ImageIO.read(new File("gameBackground_resized.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        IH = new InputHandler(this);

        player = new PlayerPaddle(10, 60);
        ai = new AIPaddle(getWidth() - 20, 60);
        ball = new Ball(getWidth() / 2, getHeight() / 2);
    }

    public void tick() {
        if(!winner) {
            player.tick(this);
            ai.tick(this);
            ball.tick(this);
        }
    }

    public void render() {

        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.drawImage(image, 0, 0, null);

        int fontSize = 20;
        g.setFont(new Font("Serif", Font.PLAIN, fontSize));
        g.setColor(Color.WHITE);

        g.drawString("Player 1: " + p1Score, 105, 20);    //5, 10
        g.drawString("Player 2: " + p2Score, getWidth() - 180, 20); //5, -60


        if(p2Score == WIN_POINTS){

            g.drawString("PRESS ESC", 250, 210);
            g.setColor(Color.GREEN);
            g.setFont(new Font("impact", Font.PLAIN, 50));
            g.drawString("Player 2 WIN", 180, 180);
            winner = true;


        }else if(p1Score == WIN_POINTS){

            g.drawString("PRESS ESC", 250, 210);
            g.setColor(Color.blue);
            g.setFont(new Font("impact", Font.PLAIN, 50));
            g.drawString("Player 1 WIN", 180, 180);
            winner = true;

        }else {

            player.render(g);
            ai.render(g);
            ball.render(g);

        }

        g.dispose();
        bs.show();
    }
}
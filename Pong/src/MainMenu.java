import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class MainMenu extends JFrame {
    private static final long serialVersionUID = 1L;

    int screenWidth = 300;
    int screenHeight = 170;

    int buttonWidth = 180;
    int buttonHeight = 40;

    JButton vsComputer, vsPlayer, Quit;
    // JCheckBox twoPlayers;

    public MainMenu() {

        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(new File("background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setContentPane(new ImagePanel(myImage));

        addButtons();
        addActions();

        getContentPane().setLayout(null);

        //button positioning
        vsComputer.setBounds((screenWidth - buttonWidth) / 2, 5, buttonWidth,
                buttonHeight);
        vsPlayer.setBounds((screenWidth - buttonWidth) / 2, 50, buttonWidth,
                buttonHeight);
        Quit.setBounds((screenWidth - (buttonWidth-90)) / 2, 95, buttonWidth-90,
                buttonHeight);

        getContentPane().add(vsComputer);
        getContentPane().add(vsPlayer);
        getContentPane().add(Quit);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(screenWidth, screenHeight);
        setTitle("Pong Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }

    private void addButtons() {
        vsComputer = new JButton("Player vs Computer");
        vsPlayer = new JButton("Player vs Player");
        Quit = new JButton("Quit");

    }

    private void addActions() {
        vsComputer.addActionListener(new ActionListener() { // Take vsComputer button, add

            // new actionListener
            public void actionPerformed(ActionEvent e) {
                dispose();
                Game game = new Game();
                game.start();
            }
        }); // vsComputer button

        vsPlayer.addActionListener(new ActionListener() { // Take vsPlayer button, add

            // new actionListener
            public void actionPerformed(ActionEvent e) {
                dispose();
                Game game = new Game();
                game.ai.isTwoPlayer=true;
                game.start();
            }
        }); // vsPlayer button

        Quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Game shutdown
            }
        }); // Quit button
    }
}
class ImagePanel extends JComponent {
    private Image image;

    public ImagePanel(Image image){
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}
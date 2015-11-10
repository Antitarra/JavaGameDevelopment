import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MainMenu extends JFrame {
    private static final long serialVersionUID = 1L;

    int screenWidth = 300;
    int screenHeight = 170;

    int buttonWidth = 180;
    int buttonHeight = 40;

    JButton vsComputer, vsPlayer, Quit;
    // JCheckBox twoPlayers;

    public MainMenu() {



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

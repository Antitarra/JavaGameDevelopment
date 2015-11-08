import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainMenu extends JFrame {
    private static final long serialVersionUID = 1L;

    int screenWidth = 300;
    int screenHeight = 170;

    int buttonWidth = 120;
    int buttonHeight = 40;

    JButton vsComputer, vsPlayer, Quit;
   // JCheckBox twoPlayers;

    public MainMenu() {

    	try {
     		setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("menuBackground.png")))));
     	} catch (IOException e) {
     		e.printStackTrace();
     	}
    	
        addButtons();
        addActions();

        getContentPane().setLayout(null);

        //button positioning
        vsComputer.setBounds((screenWidth - buttonWidth) / 2, 5, buttonWidth,
                buttonHeight);
        vsPlayer.setBounds((screenWidth - buttonWidth) / 2, 50, buttonWidth,
                buttonHeight);
        Quit.setBounds((screenWidth - buttonWidth) / 2, 95, buttonWidth,
                buttonHeight);
        //twoPlayers.setBounds((screenWidth - buttonWidth) / 2, 90, buttonWidth, buttonHeight);

        getContentPane().add(vsComputer);
        getContentPane().add(vsPlayer);
        getContentPane().add(Quit);
        //getContentPane().add(twoPlayers);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(screenWidth, screenHeight);
        setTitle("Pong Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
    }

    private void addButtons() {
        vsComputer = new JButton("vsComputer");
        vsPlayer = new JButton("vsPlayer");
        Quit = new JButton("Quit");
        //twoPlayers = new JCheckBox("2 Players");
    }

    private void addActions() {
        vsComputer.addActionListener(new ActionListener() { // Take Play button, add

            // new actionListener
            public void actionPerformed(ActionEvent e) { // Turn the action
                // performed into a
                // variable for								// usage
                dispose();
                Game game = new Game();
                if (vsPlayer.isSelected()) {
                    game.ai.isTwoPlayer = true;
                } else {
                    game.ai.isTwoPlayer = false;
                }

                game.start();
            }
        }); // Play button

        Quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Game shutdown
            }
        }); // Quit button
    }
}

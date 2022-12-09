package main;

import javax.swing.JFrame;

public class Main {

  public static void main(String[] args) {

    JFrame window = new JFrame(); // Create a window
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the window
    window.setResizable(false); // Window can not be resized
    window.setTitle("Entangled");

    GamePanel gamePanel = new GamePanel();
    window.add(gamePanel); // adding the gamePanel to the screen

    window.pack(); // the window is going to be resized to fit the preferred size and layout of its subcomponents (GamePanel)

    window.setLocationRelativeTo(null); // The window will appear in the center of the screen
    window.setVisible(true); // To see the window
    
    //setting up objects...
    gamePanel.setupGame();

    //starting game thread:
    gamePanel.startGameThread();

  }
}
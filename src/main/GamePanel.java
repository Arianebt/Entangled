package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable{
  // JPanel will work as a game screen

  // Screen settings
  final int originalTileSize = 16; // 16x16 tile
  // it will be the size of the char, npc,... - but for the computer size it would
  // be too small, so I will scale it
  final int scale = 3;
  
  //setting up tile size and screen dimensions
  public final int tileSize = originalTileSize * scale; // 48 x 48 tile
  public final int maxScreenCol = 16;// size horizontally
  public final int maxScreenRow = 12;// size vertically
  public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
  public final int screenHeight = tileSize * maxScreenRow;// 576px
  
  //World map parameters:
  public final int maxWorldCol = 50;
  public final int maxWorldRow = 50;
  public int worldWidth = tileSize * maxWorldCol;
  public int worldHeight = tileSize * maxWorldRow;
  
  //FPS
  int FPS= 60;
  //Instantiating Game Mechanics
  TileManager tileM = new TileManager(this);
  KeyHandler keyH = new KeyHandler(this);  //Instantiating KeyHandler object
  Thread gameThread;  //Declaring game thread
  public CollisionChecker cChecker = new CollisionChecker(this);//Instantiating Collision Checker Class
  public AssetSetter aSetter = new AssetSetter(this);//Instantiating AssetSetter Class
  public EventHandler eHandler = new EventHandler(this);

// Entity and object
  public Player player = new Player(this,keyH);	//Instantiating player entity passing the key handler argument
  public SuperObject obj[] = new SuperObject[10]; //Instantiating objects with its image and other properties
  public UI ui = new UI(this);

  //Game State:
  public int gameState;
  public final int playState = 1;
  public final int pauseState = 2;
  public final int dialogState = 3;

  


  //Class Constructor:
  public GamePanel() {

    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true); // improve game's rendering performance
    this.addKeyListener(keyH); //adding the KeyHandler object to this game panel
    this.setFocusable(true);  //turning the game panel focused on receiving key input

  }
  
  public void setupGame() {
	  
	  aSetter.setObject();//placing all the objects on the map
    gameState = playState;

  }
  //Game Thread Instantiating
  public void startGameThread() {

    gameThread = new Thread(this);
    gameThread.start();
  }
  //Run Method (Runnable Interface)
  @Override
  public void run() {
    //implementing delta method for updating frame intervals at a FPS frequency:
    double drawInterval = 1000000000/FPS; //0.01666 seconds
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;
    //control of FPS
    long timer = 0;
    int drawCount = 0;

    while(gameThread != null){
      currentTime = System.nanoTime();
      delta += (currentTime - lastTime) / drawInterval;
      timer += (currentTime - lastTime);
      lastTime = currentTime;

      if(delta>=1){
      // 1 UPDATE: update information such as character positions
      update();
      //2 DRAW: draw the screen with updated information calling the paintComponent method
      repaint();
      delta=0;
      drawCount++;
      }
      //monitoring FPS
      if(timer>=1000000000){
        System.out.println("FPS: "+ drawCount);
        drawCount = 0;
        timer = 0;
      }
    }
    //end of delta method
  }
  
  //update method
  public void update() {

    if(gameState == playState){
      player.update();
    }
    
    if (gameState == pauseState) {
      //nothing
    }

  }
  //paint component method
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    //Graphic to Graphic2D conversion:
    Graphics2D g2 = (Graphics2D)g;
    //Drawing the tiles:
    tileM.draw(g2);
    //Drawing the objects
    for(int i = 0; i < obj.length; i++) {
    	if(obj[i] != null) {
    		obj[i].draw(g2, this);
    	}
    }
    //Drawing the player on the screen:
    player.draw(g2);
    //Drawing User Interface
    ui.draw(g2);

    g2.dispose();
  }

}
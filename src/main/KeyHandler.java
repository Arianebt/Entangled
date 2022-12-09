package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }
    
    //implemente interface methods:
    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
    //returns the int value ASCII code of the key pressed in this event
    int code = e.getKeyCode(); 
    
    //PLAY STATE
    if(gp.gameState == gp.playState){
        
        //checking the key pressed with the diretional WASD buttons:
        if(code==KeyEvent.VK_W){
            upPressed = true;
        }
        if(code==KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code==KeyEvent.VK_S){
            downPressed = true;
        }
        if(code==KeyEvent.VK_D){
            rightPressed = true;
        }
        if(code==KeyEvent.VK_ESCAPE){
            gp.gameState = gp.pauseState;
        }
        if(code==KeyEvent.VK_ENTER){
            enterPressed = true;
        }
    }

    //PAUSE STATE
    else if(gp.gameState == gp.pauseState){
        if(code==KeyEvent.VK_ESCAPE){
            gp.gameState = gp.playState;
        }
    }

    //DIALOG STATE

   else if(gp.gameState == gp.dialogState){
        if(code==KeyEvent.VK_ENTER){
            gp.gameState = gp.playState;
        }
    }
    
    }
    

    @Override
    public void keyReleased(KeyEvent e) {
        //returns the int value ASCII code of the key released in this event
        int code = e.getKeyCode(); 
    
        //checking the key released with the diretional WASD buttons:
        if(code==KeyEvent.VK_W){
            upPressed = false;
        }
        if(code==KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code==KeyEvent.VK_S){
            downPressed = false;
        }
        if(code==KeyEvent.VK_D){
            rightPressed = false;
        }
        if(code==KeyEvent.VK_ENTER){
            enterPressed = false;
        }
    }



}
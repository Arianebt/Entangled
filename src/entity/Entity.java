package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    //setting position and pace
    public int worldX, worldY;
    public int speed;

    //setting images
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    //walking animation mechanics:
    public int spriteCounter = 0;
    public int spriteNum = 1;
    //setting solid area:
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    
}

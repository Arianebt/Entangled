package main;

import java.awt.Rectangle;

public class EventHandler {
    
    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;
    boolean clockKeyE = false;
    int startEventE = 0;
    String dialogues[] = new String[20];

    public EventHandler (GamePanel gp){
        this.gp = gp;

        eventRect = new Rectangle();
        eventRect.x = 23;
        eventRect.y = 10;
        eventRect.width = 2;
        eventRect.height = 2;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;

        setDialog();

    }

    public void setDialog(){
        dialogues[0] = "What a headache!!!";
        dialogues[1] = "Where am I??";
        dialogues[2] = "What just happened??";
        dialogues[3] = "I was going to shop some groceries \nand now I'm here!";
        dialogues[4] = "Let me search around and probably \n I'll figure it out!\n There is a computer right there! \n Just hit enter to interact with it!";
        dialogues[5] = "Seems like I'm in an island!";
        dialogues[6] = "And... There is only 2 minutes to \nget out of here and put \n me inside a boat! \nWhaaaaat!!??";
        dialogues[7] = "Seems like this captain \ndoesn't likes to wait!";
        dialogues[15] = "What! That's the key \nI've been searching for!";
        dialogues[16] = "There is nothing more \nbehind the clock!";
        dialogues[17] = "Such a beautiful painting!";
        dialogues[18] = "That's awesome! Now I'm safe!";
        dialogues[19] = "Time is the only antidote!";

        


    }

    public void checkEvent() {
        if (gp.ui.playTime > 0) {startEvent();}
        if (hit(2,2,"up")) {doorPassage();}
        if (hit(31,13,"down")) {doorPassage2();}
        if (hit(38,9,"up")){clockKey();}
        if (hit(48,9,"up")) {doorPassage3();}
        if (hit(2,48,"down")) {doorPassage4();}
        if (hit(12,7,"left")) {computer();}
        if (hit(14,37,"right")) {finalGame();}
        if (hit(11,2,"up")||hit(10,2,"up")) {painting();}
        if (hit(4,3,"up")||hit(5,3,"up")||hit(40,11,"up")) {note();}

        }


    public boolean hit(int eventCol, int eventRow, String reqDirection) {

        boolean hit = false;
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect.x = eventCol*gp.tileSize + eventRect.x;
        eventRect.y = eventRow*gp.tileSize + eventRect.y;

        if(gp.player.solidArea.intersects(eventRect)) {
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                hit = true;
            }
        }
        //reseting the solid area x and y from player
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;

        return hit;
    }

    public void doorPassage(){
        gp.player.worldX= 31 * gp.tileSize;
		gp.player.worldY = 13 * gp.tileSize;
    }

    public void doorPassage2(){
        gp.player.worldX= 2 * gp.tileSize;
		gp.player.worldY = 2 * gp.tileSize;
    }

    public void clockKey(){
        if(gp.player.keyH.enterPressed == true && !clockKeyE){

            gp.gameState = gp.dialogState;
            gp.ui.currentDialog = dialogues[15];
            gp.player.hasKey++;
            System.out.println("Key: "+ gp.player.hasKey);
            clockKeyE = true;
        }

        else if(gp.player.keyH.enterPressed == true){

            gp.gameState = gp.dialogState;
            gp.ui.currentDialog = dialogues[16];
        }
    }

    public void doorPassage3(){
        gp.player.worldX= 2 * gp.tileSize;
		gp.player.worldY = 48 * gp.tileSize;
    }

    public void doorPassage4(){
        gp.player.worldX= 48 * gp.tileSize;
		gp.player.worldY = 9 * gp.tileSize;
    }

    public void startEvent(){
        if(startEventE < 5){
            gp.gameState = gp.dialogState;
            gp.ui.currentDialog = dialogues[startEventE];
            startEventE++;
        }
        
    }

    public void computer(){
        if(gp.player.keyH.enterPressed == true){

            if(startEventE < 8){
                gp.gameState = gp.dialogState;
                gp.ui.currentDialog = dialogues[startEventE];
            }
            startEventE++;

            if(startEventE == 7){
                gp.ui.timerOn = true;
            }
        }
        
    }

    public void finalGame(){
        if(gp.player.keyH.enterPressed == true){
            gp.gameState = gp.dialogState;
            gp.ui.currentDialog = dialogues[18];
            gp.ui.timerOn = false;
            gp.ui.winGame = true;
        }
    }

    public void painting(){
        if(gp.player.keyH.enterPressed == true){
            gp.gameState = gp.dialogState;
            gp.ui.currentDialog = dialogues[17];
        }
    }

    public void note(){
        if(gp.player.keyH.enterPressed == true){
            gp.gameState = gp.dialogState;
            gp.ui.currentDialog = dialogues[19];
        }
    }
    
    
}


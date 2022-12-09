package main;

import object.OBJ_Boots;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {

	GamePanel gp;
	//class constructor
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	//setting positions of all the objects on the map.
	public void setObject() {
		
		gp.obj[0]= new OBJ_Key();
		gp.obj[0].worldX = 12 * gp.tileSize;
		gp.obj[0].worldY = 5 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Door();
		gp.obj[1].worldX = 2 * gp.tileSize;
		gp.obj[1].worldY = (2 * gp.tileSize) - 22; //positioning door inbetween 2 tiles

		gp.obj[2] = new OBJ_Boots();
		gp.obj[2].worldX = 5 * gp.tileSize;
		gp.obj[2].worldY = 7 * gp.tileSize;

		gp.obj[3] = new OBJ_Door();
		gp.obj[3].worldX = 48 * gp.tileSize;
		gp.obj[3].worldY = (10 * gp.tileSize) - 22; //positioning door inbetween 2 tiles
	}
}

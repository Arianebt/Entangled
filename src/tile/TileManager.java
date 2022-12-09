package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
//declaring class variables
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	//class constructor
	public TileManager(GamePanel gp) {
		this.gp = gp;
		tile = new Tile[70];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/finalmap.txt");
		
	}
	//method that downloads images and assign that one to an element on the tile array.
	public void getTileImage() {
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[1].collision = true;
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
			tile[2].collision = true;
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
			tile[4].collision = true;
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));

			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall_indoor.png"));
			tile[6].collision = true;

			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall_carpet.png"));
			tile[7].collision = false;

			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall_carpet_up_left_corner.png"));
			tile[8].collision = true;

			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall_carpet_left.png"));
			tile[9].collision = true;

			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall_carpet_down_left_corner.png"));
			tile[10].collision = true;

			tile[11] = new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall_carpet_down.png"));
			tile[11].collision = true;

			tile[12] = new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall_carpet_down_right_corner.png"));
			tile[12].collision = true;

			tile[13] = new Tile();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall_carpet_right.png"));
			tile[13].collision = true;

			tile[14] = new Tile();
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall_carpet_up_right_corner.png"));
			tile[14].collision = true;

			tile[15] = new Tile();
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall_carpet_ext_up_right_corner.png"));
			tile[15].collision = false;

			tile[16] = new Tile();
			tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall_carpet_ext_up_left_corner.png"));
			tile[16].collision = false;

			tile[17] = new Tile();
			tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall_carpet_ext_down_left_corner.png"));
			tile[17].collision = true;

			tile[18] = new Tile();
			tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall_carpet_ext_down_right_corner.png"));
			tile[18].collision = true;

			tile[19] = new Tile();
			tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/lamp_base.png"));
			tile[19].collision = true;

			tile[20] = new Tile();
			tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/lamp_top.png"));
			tile[20].collision = true;

			tile[21] = new Tile();
			tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/picture_wall_right.png"));
			tile[21].collision = true;

			tile[22] = new Tile();
			tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/picture_wall_left.png"));
			tile[22].collision = true;

			tile[23] = new Tile();
			tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/door_down.png"));

			tile[24] = new Tile();
			tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/door_up.png"));

			tile[25] = new Tile();
			tile[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/clock_wall.png"));
			tile[25].collision = true;

			tile[26] = new Tile();
			tile[26].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bookshelf_down_left.png"));
			tile[26].collision = true;

			tile[27] = new Tile();
			tile[27].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bookshelf_down_right.png"));
			tile[27].collision = true;

			tile[28] = new Tile();
			tile[28].image = ImageIO.read(getClass().getResourceAsStream("/tiles/28.png"));
			tile[28].collision = true;

			tile[29] = new Tile();
			tile[29].image = ImageIO.read(getClass().getResourceAsStream("/tiles/29.png"));
			tile[29].collision = true;

			tile[30] = new Tile();
			tile[30].image = ImageIO.read(getClass().getResourceAsStream("/tiles/30.png"));
			tile[30].collision = true;

			tile[31] = new Tile();
			tile[31].image = ImageIO.read(getClass().getResourceAsStream("/tiles/31.png"));
			tile[31].collision = true;

			tile[32] = new Tile();
			tile[32].image = ImageIO.read(getClass().getResourceAsStream("/tiles/32.png"));
			tile[32].collision = true;

			tile[33] = new Tile();
			tile[33].image = ImageIO.read(getClass().getResourceAsStream("/tiles/33.png"));
			tile[33].collision = true;

			tile[34] = new Tile();
			tile[34].image = ImageIO.read(getClass().getResourceAsStream("/tiles/34.png"));
			tile[34].collision = true;

			tile[35] = new Tile();
			tile[35].image = ImageIO.read(getClass().getResourceAsStream("/tiles/35.png"));

			tile[36] = new Tile();
			tile[36].image = ImageIO.read(getClass().getResourceAsStream("/tiles/36.png"));

			tile[37] = new Tile();
			tile[37].image = ImageIO.read(getClass().getResourceAsStream("/tiles/37.png"));
			

			tile[38] = new Tile();
			tile[38].image = ImageIO.read(getClass().getResourceAsStream("/tiles/38.png"));
			

			tile[39] = new Tile();
			tile[39].image = ImageIO.read(getClass().getResourceAsStream("/tiles/39.png"));
			

			tile[40] = new Tile();
			tile[40].image = ImageIO.read(getClass().getResourceAsStream("/tiles/40.png"));
			

			tile[41] = new Tile();
			tile[41].image = ImageIO.read(getClass().getResourceAsStream("/tiles/41.png"));
			

			tile[42] = new Tile();
			tile[42].image = ImageIO.read(getClass().getResourceAsStream("/tiles/42.png"));
			

			tile[43] = new Tile();
			tile[43].image = ImageIO.read(getClass().getResourceAsStream("/tiles/43.png"));
			

			tile[44] = new Tile();
			tile[44].image = ImageIO.read(getClass().getResourceAsStream("/tiles/44.png"));
			

			tile[45] = new Tile();
			tile[45].image = ImageIO.read(getClass().getResourceAsStream("/tiles/45.png"));
			

			tile[46] = new Tile();
			tile[46].image = ImageIO.read(getClass().getResourceAsStream("/tiles/46.png"));
			

			tile[47] = new Tile();
			tile[47].image = ImageIO.read(getClass().getResourceAsStream("/tiles/47.png"));
			

			tile[48] = new Tile();
			tile[48].image = ImageIO.read(getClass().getResourceAsStream("/tiles/48.png"));
			

			tile[49] = new Tile();
			tile[49].image = ImageIO.read(getClass().getResourceAsStream("/tiles/49.png"));
			

			tile[50] = new Tile();
			tile[50].image = ImageIO.read(getClass().getResourceAsStream("/tiles/50.png"));
			tile[50].collision = true;

			tile[51] = new Tile();
			tile[51].image = ImageIO.read(getClass().getResourceAsStream("/tiles/51.png"));
			tile[51].collision = true;

			tile[52] = new Tile();
			tile[52].image = ImageIO.read(getClass().getResourceAsStream("/tiles/52.png"));
			tile[52].collision = true;

			tile[53] = new Tile();
			tile[53].image = ImageIO.read(getClass().getResourceAsStream("/tiles/53.png"));
			tile[53].collision = true;

			tile[54] = new Tile();
			tile[54].image = ImageIO.read(getClass().getResourceAsStream("/tiles/54.png"));
			tile[54].collision = true;

			tile[55] = new Tile();
			tile[55].image = ImageIO.read(getClass().getResourceAsStream("/tiles/55.png"));
			tile[55].collision = true;

			tile[56] = new Tile();
			tile[56].image = ImageIO.read(getClass().getResourceAsStream("/tiles/56.png"));
			tile[56].collision = true;

			tile[57] = new Tile();
			tile[57].image = ImageIO.read(getClass().getResourceAsStream("/tiles/57.png"));
			tile[57].collision = true;

			tile[58] = new Tile();
			tile[58].image = ImageIO.read(getClass().getResourceAsStream("/tiles/58.png"));
			tile[58].collision = true;

			tile[59] = new Tile();
			tile[59].image = ImageIO.read(getClass().getResourceAsStream("/tiles/59.png"));
			tile[59].collision = true;

			tile[60] = new Tile();
			tile[60].image = ImageIO.read(getClass().getResourceAsStream("/tiles/60.png"));
			tile[60].collision = true;

			tile[61] = new Tile();
			tile[61].image = ImageIO.read(getClass().getResourceAsStream("/tiles/61.png"));
			tile[61].collision = true;

			tile[62] = new Tile();
			tile[62].image = ImageIO.read(getClass().getResourceAsStream("/tiles/62.png"));
			tile[62].collision = true;

			tile[63] = new Tile();
			tile[63].image = ImageIO.read(getClass().getResourceAsStream("/tiles/63.png"));
			tile[63].collision = true;

			tile[64] = new Tile();
			tile[64].image = ImageIO.read(getClass().getResourceAsStream("/tiles/64.png"));
			tile[64].collision = true;

			tile[65] = new Tile();
			tile[65].image = ImageIO.read(getClass().getResourceAsStream("/tiles/65.png"));
			tile[65].collision = true;

			tile[66] = new Tile();
			tile[66].image = ImageIO.read(getClass().getResourceAsStream("/tiles/66.png"));
			tile[66].collision = true;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	//method that take each number attached to each tile position from the .txt file and stores this information on a map table array.
	public void loadMap(String filePath) {
		try {
			//loading the file with the file path inputed as an argument.
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			//
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				//reading each line form the document and converting those to an array
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					//assigning the tile number value from a related position to the mapTileNum table with the correspondent index.
					mapTileNum[col][row] = num;
					col++;
				}
				// going to the next row
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
		}
		catch(Exception e) {
			
		}
	}
	//draw method that presents to the user the tile image from a designed tile map table.(mapTileNum)
	public void draw(Graphics2D g2) {
		
		int worldCol = 0;
		int worldRow = 0;
		
		
		//drawing tile by tile until maxScreenCol and maxScreenRow has reached
		while(worldCol <gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			//drawing only what is inside the screen
			
			if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
			   worldX - gp.tileSize< gp.player.worldX + gp.player.screenX &&
			   worldY + gp.tileSize> gp.player.worldY - gp.player.screenY &&
			   worldY - gp.tileSize< gp.player.worldY + gp.player.screenY ) {
				
				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			}
			
			worldCol++;
			
			//next row
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
		}
	}
}

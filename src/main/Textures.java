package main;

import java.awt.image.BufferedImage;

public class Textures {
	private SpriteSheet ss;
	
	public BufferedImage[] playerUp = new BufferedImage[4];
	public BufferedImage[] playerDown = new BufferedImage[4];
	public BufferedImage[] playerLeft = new BufferedImage[4];
	public BufferedImage[] playerRight = new BufferedImage[4];
	
	public BufferedImage[] enemyUp = new BufferedImage[4];
	public BufferedImage[] enemyDown = new BufferedImage[4];
	public BufferedImage[] enemyLeft = new BufferedImage[4];
	public BufferedImage[] enemyRight = new BufferedImage[4];

	public BufferedImage bulletUp;
	public BufferedImage bulletDown;
	public BufferedImage bulletLeft;
	public BufferedImage bulletRight;
	public BufferedImage solidWall;
	public BufferedImage brickWall;
	
	public Textures(Game game){
		ss = new SpriteSheet(game.getSpriteSheet());
		
		getTextures();
	}

	private void getTextures() {
		playerUp[0] = ss.grabImage(2, 1, 26, 26);
		playerUp[1] = ss.grabImage(2, 2, 26, 26);
		playerUp[2] = ss.grabImage(2, 3, 26, 26);
		playerUp[3] = ss.grabImage(2, 4, 26, 26);
		
		playerDown[0] = ss.grabImage(4, 1, 26, 26);
		playerDown[1] = ss.grabImage(4, 2, 26, 26);
		playerDown[2] = ss.grabImage(4, 3, 26, 26);
		playerDown[3] = ss.grabImage(4, 4, 26, 26);
		
		playerLeft[0] = ss.grabImage(1, 1, 26, 26);
		playerLeft[1] = ss.grabImage(1, 2, 26, 26);
		playerLeft[2] = ss.grabImage(1, 3, 26, 26);
		playerLeft[3] = ss.grabImage(1, 4, 26, 26);
		
		playerRight[0] = ss.grabImage(3, 1, 26, 26);
		playerRight[1] = ss.grabImage(3, 2, 26, 26);
		playerRight[2] = ss.grabImage(3, 3, 26, 26);
		playerRight[3] = ss.grabImage(3, 4, 26, 26);
		
		enemyUp[0] = ss.grabImage(2, 5, 28, 28);
		enemyUp[1] = ss.grabImage(2, 6, 28, 28);
		enemyUp[2] = ss.grabImage(2, 7, 28, 28);
		enemyUp[3] = ss.grabImage(2, 8, 28, 28);
		
		enemyDown[0] = ss.grabImage(4, 5, 28, 28);
		enemyDown[1] = ss.grabImage(4, 6, 28, 28);
		enemyDown[2] = ss.grabImage(4, 7, 28, 28);
		enemyDown[3] = ss.grabImage(4, 8, 28, 28);
		
		enemyLeft[0] = ss.grabImage(1, 5, 28, 28);
		enemyLeft[1] = ss.grabImage(1, 6, 28, 28);
		enemyLeft[2] = ss.grabImage(1, 7, 28, 28);
		enemyLeft[3] = ss.grabImage(1, 8, 28, 28);
		
		enemyRight[0] = ss.grabImage(3, 5, 28, 28);
		enemyRight[1] = ss.grabImage(3, 6, 28, 28);
		enemyRight[2] = ss.grabImage(3, 7, 28, 28);
		enemyRight[3] = ss.grabImage(3, 8, 28, 28);

		bulletUp = ss.grabImage(5, 1, 5, 8);
		bulletDown = ss.grabImage(5, 2, 5, 8);
		bulletLeft = ss.grabImage(5, 3, 8, 5);
		bulletRight = ss.grabImage(5, 4, 8, 5);
		
		solidWall = ss.grabImage(5, 6, 32, 16);
		brickWall = ss.grabImage(5, 5, 32, 32);
	}
}

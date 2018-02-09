package main;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.classes.EntityA;
import main.classes.EntityB;
import main.classes.EntityD;
import main.classes.EntityE;
import main.classes.EntityF;
import main.libs.Animation;
//import java.awt.image.BufferedImage;

public class Player extends GameObject implements EntityA{
	private Textures tex;
	private Game game;
	private Controller c;
	private double velX;
	private double velY;
	private int dir = 0;
	private double curX;
	private double curY;
	private long immuneStartTime;
	
	private boolean collisionImmune;
	/*Direction
	 * 0 = up
	 * 1= down
	 * 2 = left
	 * 3 = right
	 */
	
	Animation animUp;
	Animation animDown;
	Animation animLeft;
	Animation animRight;
	
	
	public Player(double x, double y, Textures tex, Controller c, Game game){
		super(x, y);
		this.tex = tex;
		this.c = c;
		this.game = game;

		animUp = new Animation(3, tex.playerUp[0], tex.playerUp[1], tex.playerUp[2], tex.playerUp[3]);
		animDown = new Animation(3, tex.playerDown[0], tex.playerDown[1], tex.playerDown[2], tex.playerDown[3]);
		animLeft = new Animation(3, tex.playerLeft[0], tex.playerLeft[1], tex.playerLeft[2], tex.playerLeft[3]);
		animRight = new Animation(3, tex.playerRight[0], tex.playerRight[1], tex.playerRight[2], tex.playerRight[3]);
	}
	
	public void tick(){
		curX = x;
		curY = y;
		
		x+=velX;
		y+=velY;

		
		if(x <= 50){
			x = 50;
		}
		if(x >= 455-15){
			x = 455-15;
		}
		if(y <= 50){
			y = 50;
		}
		if(y >= 455-15){
			y = 455-15;
		}
		immuneStartTime -= 1;
		if(immuneStartTime <= 0){
			collisionImmune = false;
		}
		
		if(dir == 0){
			animUp.runAnimation();
		}else if(dir == 1){
			animDown.runAnimation();
		}else if(dir == 2){
			animLeft.runAnimation();
		}else if(dir == 3){
			animRight.runAnimation();
		}
		
		//Collision with enemy bullet, player and player life reduced
		for(int i=0; i<game.ef.size(); i++){
			EntityF tempEnt = game.ef.get(i);
			if(Physics.Collision(this, tempEnt) && !collisionImmune){
				//c.removeEntity(tempEnt);
				System.out.println("HIT");
				
				Game.State = Game.STATE.GAMEOVER;
				collisionImmune = true;
				immuneStartTime = 200;
			}
		}
		
		//Collision with brick wall
		for(int i=0; i<game.ed.size(); i++){
			EntityD tempEnt = game.ed.get(i);
			if(Physics.Collision(this, tempEnt)){
				x = curX;
				y = curY;
			}
		}
		
		//Collision with solid wall
		for(int i=0; i<game.ee.size(); i++){
			EntityE tempEnt = game.ee.get(i);
			if(Physics.Collision(this, tempEnt)){
				x = curX;
				y = curY;
			}
		}
		
		//Collision with enemy
		for(int i=0; i<game.eb.size(); i++){
			EntityB tempEnt = game.eb.get(i);
			if(Physics.Collision(this, tempEnt)){
				x = curX;
				y = curY;
			}
		}
		

	}
	
	public void render(Graphics g){
		if(dir == 0){
			animUp.drawAnimation(g, x, y, 0);
		}else if(dir == 1){
			animDown.drawAnimation(g, x, y, 0);
		}else if(dir == 2){
			animLeft.drawAnimation(g, x, y, 0);
		}else if(dir == 3){
			animRight.drawAnimation(g, x, y, 0);
		}
		
		//anim.drawAnimation(g, x, y, 0);
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 26, 26);
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public void setVelX(double velX){
		this.velX = velX;
	}
	
	public void setVelY(double velY){
		this.velY = velY;
	}
	
	public void setDir(int dir){
		this.dir = dir;
	}
	
	public int getDir(){
		return dir;
	}
}

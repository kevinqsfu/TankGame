package main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import main.classes.EntityA;
import main.classes.EntityB;
import main.classes.EntityC;
import main.classes.EntityD;
import main.classes.EntityE;
import main.libs.Animation;

public class Enemy extends GameObject implements EntityB{
	private Textures tex;
	private Game game;
	private Controller c;
	
	Random ranDir = new Random();

	private int dirX;
	private int dirY;
	private double curX;
	private double curY;
	private int dir;
	
	Animation animUp;
	Animation animDown;
	Animation animLeft;
	Animation animRight;
	
	
	
	public Enemy(double x, double y, Textures tex, Controller c, Game game){
		super(x, y);
		this.tex = tex;
		this.c = c;
		this.game = game;
		
		animUp = new Animation(3, tex.enemyUp[0], tex.enemyUp[1], tex.enemyUp[2], tex.enemyUp[3]);
		animDown = new Animation(3, tex.enemyDown[0], tex.enemyDown[1], tex.enemyDown[2], tex.enemyDown[3]);
		animLeft = new Animation(3, tex.enemyLeft[0], tex.enemyLeft[1], tex.enemyLeft[2], tex.enemyLeft[3]);
		animRight = new Animation(3, tex.enemyRight[0], tex.enemyRight[1], tex.enemyRight[2], tex.enemyRight[3]);
	}
	
	public void tick(){
		curX = x;
		curY = y;
		
		x += dirX;
		y += dirY;
		
		if(ranDir.nextInt(30) == 5){
			dir = ranDir.nextInt(4);
			if(dir == 0){
				System.out.println("ZERO");
				dirY = -1;
				dirX = 0;
			}else if(dir == 1){
				System.out.println("ONE");
				dirY = 1;
				dirX = 0;
			}else if(dir == 2){
				System.out.println("TWO");
				dirX = -1;
				dirY = 0;
			}else if(dir == 3){
				System.out.println("THREE");
				dirX = 1;
				dirY = 0;
			}
		}
		
		if(ranDir.nextInt(80) == 5){
			c.addEntity(new EnemyBullet(curX + 10, curY + 10, tex, game, dir, c));
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

		
		if(x <= 50){
			x = 50;
		}
		if(x >= 455-21){
			x = 455-21;
		}
		if(y <= 50){
			y = 50;
		}
		if(y >= 455-21){
			y = 455-21;
		}
		
		//Collision with bullet, bullet and tank is removed
		for(int i=0; i<game.ec.size(); i++){
			EntityC tempEnt = game.ec.get(i);
			if(Physics.Collision(this, tempEnt)){
				c.removeEntity(tempEnt);
				c.removeEntity(this);
				game.setEnemyKilled(game.getEnemyKilled() +1); //keep track of how many enemy is killed
				game.setEnemyCount(game.getEnemyCount() -1); //subtract enemy count
				game.setScore(game.getScore() +50); //add score
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
		
		//Collision with player
		for(int i=0; i<game.ea.size(); i++){
			EntityA tempEnt = game.ea.get(i);
			if(Physics.Collision(this, tempEnt)){
				x = curX;
				y = curY;
			}
		}
		
	}
	
	public void render(Graphics g){
		//g.drawImage(tex.enemyDown[0], (int)x, (int)y, null);
		//System.out.print("DIR:" + dir);
		if(dir == 0){
			animUp.drawAnimation(g, x, y, 0);
		}else if(dir == 1){
			animDown.drawAnimation(g, x, y, 0);
		}else if(dir == 2){
			animLeft.drawAnimation(g, x, y, 0);
		}else if(dir == 3){
			animRight.drawAnimation(g, x, y, 0);
		}
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 28, 28);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}

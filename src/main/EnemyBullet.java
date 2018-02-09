package main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.classes.EntityA;
import main.classes.EntityF;

public class EnemyBullet extends GameObject implements EntityF{
	BufferedImage image;
	public int dir = 0;
	private Textures tex;
	private Game game;
	private Controller c;
	
	public EnemyBullet(double x, double y, Textures tex, Game game, int dir, Controller c){
		super(x, y);
		this.tex = tex;
		this.dir = dir;
		this.game = game;
		this.c = c;
	}
	
	public void tick(){
		if(dir == 0){
			y -= 2;
		}else if(dir == 1){
			y += 2;
		}else if(dir == 2){
			x -= 2;
		}else if(dir == 3){
			x += 2;
		}
		
		//Collision with enemy bullet, player and player life reduced
		for(int i=0; i<game.ea.size(); i++){
			EntityA tempEnt = game.ea.get(i);
			if(Physics.Collision(this, tempEnt)){
				c.removeEntity(this);
			}
		}
	}
	
	public void render(Graphics g){

		if(dir == 0){
			g.drawImage(tex.bulletUp, (int)x, (int)y, null);
		}else if(dir == 1){
			g.drawImage(tex.bulletDown, (int)x, (int)y, null);
		}else if(dir == 2){
			g.drawImage(tex.bulletLeft, (int)x, (int)y, null);
		}else if(dir == 3){
			g.drawImage(tex.bulletRight, (int)x, (int)y, null);
		}

	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 8, 8);
	}
	
	public double getY(){
		return y;
	}

	public double getX() {
		return x;
	}
	
	public void setDir(int dir){
		this.dir = dir;
	}
}

package main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.classes.EntityC;
import main.classes.EntityD;
import main.classes.EntityF;

public class BrickWall extends GameObject implements EntityD{
	BufferedImage image;
	public int dir = 0;
	private Textures tex;
	private Game game;
	private Controller c;
	
	public BrickWall(double x, double y, Textures tex, Controller c, Game game){
			super(x, y);
			this.tex = tex;
			this.c = c;
			this.game = game;
	}
	
	public void tick(){
		for(int i=0; i<game.ec.size(); i++){
			EntityC tempEnt = game.ec.get(i);
			if(Physics.Collision(this, tempEnt)){
				c.removeEntity(this);
				c.removeEntity(tempEnt);
			}
		}
		
		for(int i=0; i<game.ef.size(); i++){
			EntityF tempEnt = game.ef.get(i);
			if(Physics.Collision(this, tempEnt)){
				c.removeEntity(this);
				c.removeEntity(tempEnt);
			}
		}
	}
	
	public void render(Graphics g){
		g.drawImage(tex.brickWall, (int)x, (int)y, null);

	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
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
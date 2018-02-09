package main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.classes.EntityC;
import main.classes.EntityE;
import main.classes.EntityF;

public class SolidWall extends GameObject implements EntityE{
	BufferedImage image;
	public int dir = 0;
	private Textures tex;
	private Game game;
	private Controller c;
	
	public SolidWall(double x, double y, Textures tex, Controller c, Game game){
			super(x, y);
			this.tex = tex;
			this.c = c;
			this.game = game;
	}
	
	public void tick(){
		for(int i=0; i<game.ec.size(); i++){
			EntityC tempEnt = game.ec.get(i);
			if(Physics.Collision(this, tempEnt)){
				c.removeEntity(tempEnt);
			}
		}
		
		for(int i=0; i<game.ef.size(); i++){
			EntityF tempEnt = game.ef.get(i);
			if(Physics.Collision(this, tempEnt)){
				c.removeEntity(tempEnt);
			}
		}
	}
	
	public void render(Graphics g){
		g.drawImage(tex.solidWall, (int)x, (int)y, null);

	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 16);
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
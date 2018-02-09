package main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.classes.EntityC;

public class Bullet extends GameObject implements EntityC{
	BufferedImage image;
	public int dir = 0;
	private Textures tex;
	//private Game game;
	
	public Bullet(double x, double y, Textures tex, Game game, int dir){
		super(x, y);
		this.tex = tex;
		this.dir = dir;

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

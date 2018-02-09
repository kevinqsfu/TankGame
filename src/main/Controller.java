package main;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import main.classes.EntityA;
import main.classes.EntityB;
import main.classes.EntityC;
import main.classes.EntityD;
import main.classes.EntityE;
import main.classes.EntityF;

public class Controller {
	private LinkedList<EntityA> ea = new LinkedList<EntityA>();
	private LinkedList<EntityB> eb = new LinkedList<EntityB>();
	private LinkedList<EntityC> ec = new LinkedList<EntityC>();
	private LinkedList<EntityD> ed = new LinkedList<EntityD>();
	private LinkedList<EntityE> ee = new LinkedList<EntityE>();
	private LinkedList<EntityF> ef = new LinkedList<EntityF>();
	
	Random r = new Random();
	
	EntityA enta;
	EntityB entb;
	EntityC entc;
	EntityD entd;
	EntityE ente;
	EntityF entf;
	
	Textures tex;

	public Controller(Game game, Textures tex){
		addEntity(new Enemy(50, 50, tex, this, game));
		addEntity(new Enemy(450, 50, tex, this, game));
		
		//Stage 1
		addEntity(new SolidWall(50, 255, tex, this, game));
		addEntity(new SolidWall(434, 255, tex, this, game));
		for(int j=0; j<2; j++){
			for(int i=0; i<2; i++){
				addEntity(new SolidWall(242, 146+(16*i)+(224*j), tex, this, game));
			}
		}
		
		for(int k=0; k<2; k++){
			for(int j=0; j<6; j++){
				for(int i=0; i<4; i++){
					addEntity(new BrickWall(82+(64*j), 82+(32*i)+(224*k), tex, this, game));
				}
			}
		}
		
		for(int j=0; j<2; j++){
			for(int i=0; i<2; i++){
				addEntity(new BrickWall(114+(32*i)+(224*j), 242, tex, this, game));
			}
		}
		
		for(int i=0; i<3; i++){
			addEntity(new BrickWall(210+(32*i), 242, tex, this, game));
		}
	}
	
	public void tick(){
		//A Class
		for(int i=0; i< ea.size(); i++){
			enta = ea.get(i);
			enta.tick();
		}
		
		//B Class
		for(int i=0; i< eb.size(); i++){
			entb = eb.get(i);
			entb.tick();
		}
		
		//C Class
		for(int i=0; i< ec.size(); i++){
			entc = ec.get(i);
			entc.tick();
		}
				
		//D Class
		for(int i=0; i< ed.size(); i++){
			entd = ed.get(i);
			entd.tick();
		}
		
		//E Class
		for(int i=0; i< ee.size(); i++){
			ente = ee.get(i);
			ente.tick();
		}
		
		//F Class
		for(int i=0; i< ef.size(); i++){
			entf = ef.get(i);
			entf.tick();
		}
	}
	
	public void render(Graphics g){
		//A Class
		for(int i=0; i< ea.size(); i++){
			enta = ea.get(i);
			enta.render(g);
		}
		
		//B Class
		for(int i=0; i< eb.size(); i++){
			entb = eb.get(i);
			entb.render(g);
		}
		
		//C Class
		for(int i=0; i< ec.size(); i++){
			entc = ec.get(i);
			entc.render(g);
		}
				
		//D Class
		for(int i=0; i< ed.size(); i++){
			entd = ed.get(i);
			entd.render(g);
		}
		
		//E Class
		for(int i=0; i< ee.size(); i++){
			ente = ee.get(i);
			ente.render(g);
		}
		
		//F Class
		for(int i=0; i< ef.size(); i++){
			entf = ef.get(i);
			entf.render(g);
		}
	}
	
	
	//A Class
	public void addEntity(EntityA block){
		ea.add(block);
	}
	
	public void removeEntity(EntityA block){
		ea.remove(block);
	}
	
	//B Class
	public void addEntity(EntityB block){
		eb.add(block);
	}
	
	public void removeEntity(EntityB block){
		eb.remove(block);
	}
	
	//C Class
	public void addEntity(EntityC block){
		ec.add(block);
	}
	
	public void removeEntity(EntityC block){
		ec.remove(block);
	}
	
	//D Class
	public void addEntity(EntityD block){
		ed.add(block);
	}
	
	public void removeEntity(EntityD block){
		ed.remove(block);
	}
	
	//E Class
	public void addEntity(EntityE block){
		ee.add(block);
	}
	
	public void removeEntity(EntityE block){
		ee.remove(block);
	}
	
	//F Class
	public void addEntity(EntityF block){
		ef.add(block);
	}
	
	public void removeEntity(EntityF block){
		ef.remove(block);
	}
	
	
	
	public LinkedList<EntityA> getEntityA(){
		return ea;
	}
	
	public LinkedList<EntityB> getEntityB(){
		return eb;
	}
	
	public LinkedList<EntityC> getEntityC(){
		return ec;
	}
	
	public LinkedList<EntityD> getEntityD(){
		return ed;
	}
	
	public LinkedList<EntityE> getEntityE(){
		return ee;
	}
	
	public LinkedList<EntityF> getEntityF(){
		return ef;
	}
}

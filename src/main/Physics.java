package main;

import main.classes.EntityA;
import main.classes.EntityB;
import main.classes.EntityC;
import main.classes.EntityD;
import main.classes.EntityE;
import main.classes.EntityF;

public class Physics {
	public static boolean Collision(EntityA enta, EntityB entb){
		if(enta.getBounds().intersects(entb.getBounds())){
			return true;
		}
		return false;
	}
	
	public static boolean Collision(EntityB entb, EntityA enta){
		if(entb.getBounds().intersects(enta.getBounds())){
			return true;
		}
		return false;
	}
	
	public static boolean Collision(EntityB entb, EntityC entc){
		if(entb.getBounds().intersects(entc.getBounds())){
			return true;
		}
		return false;
	}
	
	public static boolean Collision(EntityD entd, EntityC entc){
		if(entd.getBounds().intersects(entc.getBounds())){
			return true;
		}
		return false;
	}
	
	public static boolean Collision(EntityE ente, EntityC entc){
		if(ente.getBounds().intersects(entc.getBounds())){
			return true;
		}
		return false;
	}
	
	public static boolean Collision(EntityA enta, EntityD entd){
		if(enta.getBounds().intersects(entd.getBounds())){
			return true;
		}
		return false;
	}
	
	public static boolean Collision(EntityA enta, EntityE ente){
		if(enta.getBounds().intersects(ente.getBounds())){
			return true;
		}
		return false;
	}
	
	public static boolean Collision(EntityB entb, EntityD entd){
		if(entb.getBounds().intersects(entd.getBounds())){
			return true;
		}
		return false;
	}
	
	public static boolean Collision(EntityB entb, EntityE ente){
		if(entb.getBounds().intersects(ente.getBounds())){
			return true;
		}
		return false;
	}
	
	public static boolean Collision(EntityB entb, EntityB entb2){
		if(entb.getBounds().intersects(entb2.getBounds())){
			return true;
		}
		return false;
	}
	
	public static boolean Collision(EntityD entd, EntityF entf){
		if(entd.getBounds().intersects(entf.getBounds())){
			return true;
		}
		return false;
	}
	
	public static boolean Collision(EntityE ente, EntityF entf){
		if(ente.getBounds().intersects(entf.getBounds())){
			return true;
		}
		return false;
	}
	
	public static boolean Collision(EntityA enta, EntityF entf){
		if(enta.getBounds().intersects(entf.getBounds())){
			return true;
		}
		return false;
	}
	
	public static boolean Collision(EntityF entf, EntityA enta){
		if(entf.getBounds().intersects(enta.getBounds())){
			return true;
		}
		return false;
	}
}

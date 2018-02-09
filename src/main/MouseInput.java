package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
		System.out.print("MOUSE HOVERED");
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		System.out.print(mx + "\n");
		System.out.print(my + "\n");
		
		if(Game.State == Game.STATE.MENU){
			//Press Play Button
			if(mx >= 180 && mx <= 340){
				if(my >= 250 && my <= 265 ){
					Game.State = Game.STATE.GAME;
				}
			}

			
			//Press Control Button
			if(mx >= 180 && mx <= 310){
				if(my >= 275 && my <= 290 ){
					Game.State = Game.STATE.CONTROLS;
				}
			}
			
			//Press Quit Button
			if(mx >= 180 && mx <= 245){
				if(my >= 300 && my <= 315 ){
					System.exit(0);
				}
			}
		}else if(Game.State == Game.STATE.CONTROLS){
			//Press Back Button
			if(mx >= 180 && mx <= 245){
				if(my >= 300 && my <= 315 ){
					Game.State = Game.STATE.MENU;
				}
			}
		}else if(Game.State == Game.STATE.GAMEOVER){
			if(mx >= 180 && mx <= 340){
				if(my >= 250 && my <= 265 ){
					Game.State = Game.STATE.GAME;
				}
			}
			
			//Press Quit Button
			if(mx >= 180 && mx <= 245){
				if(my >= 300 && my <= 315 ){
					System.exit(0);
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
	}
	
}

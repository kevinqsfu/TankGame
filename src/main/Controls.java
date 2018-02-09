package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Controls {
	public Rectangle backButton = new Rectangle(Game.WIDTH/2-75, 300, 60, 15);
	
	
	public void render(Graphics g){
		//Graphics2D g2d = (Graphics2D) g;

		Font fnt0 = new Font("Pokemon GB", Font.BOLD, 15);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Move Up - Up arrow key", 50, 100);
		g.drawString("Move Down - Down arrow key", 50, 120);
		g.drawString("Move Left - Left arrow key", 50, 140);
		g.drawString("Move Right - Right arrow key", 50, 160);
		g.drawString("Shoot - Spacebar", 50, 180);
		
		Font fnt1 = new Font("Pokemon GB", Font.BOLD, 15);
		g.setFont(fnt1);
		g.drawString("BACK", backButton.x , backButton.y +15);
		//g2d.draw(quitButton);*/
		
	}
}

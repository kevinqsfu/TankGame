package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GameOver {
	public Rectangle playButton = new Rectangle(Game.WIDTH/2-75, 250, 160, 15);
	public Rectangle controlbutton = new Rectangle(Game.WIDTH/2-75, 275, 120, 15);
	public Rectangle quitButton = new Rectangle(Game.WIDTH/2-75, 300, 60, 15);
	private Game game;
	private Player p;
	
	public GameOver(Game game){
		this.game = game;
	}
	
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt0 = new Font("Pokemon GB", Font.BOLD, 30);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("GAME OVER", 140, 100);
		
		Font fnt1 = new Font("Pokemon GB", Font.BOLD, 15);
		g.setFont(fnt1);
		g.drawString("PLAY AGAIN", playButton.x, playButton.y +15);
		//g2d.draw(playButton);
		g.drawString("QUIT", quitButton.x , quitButton.y +15);
		
		g.drawString("SCORE" , 250 , 175);
		g.drawString(Integer.toString(game.getScore()) , 250 , 200);
		
		
		//g2d.draw(quitButton);
	}
}

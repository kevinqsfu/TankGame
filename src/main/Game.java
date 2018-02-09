package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JFrame;

import main.classes.EntityA;
import main.classes.EntityB;
import main.classes.EntityC;
import main.classes.EntityD;
import main.classes.EntityE;
import main.classes.EntityF;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 50+405+100;
	public static final int HEIGHT = 50+50+405;
	public static final int SCALE = 1;
	public final String TITLE = "Battle Tanks";
	
	public static int Health = 3; //Amount of life
	
	private boolean running = false;
	private Thread thread;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet = null;
	
	private boolean is_shooting = false;
	
	private int enemyCount = 2;
	private int enemyKilled = 0;
	private int dir = 0;
	
	private int score = 0;
	
	Random r = new Random();
	
	public int go = 0;

	private Player p;
	private Enemy e;
	private Bullet b;
	private Controller c;
	private Textures tex;
	private Menu menu;
	private Controls controls;
	private GameOver gameOver;
	
	public LinkedList<EntityA> ea;
	public LinkedList<EntityB> eb;
	public LinkedList<EntityC> ec;
	public LinkedList<EntityD> ed;
	public LinkedList<EntityE> ee;
	public LinkedList<EntityF> ef;
	
	//Menu
	public static enum STATE{
		MENU,
		CONTROLS,
		GAME,
		GAMEOVER
	};
	
	public static STATE State = STATE.MENU;
	//Menu
	
	public void init(){
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			spriteSheet = loader.loadImage("/SpriteSheet.png");
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		
		tex = new Textures(this);
		p = new Player(50, 434, tex, c, this);
		c = new Controller(this, tex);
		
		menu = new Menu();
		controls = new Controls();
		gameOver = new GameOver(this);
		
		ea = c.getEntityA();
		eb = c.getEntityB();
		ec = c.getEntityC();
		ed = c.getEntityD();
		ee = c.getEntityE();
		ef = c.getEntityF();
		
		this.addKeyListener(new KeyInput(this));
		this.addMouseListener(new MouseInput());
	}
	
	private synchronized void start(){
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop(){
		if(!running){
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	public void run(){
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000/ amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(updates + "Ticks, FPS" + frames);
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick(){
		if(State == STATE.GAME){
		//e.tick();
		p.tick();
		c.tick();
		}
		//add more enemy after the initial ones are killed
		if(enemyCount == 1){
			enemyCount += 1;
			c.addEntity(new Enemy(r.nextInt(400)+50, 50, tex, c, this));
		}
		
	}
	
	private void render(){
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		
		if(State == STATE.GAME){
			p.render(g);
			//e.render(g);
			c.render(g);
			
			g.setColor(Color.gray);
			g.fillRect(0, 0, 500, 50);
			g.fillRect(0, 0, 50, 500);
			g.fillRect(0, 466, 565, 50);
			g.fillRect(466, 0, 100, 466);
			
			Font fnt0 = new Font("Pokemon GB", Font.BOLD, 10);
			g.setFont(fnt0);
			g.setColor(Color.white);
			g.drawString("SCORE", 480, 75);
			
			g.drawString(Integer.toString(score), 480, 90);
		}else if(State == STATE.MENU){
			menu.render(g);
		}else if(State == STATE.CONTROLS){
			controls.render(g);
		}else if(State == STATE.GAMEOVER){
			gameOver.render(g);
		}

		g.dispose();
		bs.show();
		
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(State == STATE.GAME){
			if(key == KeyEvent.VK_RIGHT){
				p.setDir(3);
				dir = 3;
				p.setVelX(2);
				p.setVelY(0);		
			}else if(key == KeyEvent.VK_LEFT){
				p.setDir(2);
				dir = 2;
				p.setVelX(-2);
				p.setVelY(0);
			}else if(key == KeyEvent.VK_DOWN){
				p.setDir(1);
				dir = 1;
				p.setVelY(2);
				p.setVelX(0);
			}else if(key == KeyEvent.VK_UP){
				p.setDir(0);
				dir = 0;
				p.setVelY(-2);
				p.setVelX(0);
			}else if(key == KeyEvent.VK_SPACE && !is_shooting){
				is_shooting = true;
				c.addEntity(new Bullet(p.getX() + 10, p.getY() + 10, tex, this, dir));
			}
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT){
			p.setVelX(0);
		}else if(key == KeyEvent.VK_LEFT){
			p.setVelX(0);
		}else if(key == KeyEvent.VK_DOWN){
			p.setVelY(0);
		}else if(key == KeyEvent.VK_UP){
			p.setVelY(0);
		}else if(key == KeyEvent.VK_SPACE){
			is_shooting = false;
		}
	}
			
	public static void main(String args[]){
		Game game = new Game();
		
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		game.start();
	}
	
	public BufferedImage getSpriteSheet(){
		return spriteSheet;
	}

	public int getEnemyCount() {
		return enemyCount;
	}

	public void setEnemyCount(int enemyCount) {
		this.enemyCount = enemyCount;
	}

	public int getEnemyKilled() {
		return enemyKilled;
	}

	public void setEnemyKilled(int enemyKilled) {
		this.enemyKilled = enemyKilled;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void setGo(int go) {
		this.go = go;
	}
}

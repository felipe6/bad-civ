package mainBoi;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;

import Rendering.textures.SpriteSheet;
import Rendering.textures.Texture;
import input.KeyInput;
import input.MouseInput;
import mapStuff.*;
import playerInfo.Player;
import playerInfo.UIHandler;

public class Game extends Canvas implements Runnable{
    
    private static final long serialVersionUID = 2L;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 10;
    public static final String title = "Bad civ";

    private Thread thread;
    public boolean running = false;
    private BaseMap map;
    private Player player;

    private Menu menu;
    public int state;
    
    public static Handler handler;
    public NetworkStuff connect;
    
    public static Game instance;
    public static Window window;

    public Game(){
        handler = new Handler();
        map = new BoringMap(16);
        handler.setMap(map);
        
        player = new Player();
        handler.UI = new UIHandler (player);
        Soldier mans = new Soldier(2, 2, ID.Soldier);
        handler.addObject(mans);
        menu = new Menu();
        state = 0;
        window = new Window(WIDTH, HEIGHT, "Bad Civ", this);
        addKeyListener(new KeyInput());
        MouseInput mi = new MouseInput();
        addMouseListener(mi);
        addMouseMotionListener(mi);
    }

    public static void main(String[] args) {
        instance = new Game();
    }

    public synchronized void start(){
        System.out.println("Running start");
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        System.out.println("Running stop");
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        System.out.println(running);
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        boolean canRender = false;

        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1){
                tick();
                KeyInput.update();
                MouseInput.update();
                delta--;
                canRender = true;
            }else canRender = false;
            
            if(canRender){
                render();
                frames++;
            }

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        System.out.println("closing...");
        stop();
    }

    private void tick(){
    	
        /////////////////////// States to tick
        switch (state) {
        case 0:
        	menu.tick();
        	break;
        case 1:
        	handler.tick();
            break;
        case 2:
        	if (connect == null) {
        		connect = new NetworkStuff();
        	}

        	connect.tick();
        	handler.tick();
        	break;
        }
        ///////////////////////
    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        /////////////////////// States to render
        switch (state) {
        case 0:
        	menu.render(g);
        	break;
        case 1:
        case 2:
        	g.setColor(Color.GRAY);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            handler.render(g);
            break;
        }
        ///////////////////////
        
        g.dispose();
        bs.show();
    }
    
    public void setState(int newState) {
    	this.state = newState;
    }
}
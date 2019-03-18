package mainBoi;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;

import Rendering.textures.SpriteSheet;
import Rendering.textures.Texture;
import mapStuff.*;

public class Game extends Canvas implements Runnable{
    
    private static final long serialVersionUID = 2L;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 10;

    private Thread thread;
    private boolean running = false;
    private BaseMap map;

    private Handler handler;

    public Game(){
    	System.out.println("yolo");
        handler = new Handler();
        //handler.addObject(new Tile(100, 100, ID.LandTile));
        map = new BoringMap(8);
        handler.setMap(map);
        new Window(WIDTH, HEIGHT, "Bad Civ", this);
    }

    public static void main(String[] args) {
        new Game();
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
                delta--;
                canRender = true;
            }else canRender = false;
            
            if(canRender){
                render();
                frames++;
            }

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        System.out.println("closing...");
        stop();
    }

    private void tick(){
        handler.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.green);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        handler.render(g);

        g.dispose();
        bs.show();
    }
}
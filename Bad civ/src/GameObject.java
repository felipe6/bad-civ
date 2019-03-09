import java.awt.Graphics;
public abstract class GameObject{
    
    public int x, y;
    public ID id;
    
    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public void setX(int x){
        if(x > Game.WIDTH || x < 0){
            System.out.println("Out of Bounds");
        }else{
            this.x = x;
        }
    }
    public void setY(int y){
        if(y > Game.HEIGHT || y < 0){
            System.out.println("Out of Bounds");
        }else{
            this.y = y;
        }
    }
}
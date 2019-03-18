package mainBoi;
import java.util.LinkedList;

import mapStuff.BaseMap;

import java.awt.Graphics;

public class Handler{
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    BaseMap map;

    public void tick(){
        for(int i = 0; i < object.size(); i++){
            GameObject temp = object.get(i);

            temp.tick();
        }
    }
    
    public void render(Graphics g){
    	map.render(g);
        for(int i = 0; i < object.size(); i++){
            GameObject temp = object.get(i);

            temp.render(g);
        }
    }
    
    public void setMap(BaseMap map) {
    	this.map = map;
    }

    public void addObject(GameObject object){
        this.object.add(object);
    }
    public void removeObject(GameObject object){
        this.object.remove(object);
    }

}
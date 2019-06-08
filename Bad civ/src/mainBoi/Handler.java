package mainBoi;
import java.util.LinkedList;

import mapStuff.BaseMap;
import mapStuff.MapControlHandler;
import playerInfo.UIHandler;

import java.awt.Graphics;
import java.io.Serializable;

public class Handler implements Serializable{
    public LinkedList<GameObject> object = new LinkedList<GameObject>();
    public BaseMap map;
    public UIHandler UI;
    

    public void tick(){
    	MapControlHandler.tick();
        for(int i = 0; i < object.size(); i++){
            GameObject temp = object.get(i);
            temp.tick();
        }
    }
    
    public void render(Graphics g){
    		
    	map.render(g);
    	UI.render(g);
   		
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
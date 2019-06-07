package mainBoi;
import java.util.LinkedList;

import mapStuff.BaseMap;
import mapStuff.MapControlHandler;
import playerInfo.Player;

import java.awt.Graphics;
import java.io.Serializable;

public class Handler implements Serializable{
    public LinkedList<GameObject> object = new LinkedList<GameObject>();
    public BaseMap map;
    public Player player;
    

    public Handler(BaseMap map, Player player) {
    	this.map = map;
    	this.player = player;
    }
    
    public void tick(){
    	MapControlHandler.tick();
        for(int i = 0; i < object.size(); i++){
            GameObject temp = object.get(i);
            temp.tick();
        }
    }
    
    public void render(Graphics g){
    	if ((Game.instance.state == 2 && Game.instance.connect != null && Game.instance.connect.accepted) || Game.instance.state == 1) {
    		map.render(g);
            for(int i = 0; i < object.size(); i++){
                GameObject temp = object.get(i);

                temp.render(g);
            }
    	}else {
    		//Give message that you are waiting for new player to join server
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
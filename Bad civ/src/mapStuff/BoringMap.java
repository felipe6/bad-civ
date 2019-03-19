package mapStuff;

import mainBoi.ID;

public class BoringMap extends BaseMap{

	
	
	public BoringMap(int gridSize) {
		super(gridSize);
		mapGenerator();
	}

	@Override
	public void mapGenerator() {
		for (int i = 0; i < gridSize; i++) {
    		for (int j = 0; j < gridSize; j++) {
    			if((j == 1 && i == 2) || (i == gridSize / 2) || (j == 1 && i == 3) || (j == 2 && i == 0) || (j == 1 && i == 1)){
        	    	insertTile(ID.WaterTile, j, i);
    			} else if((j <= 4 && j >= 2 && i >= 6)) {
    				insertTile(ID.ForestTile, j , i);
    			} else {
        	    	insertTile(ID.LandTile, j, i);
    			}
        	}
    	}
	}
}

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
    	    	insertTile(ID.LandTile, i, j);
        	}
    	}
	}

}

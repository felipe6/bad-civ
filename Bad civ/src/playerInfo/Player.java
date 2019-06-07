package playerInfo;

public class Player {
	
	public String name;
	
	public int gold;
	public int ore;
	public int food;
	public int population;
	public int normies;
	public int soldiers;
	
	public Player(int gold, int ore, int food, int population) {
		this.gold = gold;
		this.ore = ore;
		this.food = food;
		this.population = population;
		this.normies = population;
		this.soldiers = 0;
	}
	
	public Player() {
		this(0, 0, 0, 0);
	}
	
	public void calcGrowth() {
		int growth = 0;
		if (food > foodConsumption()) {
			growth++;
		}else if (food == foodConsumption()) {
			growth = 0;
		}else {
			growth = -1;
		}
		population = population + growth;
		food -= foodConsumption();
	}
	
	public int foodConsumption() {
		int foodConsumed = 0;
		foodConsumed += normies * 10;
		foodConsumed += soldiers * 20;
		return foodConsumed;
	}
	
}
package week02.slot02.assets;

public class Map {

	// Pirate[width or x][height or y] 
	private Pirate[][] arena;
	
	public Map(int width, int height) {
		if(width < 1) {
			width = 5;
		}
		if(height < 1) {
			height = 5;
		}
		arena = new Pirate[width][height];
	}
	
	public int getHeight() {
		return arena[0].length;
	}
	
	public int getWidth() {
		return arena.length;
	}
	
	public Pirate selectPirate(int x, int y) {
		if(checkCoordinate(x, y)) {
			return arena[x][y];
		}
		return null;
	}
	
	public void addPirate(int x, int y, Pirate newPirate) {
		if(checkCoordinate(x, y)) {
			arena[x][y] = newPirate;
		}
	}
	
	public boolean checkCoordinate(int x, int y) {
		if(x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
			return false;
		} else {
			return true;
		}
	}
	
}

package week03.slot01.assets;

public class Map {

	public final static String DIRECTION_UP = "up";
	public final static String DIRECTION_DOWN = "down";
	public final static String DIRECTION_LEFT = "left";
	public final static String DIRECTION_RIGHT = "right";
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
	
	public void movePirate(int currentX, int currentY, int newX, int newY) {
		Pirate pirate = selectPirate(currentX, currentY);
		Pirate newLocation = selectPirate(newX, newY);
		if(pirate != null) {
			if(newLocation != null) {				
				pirate.attackOtherPirate(newLocation);
			} else {
				if(checkCoordinate(newX, newY)) {					
					arena[newX][newY] = pirate;
					arena[currentX][currentY] = null;
				}
			}
		}
	}
	
	public void movePirate(int currentX, int currentY, String direction) {
		int newX = -1, newY = -1;
		if(direction.equalsIgnoreCase(DIRECTION_UP)) {
			newX = currentX;
			newY = currentY - 1;
		} else if(direction.equalsIgnoreCase(DIRECTION_DOWN)) {
			newX = currentX;
			newY = currentY + 1;
		} else if(direction.equalsIgnoreCase(DIRECTION_LEFT)) {
			newX = currentX - 1;
			newY = currentY;
		} else if(direction.equalsIgnoreCase(DIRECTION_RIGHT)) {
			newX = currentX + 1;
			newY = currentY;
		}
		movePirate(currentX, currentY, newX, newY);
	}
	
	public void movePirateUp(int currentX, int currentY) {
		movePirate(currentX, currentY, DIRECTION_UP);
	}
	
	public void movePirateDown(int currentX, int currentY) {
		movePirate(currentX, currentY, DIRECTION_DOWN);
	}
	
	public void movePirateLeft(int currentX, int currentY) {
		movePirate(currentX, currentY, DIRECTION_LEFT);
	}
	
	public void movePirateRight(int currentX, int currentY) {
		movePirate(currentX, currentY, DIRECTION_RIGHT);
	}
	
}

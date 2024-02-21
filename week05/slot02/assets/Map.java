package week05.slot02.assets;

import week05.slot02.assets.interfaces.Consumable;
import week05.slot02.assets.interfaces.Placeable;
import week05.slot02.assets.weapons.Weapon;

public class Map {

	public final static String DIRECTION_UP = "up";
	public final static String DIRECTION_DOWN = "down";
	public final static String DIRECTION_LEFT = "left";
	public final static String DIRECTION_RIGHT = "right";
	// Pirate[width or x][height or y] 
	private Placeable[][] arena;
	
	public Map(int width, int height) {
		if(width < 1) {
			width = 5;
		}
		if(height < 1) {
			height = 5;
		}
		arena = new Placeable[width][height];
	}
	
	public int getHeight() {
		return arena[0].length;
	}
	
	public int getWidth() {
		return arena.length;
	}
	
	public Placeable selectAssets(int x, int y) {
		if(checkCoordinate(x, y)) {
			return arena[x][y];
		}
		return null;
	}
	
	public void addAssets(int x, int y, Placeable assets) {
		if(checkCoordinate(x, y)) {
			arena[x][y] = assets;
		}
	}
	
	public Pirate selectPirate(int x, int y) {
		if(checkCoordinate(x, y) && arena[x][y] instanceof Pirate) {
			return (Pirate) arena[x][y];
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
		Placeable newLocation = selectAssets(newX, newY);
		if(pirate != null) {
			if(newLocation != null) {
				if(newLocation instanceof Pirate) {					
					moveToPirate(pirate, (Pirate) newLocation,
							currentX, currentY, newX, newY);
				} else if(newLocation instanceof Weapon) {
					pirate.equipWeapon((Weapon) newLocation);
					occupyNewLocation(pirate, currentX, currentY, newX, newY);
				} else if(newLocation instanceof Consumable) {
//					Consumable consumable = (Consumable) newLocation;
//					int newHealth = consumable.doHealing(pirate);
					int newHealth = ((Consumable) newLocation).doHealing(pirate);
					if(newHealth > 0) {						
						pirate.setHealth(newHealth);
					}
					occupyNewLocation(pirate, currentX, currentY, newX, newY);
				}
			} else {
				if(checkCoordinate(newX, newY)) {					
					arena[newX][newY] = pirate;
					arena[currentX][currentY] = null;
				}
			}
		}
	}
	
	public void moveToPirate(
			Pirate pirate, Pirate newLocation,
			int currentX, int currentY,
			int newX, int newY
			) {
		pirate.attackOtherPirate(newLocation);
		if(newLocation.getHealth() <= 0) {
			occupyNewLocation(pirate, currentX, currentY, newX, newY);
		}
		if(pirate.getWeapon() instanceof Consumable) {
			int newHealth = ((Consumable) newLocation).doHealing(pirate);
			pirate.setHealth(newHealth);
			pirate.unEquipWeapon();
		}
	}
	
	public void occupyNewLocation(
			Pirate pirate, int currentX, int currentY,
			int newX, int newY
			) {
		if(checkCoordinate(newX, newY)) {					
			arena[newX][newY] = pirate;
			arena[currentX][currentY] = null;
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

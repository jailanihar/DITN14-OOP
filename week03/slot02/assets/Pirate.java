package week03.slot02.assets;

public class Pirate {

	private final static String DEFAULT_NAME_PREFIX = "Pirate";
	private final static int DEFAULT_HEALTH = 5;
	private static int totalDefaultPirates = 1;
	private String name;
	private int health;
	private int defence;
	
	public Pirate() {
		this("", DEFAULT_HEALTH);
	}
	
	public Pirate(String pName, int pHealth) {
		if(pName == null || pName.equals("")) {
			pName = DEFAULT_NAME_PREFIX + totalDefaultPirates;
			totalDefaultPirates++;
		}
		name = pName;
		if(pHealth < 1) {
			pHealth = DEFAULT_HEALTH;
		}
		health = pHealth;
	}
	
	public Pirate(String name, int health, int defence) {
		this(name, health);
		if(defence < 0) {
			defence = 0;
		}
		this.defence = defence;
	}
	
	public String toString() {
		return "[" + name + ", " + health + "h, " + defence + "d]";
	}	
	
	public void attackOtherPirate(Pirate otherPirate) {
		if(otherPirate.defence < 1) {			
			otherPirate.health--;
		}
	}

}

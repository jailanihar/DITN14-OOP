package week02.slot02.assets;

public class Pirate {

	private final static String DEFAULT_NAME_PREFIX = "Pirate";
	private final static int DEFAULT_HEALTH = 5;
	private static int totalDefaultPirates = 1;
	private String name;
	private int health;
	
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
	
	public String toString() {
		return "[" + name + ", " + health + "]";
	}
	
}

package week05.slot01.assets;

import week05.slot01.assets.interfaces.Placeable;
import week05.slot01.assets.weapons.Weapon;

public class Pirate implements Placeable {

	private final static String DEFAULT_NAME_PREFIX = "Pirate";
	private final static int DEFAULT_HEALTH = 5;
	private static int totalDefaultPirates = 1;
	private String name;
	private int health;
	private int defence;
	private Weapon weapon;
	
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
		return "[" + name + ", " + health + "h, " 
				+ defence + "d, " + weapon + "]";
	}	
	
	public void attackOtherPirate(Pirate otherPirate) {
		if(otherPirate != null) {
			if(weapon != null) {
				int damage = weapon.doDamage(otherPirate);
				if(damage > 0) {
					int newHealth = otherPirate.health - damage;
					otherPirate.health = newHealth;
				}
			} else {				
				if(otherPirate.defence < 1) {			
					otherPirate.health--;
				}
			}
		}
	}
	
	public void equipWeapon(Weapon weapon) {
		if(weapon != null) {			
			this.weapon = weapon;
		}
	}
	
	public void unEquipWeapon() {
		this.weapon = null;
	}

	public int getDefence() {
		return defence;
	}

	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		if(health <= 0) {
			health = 1;
		}
		this.health = health;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}

}

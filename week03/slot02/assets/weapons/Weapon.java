package week03.slot02.assets.weapons;

import week03.slot02.assets.Pirate;

public class Weapon {
	
	private int damage;
	
	public Weapon(int damage) {
		setDamage(damage);
	}
	
	@Override
	public String toString() {
		return "Weapon [damage=" + damage + "]";
	}

	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		if(damage < 1) {
			damage = 1;
		}
		this.damage = damage;
	}
	
	public int doDamage(Pirate pirate) {
		if(pirate != null) {
			int newDamage = damage - pirate.getDefence();
			return newDamage;
		}
		return -1;
	}

}

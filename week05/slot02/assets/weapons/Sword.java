package week05.slot02.assets.weapons;

import week05.slot02.assets.Pirate;

public class Sword extends Weapon {

	public Sword(int damage) {
		super(damage);
	}
	
	@Override
	public String toString() {
		return "Sword [damage=" + damage + "]";
	}

	@Override
	public int doDamage(Pirate pirate) {
		if(pirate != null) {
			int newDamage = damage - pirate.getDefence();
			return newDamage;
		}
		return -1;
	}

}

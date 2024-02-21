package week05.slot02.assets.weapons;

import week05.slot02.assets.Pirate;

public class Axe extends Weapon {

	public Axe(int damage) {
		super(damage);
	}

	@Override
	public String toString() {
		return "Axe [damage=" + damage + "]";
	}
	
	public int doDamage(Pirate pirate) {
		if(pirate != null) {
			return damage;
		}
		return -1;
	}

}

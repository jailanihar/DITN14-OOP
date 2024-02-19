package week04.slot01.assets.weapons;

import week04.slot01.assets.Pirate;

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

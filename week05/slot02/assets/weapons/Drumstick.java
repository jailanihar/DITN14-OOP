package week05.slot02.assets.weapons;

import week05.slot02.assets.Pirate;
import week05.slot02.assets.interfaces.Consumable;

public class Drumstick extends Weapon implements Consumable {

	public Drumstick(int damage) {
		super(damage);
	}

	@Override
	public int doDamage(Pirate pirate) {
		if(pirate != null && pirate.getDefence() > 0) {
			int newDamage = damage * 2;
			return newDamage;
		}
		return -1;
	}

	@Override
	public String toString() {
		return "Drumstick [damage=" + damage + "]";
	}

	@Override
	public int doHealing(Pirate pirate) {
		if(pirate != null) {
			int newHealth = damage;
			return newHealth;
		}
		return -1;
	}

}

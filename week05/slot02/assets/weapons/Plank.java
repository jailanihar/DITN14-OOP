package week05.slot02.assets.weapons;

import week05.slot02.assets.Pirate;

public class Plank extends Weapon {

	private int durability = 100;
	
	public Plank(int damage) {
		super(damage);
	}

	@Override
	public int doDamage(Pirate pirate) {
		if(pirate != null) {
			if(durability > 0) {
				if(pirate.getDefence() > 0) {
//					durability -= 20;
					durability = durability - 20;
				} else {
					durability -= 10;
				}
				return damage;
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		return "Plank [durability=" + durability + ", damage=" + damage + "]";
	}
	
}

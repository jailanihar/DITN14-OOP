package week05.slot02.assets;

import week05.slot02.assets.interfaces.Consumable;
import week05.slot02.assets.interfaces.Placeable;

public class Chicken implements Placeable, Consumable {
	
	private boolean isRaw;
	
	public Chicken(boolean isRaw) {
		this.isRaw = isRaw;
	}

	@Override
	public int doHealing(Pirate pirate) {
		if(pirate != null) {
			int newHealth = 0;
			if(isRaw) {
				newHealth = pirate.getHealth() - 1;
			} else {
				newHealth = pirate.getHealth() + 2;
			}
			return newHealth;
		}
		return -1;
	}

	@Override
	public String toString() {
		return "Chicken [isRaw=" + isRaw + "]";
	}
	
}

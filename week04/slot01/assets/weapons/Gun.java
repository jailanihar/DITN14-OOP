package week04.slot01.assets.weapons;

import week04.slot01.assets.Pirate;

public class Gun extends Weapon {

	protected int ammo;
	
	public Gun(int damage, int ammo) {
		super(damage);
		if(ammo <= 0) {
			ammo = 1;
		}
		this.ammo = ammo;
	}

	@Override
	public String toString() {
		return "Gun [ammo=" + ammo + ", damage=" + damage + "]";
	}
	
	public int doDamage(Pirate pirate) {
		if(pirate != null && ammo > 0) {
			ammo--;
			return super.doDamage(pirate);
		}
		return -1;
	}

}

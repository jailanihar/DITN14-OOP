package week04.slot02.app;

import week04.slot02.assets.Map;
import week04.slot02.assets.Pirate;
import week04.slot02.assets.Potion;
import week04.slot02.assets.weapons.Axe;
import week04.slot02.assets.weapons.Drumstick;
import week04.slot02.assets.weapons.Gun;
import week04.slot02.assets.weapons.Sword;
import week04.slot02.assets.weapons.Weapon;

public class TestApp {

	public static void main(String[] args) {
		Map map = new Map(5, 5);
		
		map.addPirate(0, 0, new Pirate());
		map.addPirate(1, 0, new Pirate("Abu", 3, 1));
		map.addPirate(1, 1, new Pirate("Bakar", 5, 2));
		map.addAssets(2, 3, new Axe(5));
		map.addAssets(1, 2, new Potion(3));
		map.addAssets(3, 0, new Drumstick(4));
		printArena(map);
		
	}

	public static void printArena(Map map) {
		for(int y = 0; y < map.getHeight(); y++) {
			for(int x = 0; x < map.getWidth(); x++) {
				System.out.print(map.selectAssets(x, y) + "\t");
			}
			System.out.println();
		}
		System.out.println("*****");
	}

}

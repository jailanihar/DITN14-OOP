package week05.slot01.app;

import week05.slot01.assets.Map;
import week05.slot01.assets.Pirate;
import week05.slot01.assets.Potion;
import week05.slot01.assets.weapons.Axe;
import week05.slot01.assets.weapons.Drumstick;
import week05.slot01.assets.weapons.Gun;
import week05.slot01.assets.weapons.Sword;
import week05.slot01.assets.weapons.Weapon;

public class TestApp {

	public static void main(String[] args) {
		Map map = new Map(5, 5);
		
		map.addPirate(0, 0, new Pirate());
		map.addPirate(1, 0, new Pirate("Abu", 3, 1));
		map.addPirate(1, 1, new Pirate("Bakar", 5, 2));
		map.addAssets(0, 2, new Axe(5));
		map.addAssets(1, 2, new Potion(3));
		map.addAssets(0, 1, new Drumstick(4));
		printArena(map);
		
		map.movePirateDown(0, 0);
		map.movePirateDown(1, 1);
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

package week03.slot02.app;

import week03.slot02.assets.Map;
import week03.slot02.assets.Pirate;
import week03.slot02.assets.weapons.Weapon;

public class TestApp {

	public static void main(String[] args) {
		Map map = new Map(5, 5);
		
		map.addPirate(0, 0, new Pirate());
		map.addPirate(1, 0, new Pirate("Abu", 3, 1));
		map.addPirate(0, 2, new Pirate("Bakar", 2));
		printArena(map);
		
		Weapon weapon = new Weapon(3);
		map.selectPirate(0, 0).equipWeapon(weapon);
		printArena(map);
		
		map.movePirateRight(0, 0);
		printArena(map);
		map.movePirateRight(0, 0);
		printArena(map);
	}

	public static void printArena(Map map) {
		for(int y = 0; y < map.getHeight(); y++) {
			for(int x = 0; x < map.getWidth(); x++) {
				System.out.print(map.selectPirate(x, y) + "\t");
			}
			System.out.println();
		}
		System.out.println("*****");
	}

}

package week04.slot01.app;

import week04.slot01.assets.Map;
import week04.slot01.assets.Pirate;
import week04.slot01.assets.weapons.Axe;
import week04.slot01.assets.weapons.Gun;
import week04.slot01.assets.weapons.Sword;
import week04.slot01.assets.weapons.Weapon;

public class TestApp {

	public static void main(String[] args) {
		Map map = new Map(5, 5);
		
		map.addPirate(0, 0, new Pirate());
		map.addPirate(1, 0, new Pirate("Abu", 3, 1));
		map.addPirate(1, 1, new Pirate("Bakar", 5, 2));
		printArena(map);
		
		Gun gun = new Gun(2, 1);
		map.selectPirate(0, 0).equipWeapon(gun);
		Sword sword = new Sword(4);
		map.selectPirate(1, 0).equipWeapon(sword);
		Axe axe = new Axe(3);
		map.selectPirate(1, 1).equipWeapon(axe);
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

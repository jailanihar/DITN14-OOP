package week03.slot01.app;

import week03.slot01.assets.Map;
import week03.slot01.assets.Pirate;

public class TestApp {

	public static void main(String[] args) {
		Map map = new Map(5, 5);

		map.addPirate(1, 2, new Pirate("Abu", 4));
		map.addPirate(0, 0, new Pirate("Bakar", 3));
		map.addPirate(4, 3, new Pirate("Curi", 5));
		map.addPirate(2, 4, new Pirate("Daging", 2));
		map.addPirate(1, 0, new Pirate("Emak", 6));
		printArena(map);
		
		map.movePirate(1, 2, Map.DIRECTION_UP);
		printArena(map);
		
		map.movePirate(1, 1, Map.DIRECTION_UP);
		printArena(map);
		
		map.movePirateLeft(1, 0);
		printArena(map);
		
		map.movePirateLeft(1, 0);
		map.movePirateLeft(1, 0);
		map.movePirateLeft(1, 0);
		map.movePirateLeft(1, 0);
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

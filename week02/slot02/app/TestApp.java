package week02.slot02.app;

import week02.slot02.assets.Map;
import week02.slot02.assets.Pirate;

public class TestApp {

	public static void main(String[] args) {
		Map map = new Map();

		map.arena[1][2] = new Pirate("Abu", 4);
		map.arena[0][0] = new Pirate("Bakar", 3);
		map.arena[4][3] = new Pirate("Curi", 5);
		map.arena[2][4] = new Pirate("Daging", 2);

		printArena(map);

		map.arena[1][0] = new Pirate("Emak", 6);

		printArena(map);
	}

	public static void printArena(Map map) {
		for(int y = 0; y < map.arena[0].length; y++) {
			for(int x = 0; x < map.arena.length; x++) {
				System.out.print(map.arena[x][y] + "\t");
			}
			System.out.println();
		}
		System.out.println("*****");
	}

}

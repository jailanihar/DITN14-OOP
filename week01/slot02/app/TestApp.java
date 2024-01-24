package week01.slot02.app;

import week01.slot02.assets.Pirate;

public class TestApp {

	public static void main(String[] args) {
		Pirate pirate1 = new Pirate("Abu", 4);
		Pirate pirate2 = new Pirate("Bakar", 3);
		Pirate pirate3 = new Pirate("Curi", 5);
		System.out.println(pirate1.name);
		System.out.println(pirate2.name);
		System.out.println(pirate3.name);
	}
	
}

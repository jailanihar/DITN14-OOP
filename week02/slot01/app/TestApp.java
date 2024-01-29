package week02.slot01.app;

import week02.slot01.assets.Pirate;

public class TestApp {

	public static void main(String[] args) {
		Pirate pirate1 = new Pirate(new String(""), -5);
		Pirate pirate2 = new Pirate(null, 3);
		Pirate pirate3 = new Pirate("Curi", 5);
		System.out.println(pirate1);
		System.out.println(pirate2);
		System.out.println(pirate3);
	}
	
}

package week01.slot02.app;

import week01.slot02.assets.Pirate;

public class TestApp {

	public static void main(String[] args) {
		Pirate pirate1 = new Pirate();
		Pirate pirate2 = new Pirate();
		Pirate pirate3 = pirate1;
		pirate1.name = "Abu";
		
		System.out.println(pirate1.name);
		System.out.println(pirate2.name);
		System.out.println(pirate3.name);
		
		pirate3.name = "Bakar";
		System.out.println(pirate1.name);
		System.out.println(pirate2.name);
		System.out.println(pirate3.name);
		
		pirate2.name = "Curi";
		System.out.println(pirate1.name);
		System.out.println(pirate2.name);
		System.out.println(pirate3.name);
		
		pirate1.totalPirates = 1;
		System.out.println(pirate1.totalPirates);
		System.out.println(pirate2.totalPirates);
		System.out.println(pirate3.totalPirates);
	}
	
}

package week06.slot01.datastructures;

import java.util.ArrayList;

public class LearningArrayList {

	public static void main(String[] args) {
		ArrayList<String> countryList = new ArrayList<String>();
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		
		System.out.println(countryList.isEmpty());
		System.out.println(countryList.size());
		System.out.println(countryList);
		
		countryList.add("Brunei");
		countryList.add("Malaysia");
		countryList.add("Indonesia");
		
		System.out.println(countryList.isEmpty());
		System.out.println(countryList.size());
		System.out.println(countryList);
		
		System.out.println(countryList.get(1));
		
		countryList.add(1, "Singapore");
		
		System.out.println(countryList.get(1));
		System.out.println(countryList);
		
		countryList.add(countryList.size(), "Timor Leste");
		System.out.println(countryList);
		System.out.println(countryList.get(countryList.size() - 1));
		
		countryList.remove(0);
		System.out.println(countryList);
		System.out.println(countryList.get(0));
		
		countryList.set(1, "Vietnam");
		System.out.println(countryList);
		System.out.println(countryList.get(1));
	}
	
}

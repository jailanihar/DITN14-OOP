package week06.slot01.datastructures;

import java.util.LinkedList;
import java.util.ListIterator;

public class LearningLinkedList {

	public static void main(String[] args) {
		LinkedList<String> cityList = new LinkedList<String>();
		
		System.out.println(cityList.isEmpty());
		System.out.println(cityList.size());
		System.out.println(cityList);
		
		cityList.add("BSB");
		System.out.println(cityList);
		
		cityList.add("Singapore");
		cityList.addLast("Jakarta");
		System.out.println(cityList);
		
		cityList.addFirst("Phnom Penh");
		System.out.println(cityList);
		
		cityList.removeFirst();
		System.out.println(cityList.getFirst());
		
		ListIterator<String> iterator = cityList.listIterator();
		
		System.out.println(iterator.next());
		
		iterator.add("KL");
		System.out.println(cityList);
		
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		if(iterator.hasNext()) {
			System.out.println(iterator.next());			
		}
		
		while(iterator.hasPrevious()) {
			System.out.println(iterator.previous());
		}
		
		iterator.remove();
		System.out.println(cityList);
//		iterator.remove();
//		iterator.set("Bangkok");
		
		iterator.next();
		iterator.set("Bangkok");
		System.out.println(cityList);
		
	}
	
}

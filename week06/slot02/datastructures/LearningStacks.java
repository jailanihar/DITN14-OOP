package week06.slot02.datastructures;

import java.util.Stack;

public class LearningStacks {

	public static void main(String[] args) {
		Stack<String> bookStack = new Stack<String>();
		
		bookStack.add("Java");
		bookStack.add("PHP");
		bookStack.add("Python");
		System.out.println(bookStack);
		
		System.out.println(bookStack.peek());
		System.out.println(bookStack);
		
		System.out.println(bookStack.pop());
		System.out.println(bookStack);
		
		while(!bookStack.isEmpty()) {
			System.out.println(bookStack.pop());
		}
	}
	
}

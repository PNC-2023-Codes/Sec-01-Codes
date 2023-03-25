package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Ex01 {

	public static void main(String[] args) {
		// List
		
		System.out.println("------------------- Manejo de listas -------------------");
		
		List<Integer> numbers = new ArrayList<>();
		
		numbers.add(1);
		numbers.add(4);
		numbers.add(6);
		numbers.add(11);
		numbers.add(15);
		numbers.add(17);
		
		System.out.println(numbers);
		
		//numbers.remove(0);
		
		System.out.println("-------------------");
		for(int i=0; i<numbers.size(); i++) {
			int value = numbers.get(i);
			
			System.out.println("Valor " + i + ": " +  value);
		}
		
		System.out.println("-------------------");
		Iterator<Integer> listIterator = numbers.iterator();
		
		
		while(listIterator.hasNext()) {
			int value = listIterator.next();
			
			System.out.println("Valor :" + value);
		}
		
		System.out.println("------------------- Manejo de stacks -------------------");
		Stack<Integer> numbersStack = new Stack<>();
		
		numbersStack.push(1);
		numbersStack.push(3);
		numbersStack.push(14);
		numbersStack.push(19);
		numbersStack.push(21);
		
		System.out.println(numbersStack);
		System.out.println("-------------------");
		
		Iterator<Integer> stackIterator = numbersStack.iterator();
		
		while(stackIterator.hasNext()) {
			int value = numbersStack.pop();
			System.out.println("Value: " + value);
			System.out.println(numbersStack);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
}

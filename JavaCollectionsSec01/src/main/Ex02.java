package main;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex02 {

	public static void main(String[] args) {
		// Sets
		System.out.println("------------------- Manejo de Sets -------------------");
		
		Integer[] numbers01 = new Integer[] {1, 1, 2, 3, 3, 4, 5, 5, 5, 11, 23, 6, 6};
		Integer[] numbers02 = new Integer[] {0, 2, 2, 7, 22, 11, 5};
		
		Set<Integer> set01 = new HashSet<>();
		Collections.addAll(set01, numbers01);
		
		System.out.println(set01);
		
		set01.add(2);
		set01.add(3);
		set01.add(8);
		
		System.out.println(set01);
		
		System.out.println("----------------------");
		
		Set<Integer> set02 = new TreeSet<>();
		Collections.addAll(set02, numbers02);
		
		System.out.println(set02);
		set02.addAll(set01);
		System.out.println(set02);
	}

	
	
	
	
	
	
	
	
	
	
	
}

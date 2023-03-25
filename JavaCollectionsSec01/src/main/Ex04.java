package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ex04 {

	public static void main(String[] args) {
		// Streams
		System.out.println("------------------- Manejo de Streams -------------------");
		
		List<Integer> numbers = new ArrayList<>();
		Collections.addAll(numbers, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		System.out.println(numbers);
		System.out.println("------------------- ForEach -------------------");
		
		numbers.stream()
			.forEach((number) -> {
				System.out.println("For each: " + number);
			});
		
		System.out.println("------------------- Map -------------------");
		
		List<Integer> doubles = numbers.stream()
			.filter(number -> number % 2 == 0)
			.map(number -> number * 2)
			.collect(Collectors.toList());
		
		
		System.out.println(doubles);
		System.out.println(numbers);
		
		System.out.println(numbers.stream());
		
	}

	
	
	
	
	
	
	
	
}

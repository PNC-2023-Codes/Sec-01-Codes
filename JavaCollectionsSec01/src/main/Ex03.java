package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Ex03 {

	public static void main(String[] args) {
		// Maps
		System.out.println("------------------- Manejo de Maps -------------------");
		
		Map<Character, String> map = new TreeMap<>();
		
		map.put('a', "Valor 01");
		map.put('b', "Valor 02");
		map.put('x', "Valor 03");
		map.put('h', "Valor 04");
		map.put('t', "Valor 05");
		map.put('e', "Valor 06");
		
		System.out.println(map);
		
		System.out.println("Valor a: " + map.get('a'));
		
		System.out.println("----------------------");
		
		Iterator<Character> keysIterator =  map.keySet().iterator();
		while(keysIterator.hasNext()) {
			String value = map.get(keysIterator.next());
			System.out.println("Valor: " + value);

		}
	}

	
	
	
	
	
	
	
	
	
}

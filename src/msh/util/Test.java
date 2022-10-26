package msh.util;

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("Ivanov", 5);
		map.put("Petrov", 5);
		map.put("Sidorov", 3);
		map.put("Golubev", 7);
		map.put("Spiridonov", 1);	
		map.put("Kukushkin", 7);
		map.put("Antonov", 3);
		
		// Expected result is:
		//     Kukushkin=7
		//     Golubev=7
		List<Entry<String, Integer>> v = map.entrySet()
		.parallelStream()
		.collect(MaxRatedWinnersCollector.of(e -> e.getValue()))
		.res();	
		System.out.println(v);
	}

}

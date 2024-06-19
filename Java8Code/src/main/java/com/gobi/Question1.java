package com.gobi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question1 {

	public static void main(String[] args) {
		// Write a program to find the second-highest element from an array. 
		//The array can contain duplicate elements. Solve it using Java 8 streams.
		
		int[] arr = {3,5,6,5,7,8,3,4,2,1};
		String str = "welcome to the world";
		
		Integer secondHighest = Arrays.stream(arr).distinct().boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		
		System.out.println(secondHighest);
		
		//Find the duplicate element and its occurrence in a given string using the Stream API.
		
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().filter(x -> x.getValue() > 1).map(Entry::getKey).collect(Collectors.toList());
		
		List<String> strList = Arrays.stream(str.replaceAll("\\s","").split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() > 1).map(Entry::getKey).collect(Collectors.toList());
		
		System.out.println(list);
		System.out.println(strList);
		
		//Write a program to find the first non-repeating element from a given string using Java Streams.
		
		Integer intValue = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
		.entrySet().stream().filter(x -> x.getValue() == 1).map(Entry::getKey).findFirst().get();
		
		String strValue = Arrays.stream(str.replaceAll("\\s","").split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() == 1).map(Entry::getKey).findFirst().get();
		
		System.out.println(intValue);
		System.out.println(strValue);
		
		//Write a program to find unique elements in a given string using Java streams.
		
		List<String> strValueList = Arrays.stream(str.replaceAll("\\s","").split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() == 1).map(Entry::getKey).collect(Collectors.toList());
		System.out.println(strValueList);
		
		//Write a program to find the longest string in a given array.
		String[] strArr = {"welcome","to","the","world"};
		
		String longestString = Arrays.stream(strArr).reduce((w1,w2) -> w1.length() > w2.length() ? w1 : w2).get();
		System.out.println(longestString);
		
		//Write a program to sort two types of numbers to the left and right in an array. 
		//Example: Integer array[] = [5, 5, 0, 5, 0] -> output: [0, 0, 5, 5, 5]
		
		int[] intArr = {5, 5, 0, 5, 0};
		
		int l = intArr.length;
		int j = 0;
		
		for (int i = 0; i < l; i++) {
			if (intArr[i] == 0) {
				int t = intArr[i];
				intArr[i] = intArr[j];
				intArr[j] = t;
				j++;
			}
		}
		
		System.out.println(Arrays.toString(intArr));
		
		//Write a program to find the first repeating element/character from a given string using Java Streams.
		String strValue1 = Arrays.stream(str.replaceAll("\\s","").split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() > 1).map(Entry::getKey).findFirst().get();
		
		System.out.println(strValue1);
		
		//Write to find the duplicate characters in a list of strings using the Stream API?
		List<String> strings = Arrays.asList("hello", "world", "helloooo");
		
		List<Character> listOfChar = strings.stream().flatMapToInt(e -> e.chars()).mapToObj(e -> (char)e).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().filter(e -> e.getValue() > 1).map(Entry::getKey).collect(Collectors.toList());
		
		System.out.println(listOfChar);
		
		Character listOfChar1 = strings.stream().flatMapToInt(e -> e.chars()).mapToObj(e -> (char)e).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().max(Entry.comparingByValue()).map(Entry::getKey).get();
				
		System.out.println(listOfChar1);
		
		
	}

}

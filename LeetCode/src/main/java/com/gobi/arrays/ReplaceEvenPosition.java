package com.gobi.arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReplaceEvenPosition {

	public static void main(String[] args) {
		int[] a = {6,3,7,2,8,9,5,8,99};
		int[] b = {4,8,5,9,3,5,1};
		
		int[] in = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
		System.out.println(Arrays.toString(in));
		
		int sum = IntStream.range(0, a.length)
		        .map(number -> a[number] % 3 == 0 ? a[number] : 0)
		        .sum();
		
		System.out.println("sum ::"+sum);
		
		
		List<Integer> numbers = IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList());
		int min = numbers.stream().mapToInt(n -> n).min().getAsInt();
		System.out.println("min :: "+min);
		int max = numbers.stream().mapToInt(n -> n).max().getAsInt();
		System.out.println("max :: "+max);

		// method 2
		int sum2 = numbers.stream()
		        .filter(number -> number % 2 == 0)
		        .mapToInt(number -> number) // convert to IntStream
		        .sum();
		System.out.println("sum2 ::"+sum2);
		
		int[] c1 = IntStream.range(0, a.length).map((i) -> {
			if (i%2 == 0 && b.length > i) {
				a[i] = b[i];
			}
			return a[i];
		}).toArray();
		
		System.out.println(Arrays.toString(c1));
		
		int[] c = IntStream.range(0, a.length).map(i -> (i%2 == 0 && b.length > i) ? a[i] = b[i] : a[i]).toArray();
		
		System.out.println(Arrays.toString(c));
		
		IntStream.range(0, 255).forEach(i -> System.out.print((char)i));//LowerCase
		IntStream.rangeClosed('A', 'Z').forEach(i -> System.out.print((char)i));//LowerCase
		//IntStream.range(65, 65+26).forEach(i -> System.out.print((char)i));//UpperCase
	}

}

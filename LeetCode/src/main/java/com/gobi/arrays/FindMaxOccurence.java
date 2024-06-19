package com.gobi.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindMaxOccurence {

	public static void main(String[] args) {
		char[] ch = {'a','b','a','c','d','b','b'};
		int length = ch.length;
		int currIndx = 0, maxIndx = 0;
		char maxChar = 0;
		
		Set<Character> charSet = new HashSet<>();
		
		for (int i = 0; i < length; i++) {
			if (!charSet.contains(ch[i])) {
				for (int j = i+1;j < length; j++) {
					if (ch[i] == ch[j]) {
						currIndx++;
					} 
				}
				
				if (currIndx > maxIndx) {
					maxIndx = currIndx;
					maxChar = ch[i];
				}
				charSet.add(ch[i]);
			}
		}
		
		System.out.println("Max Occurance :: "+maxChar);
	}

}

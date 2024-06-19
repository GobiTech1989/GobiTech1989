package com.gobi.arrays;

public class Pattern1 {

	public static void main(String[] args) {
		int n = 5;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = n; i>=1; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 1 || i == n) {
					System.out.print("*");
				} else if (j == 0 || j == (n-1)){
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}

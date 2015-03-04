package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class AntiPalindromicStrings {

	private static long SPECIAL_MOD = (pow(10, 9) + 7);

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);

		int size = Integer.parseInt(in.nextLine());
		String[] a = new String[size];

		for (int i = 0; i < size; i++) {
			a[i] = in.nextLine();
		}

		for (int i = 0; i < a.length; i++) {
			int n = Integer.parseInt(a[i].split(" ")[0]);
			int m = Integer.parseInt(a[i].split(" ")[1]);
			System.out.println(compute(m, n));
		}
	}

	private static long compute(int m, int n) {
		if (n == 1) {
			return m;
		} else if (n == 2) {
			return (m * (m - 1)) % SPECIAL_MOD;
		} else {
			return (m * (m - 1) * pow(m - 2, n - 2)) % SPECIAL_MOD;
		}
	}

	public static long pow(long base, long exp) {
		if (exp == 0) {
			return 1;
		}
		if (exp == 1) {
			return base;
		}
		if (exp % 2 == 0) {
			long half = pow(base, exp / 2);
			return half * half;
		} else {
			long half = pow(base, (exp - 1) / 2);
			return base * half * half;
		}
	}

}

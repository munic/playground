package com.hackerrank.algorithms.warmup;

import java.util.Scanner;

public class LonelyInteger {
	static int lonelyinteger(int[] a) {

		// we know the constraints of the problem, so just init array of length 100 to keep track of counts
		int[] counts = new int[100];		
		for (int i = 0; i < a.length; i++) {
			counts[a[i]]++; 
		}
		for (int i = 0; i < counts.length; i++) {
			if(counts[i] == 1){
				return i;
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;

		int _a_size = Integer.parseInt(in.nextLine());
		int[] _a = new int[_a_size];
		int _a_item;
		String next = in.nextLine();
		String[] next_split = next.split(" ");

		for (int _a_i = 0; _a_i < _a_size; _a_i++) {
			_a_item = Integer.parseInt(next_split[_a_i]);
			_a[_a_i] = _a_item;
		}

		res = lonelyinteger(_a);
		System.out.println(res);

	}
}

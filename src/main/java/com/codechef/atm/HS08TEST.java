package com.codechef.atm;

import java.util.Scanner;

public class HS08TEST {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		Scanner lineTokenizer;
		while (console.hasNextLine()) {
			lineTokenizer = new Scanner(console.nextLine());
			int amount = 0;
			double balance = 0.0;
			if (lineTokenizer.hasNext()) {
				if (lineTokenizer.hasNextInt()) {
					amount = lineTokenizer.nextInt();
				}
				if (lineTokenizer.hasNextDouble()) {
					balance = lineTokenizer.nextDouble();
					ATM atm = new ATM();
					System.out.println(atm.withdraw(amount, balance));
					console.close();
					lineTokenizer.close();
					break;
				}
			}
		}
	}
}



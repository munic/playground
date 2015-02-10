package com.codechef.atm;

public class ATM {

	private static final double FEE = 0.50;

	public double withdraw(int amount, double balance) {
		if (amount <= 0 || amount > 2000 || amount % 5 != 0) {
			System.out.println("Invalid withdrawal");
			return balance;
		}
		if (balance < 0 || balance > 2000 || amount > balance) {
			System.out.println("Invalid balance");
			return balance;
		}
		double remainingBalance = (balance - amount) - FEE;
		return Math.round(remainingBalance * 100.0) / 100.0;
	}
}

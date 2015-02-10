package com.codechef.atm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HS08TESTTest {	

	@Test
	public void testValidWithdrawal() {
		ATM atm = new ATM();
		double remainingBalance = atm.withdraw(30, 120.00);
		assertTrue(String.format("Remaining balance is not correct [remainingBalance = %s]", remainingBalance), remainingBalance == 89.50);		
	}
	
	@Test
	public void testInvalidWithdrawalAmount() {
		ATM atm = new ATM();
		double remainingBalance = atm.withdraw(42, 120.00);
		assertTrue(String.format("Remaining balance is not correct [remainingBalance = %s]", remainingBalance), remainingBalance == 120.00);	
	}
	
	@Test
	public void testWithdrawalInsufficientFunds() {
		ATM atm = new ATM();
		double remainingBalance = atm.withdraw(300, 120.00);
		assertTrue(String.format("Remaining balance is not correct [remainingBalance = %s]", remainingBalance), remainingBalance == 120.00);	
	}
}

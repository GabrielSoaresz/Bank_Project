package model.entities;

import model.exceptions.DomainException;

public class SavingsAccount extends Account {
	private double interestRate;
	
	public SavingsAccount(Integer number, String holder, double balance, double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void updateBalance() throws DomainException {
		deposit(getBalance() * interestRate);
	}
	
	@Override
	public final void withdraw(double amount) throws DomainException {
		super.withdraw(amount);
	}
}

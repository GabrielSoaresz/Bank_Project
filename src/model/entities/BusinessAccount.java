package model.entities;

import model.exceptions.DomainException;

public class BusinessAccount extends Account {
	private double loanLimit;
	
	public BusinessAccount(int number, String holder, double balance, double loanLimit) {
		super(number, holder, balance);
		this.loanLimit = loanLimit;
	}

	public double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(double loanLimit) {
		this.loanLimit = loanLimit;
	}
	
	public void loan(double amount) throws DomainException {
		if(amount > loanLimit) {
			throw new DomainException("Request denied! Loan amount greater than the limit.");
		}
			deposit(amount);
	}
	
	@Override
	public void withdraw(double amount) throws DomainException {
		super.withdraw(amount);
		if((amount + 2) > balance) {
			throw new DomainException("ERROR: Insufficient balance.");
		}
		balance -= 2.0;
	}
}

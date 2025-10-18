package model.entities;

import model.exceptions.DomainException;

public abstract class Account {
	private int number;
	private String holder;
	protected double balance;
	
	public Account() {
		
	}

	public Account(int number, String holder, double balance) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) throws DomainException {
		if(amount < 0) {
			throw new DomainException("ERROR: Deposit cannot be negative");
		}
		balance += amount;
	}
	
	public void withdraw(double amount) throws DomainException {
		if(amount > balance) {
			throw new DomainException("ERROR: Insufficient balance.");
		}
		if(amount < 0) {
			throw new DomainException("ERROR: Withdrawal cannot be negative.");
		}
		balance -= amount;
	}
	
	public String toString() {
		return String.format("Account number: $d, Holder: %s, Balance: %.2f",
				getNumber(), getHolder(), getBalance());
	}
}

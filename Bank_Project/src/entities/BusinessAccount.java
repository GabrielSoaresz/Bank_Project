package entities;

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
	
	public void loan(double amount) {
		if(amount > loanLimit) {
			System.out.println("Request denied! Loan amount greater than the limit.");
		}else {
			deposit(amount);
		}
	}
	
	@Override
	public void withdraw(double amount) {
		//Faz mesma operação da classe Accountt
		super.withdraw(amount);
		balance -= 2.0;
	}
}

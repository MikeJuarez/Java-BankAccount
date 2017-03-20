
public class SavingsAccount extends BankAccount{

	private double monthlyInterest = 0;
	
	public SavingsAccount(){
		super();
		setInterestRate(1.5);
	}
			
	public void addInterest(){		
		monthlyInterest += (getAccountBalance() * getMonthlyInterestRate());
		setAccountBalance(getAccountBalance() + monthlyInterest);		
	}
	
	public double getMonthlyInterest(){
		return monthlyInterest;
	}
}

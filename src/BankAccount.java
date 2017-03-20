
import java.util.Date;
import java.util.Random;

public class BankAccount {
	
	private int accountId;
	private double accountBalance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated;
	private String name = "";
	private String password = "";
	
	public BankAccount() {
		Random rn = new Random();		
		
		//Update dateCreated
		dateCreated = new Date();	
		
		//Update accountId with the random number
		accountId = rn.nextInt(9999-1000)+1000;
		
		password = generatePassword();
	}
	
	//Accessors
	public double getAccountBalance() {
		return accountBalance;
	}
	
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	public double getMonthlyInterestRate() {		
		return (annualInterestRate/12);		
	}
	
	public String getName(){
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	private String generatePassword() {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String pass = "";
		Random random = new Random();			
		while (pass.length() < 4) 
		{
			char c = alphabet.charAt(random.nextInt(26));
			pass+=c;			
		}
		return pass;
	}

	
	//Mutators
	public void setAccountBalance(double acc)
	{
		accountBalance += acc;
	}
	
	public void setInterestRate(double acc)
	{
		annualInterestRate += acc;
	}
	
	public void withdraw(double amt)
	{
		accountBalance -= amt;		
	}
	
	public void deposit(double amt)
	{
		accountBalance += amt;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	
	
	
	
}

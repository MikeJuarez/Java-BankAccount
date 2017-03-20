import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

	ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
	
	public Bank(){
		
	}
	
	public void update(){
		
		for (int i = 0; i < bankAccounts.size(); i++){
			
			BankAccount ba = new BankAccount();
			
			ba = bankAccounts.get(i);
			
			if (ba instanceof SavingsAccount)
			{
					((SavingsAccount) ba).addInterest();
			}
			else if (ba instanceof CurrentAccount)
			{
				if (((CurrentAccount) ba).checkOverdraft()) {
					System.out.println("Account ID: " + ba.getAccountId() + " is overdrafted.");
				}				
			}		
		}
	}
	
	public void openAccount(){
		Scanner sc = new Scanner(System.in);		
		System.out.print("What is your name? ");	
			
		String name = sc.nextLine();
		System.out.println("");
		
		System.out.print("What type of account would you like to create?");		
		System.out.print("Regular, Savings or Current: ");
		String baType = sc.nextLine();	
				
		if (baType.equalsIgnoreCase("Regular"))		
		{
			BankAccount ba = new BankAccount();
			ba.setName(name);
			bankAccounts.add(ba);
		}
		else if (baType.equalsIgnoreCase("Savings")){
			SavingsAccount sa = new SavingsAccount();
			sa.setName(name);
			bankAccounts.add(sa);
		}			
		else if (baType.equalsIgnoreCase("Current"))
		{
			CurrentAccount ca = new CurrentAccount(1);
			ca.setName(name);
			bankAccounts.add(ca);
		}
		else
			System.out.println("Invalid account type!");
	
	}
	
	public void closeAccount(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What is your name? ");
		String name = sc.nextLine();
				
		System.out.println("What is your Account ID");
		int id = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < bankAccounts.size(); i++){
			
			BankAccount ba = new BankAccount();
			ba = bankAccounts.get(i);
			
			if (ba.getAccountId() == id && ba.getName().equalsIgnoreCase(name))
			{
				bankAccounts.remove(i);
				break;
			}
		}
	}
	
	public void addAccount(BankAccount ba){
		bankAccounts.add(ba);
	}
	
	public BankAccount getBankAccount(String id, String pass){
		
		for (int i = 0; i < bankAccounts.size(); i++){
			
			BankAccount ba = new BankAccount();
			ba = bankAccounts.get(i);
			
			if (Integer.parseInt(id) == ba.getAccountId()  && ba.getPassword().equals(pass))
			{
				return ba;				
			}
		}
		
		return null;
	}
}

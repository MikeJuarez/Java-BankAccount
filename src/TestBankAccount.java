import javax.swing.JOptionPane;

public class TestBankAccount {

	public static void main(String[] args) {
		
		BankAccount account = new BankAccount();
		Bank bank = new Bank();
		boolean exitYet = false;
		
		while (!exitYet) {
		Object[] possibleChoices = { "1: Create a New Account", "2: Deposit", "3: Withdraw", "4: Display Balance", "5: Exit"};
		Object selectedChoice = JOptionPane.showInputDialog(null,  "Please Choose an Action: ", "Bank Account Menu", JOptionPane.INFORMATION_MESSAGE, null, possibleChoices, possibleChoices[0]);
		
		
		switch ((String)selectedChoice) {
		case "1: Create a New Account":
			System.out.println(selectedChoice);
			String name = JOptionPane.showInputDialog("Please enter your name.");
			String amount = JOptionPane.showInputDialog("Please enter the initial account balance (initial amount)");
			String accType =  JOptionPane.showInputDialog("Please enter the account type (Basic, Savings, Current)");
			
			//Create the account based on the account type selected
			//Create Basic Account (BankAccount)
			if (accType.equalsIgnoreCase("Basic"))			
				account = new BankAccount();
			//Create Savings Account
			else if (accType.equalsIgnoreCase("Savings"))
				account = new SavingsAccount();	
			//Create Current Account
			else if (accType.equalsIgnoreCase("Current"))			
				account = new CurrentAccount(0);
			//Invalid account
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid Account Type", "Error!", JOptionPane.ERROR_MESSAGE);
				break;				
			}				
			
			//Set the name and initial balance 
			account.setName(name);
			account.setAccountBalance(Double.parseDouble(amount));	
			JOptionPane.showMessageDialog(null, "Your Account ID is: " + account.getAccountId() + "\nYour Password is:" + account.getPassword());
			
			bank.bankAccounts.add(account);			
			break;				
		
		case "2: Deposit":			
			String depositAmt = JOptionPane.showInputDialog("Please enter the amount you'd like to deposit.");			
			String accID = JOptionPane.showInputDialog("Enter the account ID)");
			String pass = JOptionPane.showInputDialog("Enter the account password (case-sensitive)");
			
			BankAccount ba = bank.getBankAccount(accID, pass);
			
			if (ba != null)			
				bank.getBankAccount(accID, pass).deposit(Double.parseDouble(depositAmt));			
			else			
				JOptionPane.showMessageDialog(null, "Sorry either account doesnt exist, invalid account number or invalid password.", "Error!", JOptionPane.ERROR_MESSAGE);			
			break;			
		
		case "3: Withdraw":
			String withdrawAmount = JOptionPane.showInputDialog("Please enter the amount you wish to withdraw");			
			String withdrawAccountID = JOptionPane.showInputDialog("Enter the account ID");
			String withdrawPass = JOptionPane.showInputDialog("Enter the account password (case-sensitive)");
			
			BankAccount ba2 = bank.getBankAccount(withdrawAccountID, withdrawPass);
			
			if (ba2 != null)	
				bank.getBankAccount(withdrawAccountID, withdrawPass).withdraw(Double.parseDouble(withdrawAmount));			
			else			
				JOptionPane.showMessageDialog(null, "Sorry either account doesnt exist, invalid account number or invalid password.", "Error!", JOptionPane.ERROR_MESSAGE);			
			break;		

		case "4: Display Balance":
			accID = JOptionPane.showInputDialog("Enter the account ID)");
			pass = JOptionPane.showInputDialog("Enter the account password (case-sensitive)");
			
			BankAccount ba3 = bank.getBankAccount(accID, pass);
			if (ba3 == null)
			{
				JOptionPane.showMessageDialog(null, "Sorry either account doesnt exist, invalid account number or invalid password.", "Error!", JOptionPane.ERROR_MESSAGE);
				break;
			}
			else if (ba3 != null && ba3 instanceof SavingsAccount)
				JOptionPane.showMessageDialog(null, "Account Type:  Savings\nAccount Balance:  " + ba3.getAccountBalance() + "\nInterest Rate:  " + ba3.getAnnualInterestRate() + "\nCreation Date:  " + account.getDateCreated());
				
			
			else if (ba3 != null && ba3 instanceof CurrentAccount)	
				JOptionPane.showMessageDialog(null, "Account Type: Current\nAccount Balance: " + ba3.getAccountBalance() + "\nInterest Rate: " + ba3.getAnnualInterestRate() + "\nCreation Date: " + account.getDateCreated());		
			else			
				JOptionPane.showMessageDialog(null, "Account Type: Basic\nAccount Balance: " + ba3.getAccountBalance() + "\nInterest Rate: " + ba3.getAnnualInterestRate() + "\nCreation Date: " + account.getDateCreated());
			break;		

		case "5: Exit":			
			int exit = JOptionPane.showConfirmDialog(null, "Exit?", "Exit Window", JOptionPane.YES_NO_OPTION);
			
			if (exit == JOptionPane.YES_OPTION)
			{
				exitYet = true;
				break;
			}
			else
				
			break;
		}
		
}
	}
		
		
}



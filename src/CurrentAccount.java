
public class CurrentAccount extends BankAccount{
	double overdraftLimit;
	
	public CurrentAccount(double od){ 
		super();		
		
		overdraftLimit = od;
	}
	
	public Boolean checkOverdraft(){
		
		if (getAccountBalance() < overdraftLimit){
			return true; //Is Overdrafted
		}
		
		else{
			return false; //Not overdrafted
		}
		
			
	}
}

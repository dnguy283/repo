
public class CheckingAccount extends BankAccount{
	
	//cost of clearing one check
	private static final double FEE = 0.15;
	
	//constructor
	public CheckingAccount(String name, double amount)
	{
		super(name, amount);
		setAccountNumber(getAccountNumber() + "-10");
	}
	
	//overidde the withdraw method in the superclass
	@Override
	public boolean withdraw(double amount)
	{
		return super.withdraw(amount + FEE);
	}
	
	
	
}

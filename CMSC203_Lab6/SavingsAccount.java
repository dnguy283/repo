
public class SavingsAccount extends BankAccount {
	
	private double rate = 0.025;
	private int savingsNumber = 0;
	private String accountNumber;
	
	//constructor
	public SavingsAccount(String name, double amount)
	{
		super(name, amount);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}

	//postInterest method
	public void postInterest()
	{
		deposit(getBalance()*rate/12);
	}
	
	@Override
	public String getAccountNumber()
	{
		return accountNumber;
	}
	
	//copy constructor
	public SavingsAccount(SavingsAccount object2, double amount)
	{
		super(object2, amount);
		savingsNumber = object2.savingsNumber + 1;
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
}

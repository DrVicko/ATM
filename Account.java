package ATM;

public class Account 
{
private int accNumber; private String accOwner; private double accBalance; 
	
	Account () {}
	
	protected Account (int accNumber, String accOwner, double accBalance)
	{
		this.accNumber = accNumber; 
		this.accOwner = accOwner; 
		this.accBalance = accBalance; 
	}

	protected int getAccNumber() {
		return accNumber;
	}

	protected void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	protected String getAccOwner() {
		return accOwner;
	}

	protected void setAccOwner(String accOwner) {
		this.accOwner = accOwner;
	}

	protected double getAccBalance() {
		return accBalance;
	}

	protected void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	@Override
	public String toString() {
		return "Account [accNumber= " + accNumber + ", accOwner= " + accOwner + ", accBalance= " + accBalance + " KM]";
	}

}

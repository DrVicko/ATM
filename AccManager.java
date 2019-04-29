package ATM;

import java.util.ArrayList;

public class AccManager 
{
protected static ArrayList <Account> accList = new ArrayList <>(); 
	
	public static void createAccount (int accNumber, String accOwner, double accBalance)
	{
		Account acc = new Account (accNumber, accOwner, accBalance);
		accList.add(acc); 
	}
	public static void printAccountData ()
	{
		System.out.println("\nATM's accout data: ");
		for (Account x : accList)
		{
			System.out.println(x + "\n");
		}
	}
	public static void printAccountBalance ()
	{
		if (accList.size() < 1)
		{
			System.out.println("There are no accounts created! ");
		}
		else
		{
			System.out.println("Accounts in database and their balance are: ");
			for (int i = 0; i < accList.size(); i++)
			{
				System.out.println(i + " " + accList.get(i) + " with balance of " + accList.get(i).getAccBalance()); 
			}
		}
	}
	public static boolean doesAccNumberExist (int accNumber)
	{
		for (int i = 0; i < accList.size(); i++)
		{
			if (accList.get(i).getAccNumber() == accNumber)
				return false;
		}
		return true; 
	}
	
	public static void transferFunds (int sourceAccount, int targetAccount, double amount)
	{
		double source = accList.get(sourceAccount).getAccBalance(); 
		while (source < amount)
		{
			System.out.println("There is insuficient funds on account, enter amount again: ");
			amount = TestATM.input.nextDouble();
		}
		double target = accList.get(targetAccount).getAccBalance(); 
		double tranferSourceAmount = source - amount; 
		double transferTargetAmount = target + amount; 
		
		accList.get(sourceAccount).setAccBalance(tranferSourceAmount);
		accList.get(targetAccount).setAccBalance(transferTargetAmount);
	}

}

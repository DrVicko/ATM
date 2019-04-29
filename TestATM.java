package ATM;

import java.util.Scanner;

public class TestATM 
{
	protected static Scanner input = new Scanner(System.in);
	public static void main(String[] args) 
	{
		int selection = -1;  int accNumber;  String accOwner;  double accBalance; 
		
		while (selection != 0)
		{
			System.out.println("Insert: "
					        + "\n1. To create new Account. "
				        	+ "\n2. To transfer funds within existing accounts." +
					          "\n3. To print existing accounts data. "
					        + "\n4. To exit ATM. ");
			selection = input.nextInt(); 
			if (selection == 1)
			{
				System.out.println("\nEnter new Account number: ");
				accNumber = input.nextInt(); 
				while (!AccManager.doesAccNumberExist(accNumber))
				{
					System.out.println("You have entered existing Account number, please try again: ");
					accNumber = input.nextInt(); 
				}
				while (accNumber < 1)
				{
					System.out.println("Account number cant be zero or negative, please try again: ");
					accNumber = input.nextInt();
				}
				input.nextLine(); 
				System.out.println("\nEnter Account owners name: ");
				accOwner = input.nextLine(); 
				System.out.println("\nEnter Account's funds balance (Must be positive value!): ");
				accBalance = input.nextDouble(); 
				while (accBalance < 0)
				{
					System.out.println("Account balance value has to be positive, please try again: ");
					accBalance = input.nextDouble(); 
				}
				AccManager.createAccount(accNumber, accOwner, accBalance);
			}
			else if (selection == 2)
			{
				AccManager.printAccountBalance();
				while (AccManager.accList.size() > 1)
				{
					System.out.println("Do you want to transfer funds between accounts? "
							+ "\nEnter: \n1. To transfer funds. \n2. To exit to previous menu.");
					int choice = input.nextInt(); 
					if (choice == 1)
					{
						System.out.println("Please choose account from which you want to send funds (enter ordinal number from account)");
						int sourceAccount = input.nextInt(); 
						System.out.println("Please choose destination account to sedn funds (enter ordinal number): ");
						int targetAccount = input.nextInt(); 
						System.out.println("Enter amount to transfer: ");
						double amount = input.nextDouble(); 
						AccManager.transferFunds(sourceAccount, targetAccount, amount);
					}
					else if (choice == 2) break;
					else System.out.println("Please enter valid number!!");
				}
			}
			else if (selection == 3)
			{
				AccManager.printAccountData();
			}
			else if (selection == 4)
			{
				System.out.println("ATM program ends, goodbye.");
				break; 
			}	
			else System.out.println("You have entered wrong program selection.");
		}

	}

}

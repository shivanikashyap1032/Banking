import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class RBI {
	public static void main(String args[]) {
		System.out.println("******************** Welcome TO THE BANK ********************");
		System.out.println("\n");
		System.out.println("Do you want to open an account: 1. YES 2. NO");

		Scanner in = new Scanner(System.in);
		String Choice = in.nextLine() ;

		if (Choice.equalsIgnoreCase("YES")) {
			OpenAccount obj = new OpenAccount();
			obj.CreateAccount();
		}

		if (Choice.equalsIgnoreCase("NO")) {
			BankAccount obj1 = new BankAccount();
			obj1.showMenu();

		}
		else
		{
			System.out.println("Input is Invaild please enter yes or no ");
		}
	}
}

class OpenAccount {
	String name;
	String name2;
	int AccountNumber;
	String AccountType;
	String dob;
	int age;
	String bank;

	void CreateAccount() {
		Scanner in = new Scanner(System.in);

		System.out.println("In which Bank you have a account: 1. SBI 2. PNB 3. ICICI");
		int ChoiceBank = in.nextInt();

		if (ChoiceBank == 1) {
			bank = "SBI";
		}
		if (ChoiceBank == 2) {
			bank = "PNB";
		}
		if (ChoiceBank == 3) {
			bank = "ICICI";
		}
		
		//first name
		System.out.println("Enter you name first name: ");
		in.nextLine();
		name = in.nextLine();
		//Last name
		System.out.println("Enter you name Last name: ");
		name2 = in.nextLine();
		
		//date of birth
		
		System.out.println("Enter your Valid date of birth in format(dd/mm/yyyy): ");
		dob = in.nextLine();
		
		//age
		
	     System.out.println("Enter your age:");
	     age = in.nextInt();
	     
		//enter gender
	    char gender;
	    System.out.printf("Enter gender (M/m or F/f): ");
	    gender = in.next().charAt(0);

	    switch (gender) {
	    case 'M':
	    case 'm':
	      System.out.println("Male.");
	      break;

	    case 'F':
	    case 'f':
	      System.out.println("Female.");
	      break;

	    default:
	      System.out.println("Unspecified Gender.");
	    }
	   // System.out.println("\n");
	
	   // Date which account is open
	  	Calendar cal = Calendar.getInstance();
	    SimpleDateFormat simpleformat = new SimpleDateFormat("E,dd MMM yyyy HH:mm:ss Z");
	    System.out.print("Date and time when account is open = "+simpleformat.format(cal.getTime()));
	    System.out.println("\n");
	   
		System.out.println("Which type account you want to open: 1.Saving 2. Current");
		int Choice = in.nextInt();
		if (Choice == 1) {
			AccountType = "Saving";
		}
		if (Choice == 2) {
			AccountType = "Current";
		}

		System.out.println("Your Account has open with the following details: ");
		System.out.println("Bank;" + bank);
		System.out.println("Name:" + name);
		System.out.println("Name:" + name2);
		System.out.println("Dob:" + dob);
		System.out.println("age:" + age);
		System.out.println("Gender:" + gender);
		System.out.println("open account date :" +simpleformat.format(cal.getTime()));

		System.out.println("Account Type:" + AccountType);
		System.out.println("Account Number:" + Math.random());

		System.out.println("\n");

		BankAccount obj1 = new BankAccount();
		obj1.showMenu();
		in.close();
	}
}
		//////////////// BankAccount 
		class BankAccount {
			int Balance;
			int previousTransaction;
			String CustomerName;
			String CustomerId;
			String accountType;
			double totalInterest;

			void calculateInterest(double Balance) {
				System.out.println("Which type account you want to open: 1. Saving 2. Current");
				Scanner in = new Scanner(System.in);
				int Choice = in.nextInt();

				if (Choice == 1) {
					accountType = "Saving";
					int r = 5;
					int t;
					System.out.println("Enter year to calculate Interest");
					t = in.nextInt();

					double FinalAmount = Balance * (1 + r * t);

					totalInterest = FinalAmount - Balance;
					System.out.println("Total interest is:" + totalInterest);
				}
				if (Choice == 2) {
					accountType = "Current";
					int r = 8;
					int t, n;
					System.out.println("Enter year to calculate interest:");
					t = in.nextInt();
					System.out.println("Enter the frequency that interest has been compound in a year");
					n = in.nextInt();

					double FinalAmount = Balance * (Math.pow((1 + r / n), n * t));
					totalInterest = FinalAmount - Balance;
					System.out.println("Total interest is:" + totalInterest);

				}
			}

			void deposit(int amount) {
				if (amount != 0) {
					Balance = Balance + amount;
					System.out.println("Balance in your account after deposit:" + Balance + "Rs");
					previousTransaction = amount;
				}
			}

			void withdraw(int amount) {
				if (amount != 0) {
					Balance = Balance - amount;
					System.out.println("Balance in your account after deposit:" + Balance +"Rs");
					previousTransaction = -amount;
				}
			}

			void getpreviousTransaction() 
			{
				FileOutputStream out;
				PrintStream p;

				try 
				{
					out = new FileOutputStream("C:\\Users\\Administrator\\eclipse-workspace\\Project_2");
					p = new PrintStream(out);

					if (previousTransaction > 0) {
						p.append("Desposited:" + previousTransaction);
						System.out.println("Desposited:" + previousTransaction);
					} else if (previousTransaction < 0) {
						p.append("Withdrawn:" + previousTransaction);
						System.out.println("Withdrawn:" + Math.abs(previousTransaction));
					} else {
						System.out.println("No Trasaction happend");
					}
					p.close();

				} catch (Exception e) 
				  {
					System.out.println("Error is printing the data" + e);
				  }
			}
			
			void showMenu() 
			{
				BankAccount obj1 = new BankAccount();
				char option = '\0';
				Scanner sc = new Scanner(System.in);
				System.out.println("Welcome to main menu");
				System.out.println("A. Cheack Balance");
				System.out.println("B. Deposit Amount");
				System.out.println("c. Withdraw amount");
				System.out.println("D. See Previous transaction ");
				System.out.println("E. Calculate Interest");
				System.out.println("F. Exit");
				
				do
				{
					System.out.println("************************************");
					System.out.println("Enter an option");
					System.out.println("************************************");
					option = sc.next().charAt(0);
					//System.out.println("\n");
					
					switch (option) 
					{
					case 'A':
					case 'a':	
						System.out.println("----------------------------");
						System.out.println(" Account Balance is ="+	Balance + "Rs");
						System.out.println("\n");
						break;
						
						
					case 'B':
					case 'b':
						System.out.println("----------------------------");
						System.out.println("Enter an amount to deposit:");
						int amount = sc.nextInt();
						deposit(amount);
						System.out.println("\n");
						break;
						
					case 'C':
					case 'c':
						System.out.println("----------------------------");
						System.out.println("Enter an amount to withdraw");
						int amount2 = sc.nextInt();
						withdraw(amount2);
						System.out.println("\n");
						break;
						
					case 'D':
					case 'd':
						System.out.println("----------------------------");
						getpreviousTransaction();
						System.out.println("\n");
						break;
						
					case 'E':
					case 'e':
						System.out.println("----------------------------");
						calculateInterest(Balance);
						System.out.println("\n");
						break;
						
					case 'F':
					case 'f':
						System.out.println("----------------------------");
						break;
					
					default:
						System.out.println("Entered Invaild option!. Please enter Again");
						break;	
					}
				}while(option !='F');
				System.out.println("----Thank you for visting our Bank----");
				sc.close();
				
				System.out.println( " To contact us, email too Bank@123.com");
				
			
				
			}
		

	}



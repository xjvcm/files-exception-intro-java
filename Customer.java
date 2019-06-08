/*
 * Jonathan Manzano
 * 
 * Files and Exceptions
 * 
 * Write a class named Customer.java that has a main() method. 
 * This class provides an “ATM” interface to a set of bank accounts. Use this
 * accounts.dat file to set up the initial set of accounts. Each line of the
 * text file has an account ID, name, and starting balance, separated by colons.
 * Your program must first read the account data file and build an ArrayList of
 * Account objects corresponding to the line. If the file does not exist, your
 * program must output a reasonable error message and then quit.
 * 
 * If the file is read successfully, the program will repeatedly ask for an
 * account number (or ENTER to quit). This is equivalent to inserting an ATM
 * card. Repeat until the account number is valid. Hint: write a method like 
 * this:
 *      public static int findIndex(ArrayList<Account> accountList,
 *          int accountNumber)
 * 
 * This method will go through the accountList and return the index of the 
 * account with the given accountNumber, or -1 if the account number does not
 * belong to any of the accounts in the array.
 * 
 * Print a message that greets the customer by name. Then repeatedly ask the
 * customer if they want to deposit, withdraw, or finish the transactions.
 * 
 *      If the customer wishes to deposit, ask for the amount until you get a 
 *          number greater than or equal to zero; then perform the transaction 
 *          and display the balance. Print an appropriate message for invalid 
 *          input. You must handle exceptions here.
 *      If the customer wishes to withdraw, ask for the amount until you get a
 *          number greater than or equal to zero and less than or equal to the 
 *          current balance; then perform the transaction and display the 
 *          balance. Print an appropriate message for invalid input. You must 
 *          handle exceptions here.
 *      If the customer is finished, print a message to say goodbye to the 
 *          customer, write the entire account array back to disk, and return 
 *          to the account number prompt. (This is equivalent to giving the 
 *          customer their card back).
 * 
 * This program must print all monetary amounts preceded by a dollar sign and 
 *          with two digits after the decimal point. 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
// import java.util.InputMismatchException;
public class Customer {
	/*
	 * A utility method that shows the current balance. I'm giving you this one
	 * for free.
	 */
	public static void showBalance(Account account) {
		System.out.printf("Your current balance is $%.2f\n", account.getBalance());
  }
  /*
	 * Given an Account object (acct) and a string that should contain a number,
	 * this method makes sure the string does contain a number and
	 * is greater than or equal to zero. If all these conditions are met, 
	 * the amount is added to the account balance, and the method calls
	 * showBalance() to display the updated balance. Otherwise, the method
	 * prints an appropriate error message and leaves the acct variable unchanged.
	 */
	public static void doDeposit(Account account, String amountString) {
    // Convert String to int
    int amount = Integer.parseInt(amountString);
    // Handle invalid numbers
    try {
      // Validate string if it only has whole number
      if ((amountString.matches("[0-9]+")) && (amount >= 0)) {
        // deposit amount to account
        account.deposit(amount);
        // invoke showBalance() to display updated balance
        showBalance(account);
      } else {
        // Print error message for negative numbers
        System.out.println("You cannot deposit a negative amount.");
      }
    } catch (NumberFormatException ex) {
      // Print message for handling invalid number exception
      System.out.println(amountString + " is not a valid number.");
    }
	}
	
	/*
	 * Given an Account object (acct) and a string that should contain a number,
	 * this method makes sure the string does contain a number and
	 * is greater than or equal to zero and less than or equal to the account
	 * balance. If all these conditions are met, the amount is subtracted from
	 * the account balance., and the method calls showBalance() to display the
	 * updated balance. Otherwise, the method prints an appropriate error
	 * message and leaves the acct variable unchanged.
	 */
	public static void doWithdrawal(Account account, String amountString) {
		// Convert String to int
    int amount = Integer.parseInt(amountString);
    // Handle invalid numbers
    try {
      // Validate string if it only has whole number
      if ((amountString.matches("[0-9]+")) && (amount >= 0) 
          && amount <= account.getBalance()) {
        // deposit amount to account
        account.withdraw(amount);
        // invoke showBalance() to display updated balance
        showBalance(account);
      } else {
        // Print error message for negative numbers
        System.out.println("You cannot deposit a negative amount.");
      }
    } catch (NumberFormatException ex) {
      // Print message for handling invalid number exception
      System.out.println(amountString + " is not a valid number.");
    }
	}
	
	/*
	 * Given a Scanner that refers to an open account data file, this method
	 * reads the file, and, for each line, splits the fields and creates a new
	 * Account object which is added to an ArrayList<Account>. The method
	 * returns the arraylist.
	 * 
	 * If this method encounters a NumberFormatException, which would be caused
	 * by bad data in the input file, it will print an appropriate error message
	 * and return an empty ArrayList<Account>.
	 */
	public static ArrayList<Account> readAccounts(Scanner fileInput) {
    // Instantiate/declare ArrayList object
    ArrayList<Account> accountList = new ArrayList<>();
    /* Invoke useDelimiter to change the expected pattern 
    Seperators may be colon(:), new line, and/or return characters. */
    fileInput.useDelimiter(":|\n|\r");
		// Read file and create an Array list of Accounts
		while (fileInput.hasNext()) {
			// Move cursor to next line
			if (fileInput.hasNextLine()) {
				fileInput.nextLine();
      }
      try {
        // save data into private data field variables
        int number = fileInput.nextInt();
        String name = fileInput.next();
        double balance = fileInput.nextDouble();
        // creates an account object and add it to account list array of objects
        accountList.add(new Account(number, name, balance));
      } catch (NumberFormatException ex) {
        // print Error message
        System.out.println("Invalid number");
        // Clear array list
        accountList.clear();
        // Return empty list
        return accountList;
      }
    }
		return accountList;
  }
	/*
	 * Given an accountList (an ArrayList<Account>), this method will convert each 
	 * Account to a colon-separated line of text (hint: use toString()) and
	 * write it to file "accounts.dat". If the process encounters any type
	 * of Exception,the method writes an appropriate error message. 
	 */
	public static void writeAccounts(ArrayList<Account> accountList) {
    File file = new File("accounts.dat");
    PrintWriter output = null;
    try {
      output = new PrintWriter(file);
    } catch (FileNotFoundException ex) {
      System.out.println("File does not exist");
    }
    for (Account account: accountList) {
      output.print(account.toString() + "\n");
    }
    output.close();
	}
	/*
	 * Given an accountList (an ArrayList<Account>) and an account number, this 
	 * method will return the index at which the account with the given account 
	 * number was found, or -1 if the account number does not belong to any 
	 * account in the accountList.
	 */
  public static int findIndex(ArrayList<Account> accountList, 
      int accountNumber) {
    // Iterate through the Account List by index
    for (int i = 0; i < accountList.size(); i++) {
      /* If the account's number at index "i" equals to the inputted account
      number then return the index */
      if (accountList.get(i).getNumber() == accountNumber) {
        // return index "i"
        return i;
      }
    }
    // return -1 if no match
    return -1;
  }
  /*
	 * Given an accountList (an ArrayList<Account>) and a string that should contain
	 * an integer account number, this method will validate that the string contains
	 * an integer. If so, it will use findIndex() to return the index at which the
	 * account number was found (which may be -1 if there is no such account number).
	 * 
	 * If the string does not contain a valid integer, the method prints an appropriate
	 * error message and returns -1.
	 */
  public static int getAccountIndex(ArrayList<Account> accountList, 
      String amountString) {
    // Validate string contains only whole numbers
    if (amountString.matches("[0-9]+")) {
      int accountNumber = Integer.parseInt(amountString);
      return findIndex(accountList, accountNumber);
    } else {
      return -1;
    }
	}

	/*
	 * This method takes acct (an Account object) and a Scanner that scans
	 * keyboard input.
	 * 
	 * Your method will repeatedly ask the user to type D to deposit, W to withdraw, or
	 * F to finish their transactions. You must accept the answer in either upper or lower case.
	 * If the input is F, the method finishes looping.
	 * If the input is D, the method calls doDeposit() with the account and the next line of input.
	 * If the input is W, the method calls doWithdrawal() with the account and the next line of input.
	 * 
	 * If the input is not W, D, or F, the method prints an appropriate error message.
	 */
	public static void doTransactions(Account account, Scanner input) {
    // Create empt
    String amountString = "";
    char letter;
    boolean loop = true;
    while (loop) {
      System.out.print("D)eposit, W)ithdraw, or F)inish? ");
      letter = input.next().charAt(0);
      switch (letter) {
        case 'd':
        case 'D':
          System.out.print("Enter amount to deposit: $");
          amountString = input.next();
          doDeposit(account, amountString);
          break;
        case 'w':
        case 'W':
          System.out.print("Enter amount to withdraw: $");
          doWithdrawal(account, amountString);
          break;
        case 'f':
        case 'F':
          System.out.println("Goodbye, " + account.getName() + ".");
          loop = false;
          break;
        default:
          System.out.println("Invalid choice!");
          break;
      }
    }
	}
    public static void main(String[] args) {
    /*
		 * Open the input file accounts.dat.
		 * Create a new Scanner based on this file. If this fails due to a 
		 * FileNotFoundException, the program prints an error message and ends.
		 * Read the accounts from the file to create accountList, an 
		 * ArrayList<Account>
		 * If the size of the list is greater than zero:
		 	* Create a Scanner based on System.in
		 	* Repeatedly do the following:
		 		* Ask for an account number and read a line of input.
		 		* If the user just presses ENTER, the program has finished.
				* Otherwise, use getAccountIndex() to find the index of the 
				* account with the corresponding number.
		 		* If the index is not -1, then:
					* Set a variable named account to the account at the given 
					* index
		 			* Print a "Hello” message that greets the account owner by name.
		 			* Show the current account balance.
		 			* Call doTransactions()
		 			* Call writeAccounts() to write the updated account list to disk
		 			* Print a personalized "Goodbye" message for the account owner
		 * When the program finishes, print a message saying that the ATM program 
     * has concluded.
		 */
		// Create input file object from the local file
		File file = new File("accounts.dat");
		// Instantiate/declare scanner object to stay in main method scope
		Scanner fileInput = null;
		// Handle account.dat missing exception.
		try {
			fileInput = new Scanner(file);
		}
		catch (FileNotFoundException ex) {
			System.out.println("\"accounts.dat\" does not exist");
			System.exit(0);
    }
    // Invoke readAccounts to create account list from file.
    ArrayList<Account> accountList = readAccounts(fileInput);
		// If the size of the list is greater than zero:    
		if (accountList.size() > 0) {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter your account number: ");
			input.nextInt();
      input.close();
    }
  }
}
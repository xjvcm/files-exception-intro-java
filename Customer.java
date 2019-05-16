/**
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
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale;

public class Customer extends Account {

    Customer(int number, String name, double balance) {
        super(number, name, balance);
    }
    public static void main(String[] args) {
        /*
		 * Open the input file accounts.dat.
		 * Create a new Scanner based on this file. If this fails due to a FileNotFoundException,
		 * the program prints an error message and ends.
		 * Read the accounts from the file to create accountList, an ArrayList<Account>
		 * If the size of the list is greater than zero:
		 	* Create a Scanner based on System.in
		 	* Repeatedly do the following:
		 		* Ask for an account number and read a line of input.
		 		* If the user just presses ENTER, the program has finished.
		 		* Otherwise, use getAccountIndex() to find the index of the account with
		 		* the corresponding number.
		 		* If the index is not -1, then:
		 			* Set a variable named account to the account at the given index
		 			* Print a "Hello” message that greets the account owner by name.
		 			* Show the current account balance.
		 			* Call doTransactions()
		 			* Call writeAccounts() to write the updated account list to disk
		 			* Print a personalized "Goodbye" message for the account owner
		 * When the program finishes, print a message saying that the ATM program has concluded.
		 */
		
		// Create input file object from the local file
		File file = new File("accounts.dat");

		// Instantiate/declare scanner object to stay in main method scope
		Scanner input = null;

		// Handle account.dat missing exception
		try {
			input = new Scanner(file);
		}
		catch (FileNotFoundException ex) {
			System.out.println("\"accounts.dat\" does not exist");
			System.exit(0);
		}
		
		
		// Invoke useDelimiter to change the expected pattern
		// Seperators may be colon(:), new line, and/or return characters
		input.useDelimiter(":|\n|\r");

		// Read text file
		int number = input.nextInt();
		System.out.println(number);

		String name = input.next();
		System.out.println(name);

		double balance = input.nextDouble();
		System.out.println(balance);
    }   
}
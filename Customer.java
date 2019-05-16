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

/**
 * Customer
*/
public class Customer {
    public static void main(String[] args) {
        
    }   
}
/**
 * Jonathan Manzano
 * 
 * Files and Exceptions
 * 
 * Create an Account class. An account object has these properties:
 *
 *      int acctNumber: the account number
 *      String name: the account holder’s name
 *      double balance: the current balance in the account
 * 
 * Implement these methods:
 * 
 * public Account(int acct_number, String name, double balance)
 *      The constructor
 * public String toString()
 *      Returns a string giving the account ID, name, and balance, separated by
 *      colons. Do not use format()on the balance; you want to keep the number 
 *      as accurate as possible.
 * public void deposit(double amount)
 *      Adds the given amount to the current balance. If the amount is negative,
 *      the balance must not be changed; otherwise, the balance property is
 *      updated to reflect the deposit
 * public void withdraw(double amount)
 *      Withdraws the given amount from the current balance. If the amount is 
 *      negative or greater than the current balance, the balance must not be 
 *      changed; otherwise, the balance is updated to reflect the withdrawal.
 * 
 * You must also write a getter and setter for the balance, and only a getter 
 * for the name and account number; once the account is constructed, the name 
 * and account number never change.
 * 
 * Note that deposit() and withdraw() do not print error messages if they get
 * incorrect input; they simply ignore it. It is up to the program that calls
 * these functions to provide the error messages for the user of the program.
 */
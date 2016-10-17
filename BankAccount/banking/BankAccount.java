package banking;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccount {

  protected static Scanner sc = new Scanner(System.in);
  protected static DecimalFormat df = new DecimalFormat("#.00");

  private String accountNumber;
  private double balance;
  private String userName;
  private String email;
  private String phoneNumber;

  public BankAccount() {
    System.out.print("\nEnter account number: ");
    this.accountNumber = sc.nextLine();

    Check.decimalNumber(o -> {
      System.out.print("\nEnter initial balance: ");
      this.balance = Double.parseDouble(sc.nextLine());
    });

    System.out.print("\nEnter name: ");
    this.userName = sc.nextLine();

    System.out.print("\nEnter email address: ");
    this.email = sc.nextLine();

    System.out.print("\nEnter phone number: ");
    this.phoneNumber = sc.nextLine();

    showInfo();
  }

  public String getAccountNumber() {
    return this.accountNumber;
  }

  public void showInfo() {
    System.out.println("\nYour basic account information is:");
    System.out.println("Account number: " + this.accountNumber);
    System.out.println("Current balance: " + df.format(this.balance));
    System.out.println("Account owner: " + this.userName);
    System.out.println("Your email: " + this.email);
    System.out.println("Your phone Number: " + this.phoneNumber);
  }

  public void listChoices() {
    System.out.println();
    System.out.println("1. Deposit");
    System.out.println("2. Withdrawal");
  }

  public double getBalance() {
    return this.balance;
  }

  public void addBalance(double depositValue) {
    this.balance += depositValue;
    System.out.println("\nYour Current Balance is: $" + this.balance);
  }

  public void subtractBalance(double withdrawalValue) {
    if (this.balance >= withdrawalValue) {
      this.balance -= withdrawalValue;
      System.out.println("\nYour current Balance is: $" + this.balance);
    } else {
      System.out.println("\nYou balance it too low for that withdrawal amount");
    }

  }
  
}

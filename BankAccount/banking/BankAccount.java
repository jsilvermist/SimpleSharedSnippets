package banking;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BankAccount {

  protected static final Scanner sc = new Scanner(System.in);
  protected static final DecimalFormat df = new DecimalFormat("#.00");

  private String accountNumber;
  private double balance;
  private String userName;
  private String email;
  private String phoneNumber;

  public BankAccount() {
    System.out.print("\nEnter account number: ");
    this.accountNumber = sc.nextLine();

    Banking.tryLoop(o -> {
      System.out.print("\nEnter initial balance: ");
      this.balance = Double.parseDouble(sc.nextLine());
    });

    System.out.print("\nEnter name: ");
    this.userName = sc.nextLine();

    System.out.print("\nEnter email address: ");
    this.email = sc.nextLine();

    System.out.print("\nEnter phone number: ");
    this.phoneNumber = sc.nextLine();

    // To refactor
    if (!(this instanceof VipBankAccount)) {
      showInfo();
    }
  }

  public void showInfo() {
    System.out.println("\nYour account information is:");
    System.out.println("Account number: " + this.accountNumber);
    System.out.println("Current balance: $" + df.format(this.balance));
    System.out.println("Account owner: " + this.userName);
    System.out.println("Your email: " + this.email);
    System.out.println("Your phone Number: " + this.phoneNumber);
  }

  public void listChoices() {
    System.out.println("\n" + getSummary() + "\n");
    System.out.println("1. View Information");
    System.out.println("2. Deposit");
    System.out.println("3. Withdrawal");
  }

  public String getSummary() {
    return "Account number: " + this.accountNumber + "\tBalance: $" + df.format(this.balance);
  }

  public void manage() {
    while (true) {
      listChoices();
      System.out.println("0. Back");

      try {

        System.out.print("\nEnter your choice: ");
        int choiceInt = Integer.parseInt(sc.nextLine());

        switch (choiceInt) {
          case 1:
            showInfo();
            break;
          case 2:
            addBalance();
            break;
          case 3:
            subtractBalance();
            break;
          case 0:
            return;
          default:
            throw new Exception();
        }

      } catch (Exception e) {
        System.out.println(Banking.errorString);
      }
    }
  }

  public void addBalance() {
    try {

      System.out.println("\nYour current balance is: $" + this.balance);
      System.out.println("Enter the ammount you wish to deposit: ");
      this.balance += Double.parseDouble(sc.nextLine());

      System.out.println("\nYour new balance is: $" + this.balance);
      System.out.println("Press enter to continue...");
      sc.nextLine();

    } catch (Exception e) {
      System.out.println(Banking.errorString);
    }
  }

  public void subtractBalance() {
    try {

      System.out.println("\nYour current balance is: $" + this.balance);
      System.out.println("Enter the ammount you wish to withdrawal: ");
      double value = Double.parseDouble(sc.nextLine());

      if (this.balance >= value) {
        this.balance -= value;
        System.out.println("\nYour new balance is: $" + this.balance);
      } else {
        System.out.println("\nYour balance is too low for that withdrawal amount.");
      }

      System.out.println("\nYour current balance is: $" + this.balance);
      System.out.println("Press enter to continue...");
      sc.nextLine();

    } catch (Exception e) {
      System.out.println(Banking.errorString);
    }
  }
  
}

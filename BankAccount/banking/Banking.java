package banking;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banking {

  public static Scanner sc = new Scanner(System.in);
  public static DecimalFormat df = new DecimalFormat("#.00");
  public static List<BankAccount> accounts = new ArrayList<>();
  public static String errorString = "Invalid input, please try again.";
  
  public static void main(String[] args) {

    int choiceInt;

    while(true) {
      showChoices();

      while (true) {
        System.out.print("\nEnter your choice: ");

        try {
          choiceInt = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
          System.out.println(errorString);
          continue;
        }
        break;
      }

      int offset = 3;
      if (choiceInt >= offset && choiceInt < (accounts.size()+offset)) {
        accounts.get(choiceInt-offset).showInfo();
        continue;
      }

      switch (choiceInt) {
        case 1:
          createAccount();
          break;
        case 2:
          manageAccounts();
          break;
        case 0:
          exit();
          break;
        default:
          System.out.println(errorString);
          break;
      }
    }
  }

  public static void showChoices() {
    System.out.println("\n--------------------");
    int numAccts = accounts.size();
    if (numAccts == 0) {
      System.out.println("\nYou have no accounts, please create an account to get started...");
    } else {
      System.out.println("\nYou have " + numAccts + " account" + (numAccts>1?"s":"") + ".");
    }
    System.out.println();
    System.out.println("1. Create a new account");
    System.out.println("2. List all accounts");

    int offset = 3;
    for (BankAccount account : accounts) {
      System.out.println(offset + ". Account number: " + account.getAccountNumber() + "\tBalance: " +
          df.format(account.getBalance()));
      offset++;
    }

    System.out.println("0. Exit");
  }

  public static void createAccount() {
    System.out.print("\nDo you want to create a regular or VIP account? [R for Regular, V for VIP] ");
    String choice = sc.nextLine();

    if (choice.length() <= 0) {
      System.out.println(errorString);
      return;
    }

    switch (choice.toLowerCase().charAt(0)) {
      case 'r':
        accounts.add(new BankAccount());
        return;
      case 'v':
        accounts.add(new VipBankAccount());
        return;
      default:
        System.out.println(errorString);
        break;
    }
  }

  public static void manageAccounts() {
    if (!showAccounts()) {
      return;
    }

    System.out.print("\nSelect an account for more options, or type 0 to go back. ");
    int choice = Integer.parseInt(sc.nextLine());
    // Add error for greater than accounts.size()
    if (choice > 0 && choice <= accounts.size()) {
      accounts.get(choice-1).showInfo();
    } else {
      return;
    }
  }

  public static boolean showAccounts() {
    if (accounts.size() == 0) {
      return false;
    }

    System.out.println("\nAll accounts:");

    int i = 1;
    for (BankAccount account : accounts) {
      System.out.println(i + ". Account number: " + account.getAccountNumber() + "\tBalance: " +
          df.format(account.getBalance()));
      i++;
    }

    return true;
  }

  public static void exit() {
    System.out.print("\nDo you really want to exit? [Y/N] ");
    String choice = sc.nextLine();

    if (choice.toLowerCase().charAt(0) == 'y') {
      sc.close();
      System.exit(0);
    }
  }

}

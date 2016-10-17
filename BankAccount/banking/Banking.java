package banking;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banking {

  public static Scanner sc = new Scanner(System.in);
  public static DecimalFormat df = new DecimalFormat("#.00");
  public static List<BankAccount> accounts = new ArrayList<BankAccount>();
  
  public static void main(String[] args) {

    while(true) {
      listChoices();
      System.out.print("\nEnter your choice: ");
      int choiceInt = Integer.parseInt(sc.nextLine());

      switch (choiceInt) {
        case 1:
          createAccount();
          break;
        case 2:
          listAccounts();
          break;
        case 0:
          exit();
          break;
        default:
          System.out.println("\nInvalid input, please try again.");
          break;
      }
    }
  }

  public static void listChoices() {
    int numAccts = accounts.size();
    if (numAccts == 0) {
      System.out.println("\nYou have no accounts, please create an account to get started...");
    } else {
      System.out.println("\nYou have " + numAccts + " account" + (numAccts>1?"s":"") + ".");
    }
    System.out.println();
    System.out.println("1. Create a new account");
    System.out.println("2. List all accounts");
    System.out.println("0. Exit");
  }

  public static void createAccount() {
    System.out.print("\nDo you want to create a regular or VIP account? [R for Regular, V for VIP] ");
    String choice = sc.nextLine();

    switch (choice.toLowerCase().charAt(0)) {
      case 'r':
        accounts.add(new BankAccount());
        return;
      case 'v':
        accounts.add(new VipBankAccount());
        return;
      default:
        System.out.println("\nInvalid input, please try again.");
        break;
    }
  }

  public static void listAccounts() {
    if (accounts.size() == 0) {
      return;
    }

    System.out.println("\nAll accounts:");

    int i = 1;
    for (BankAccount account : accounts) {
      System.out.println(i + ".\tAccount: " + account.getAccountNumber() + "\tBalance: " +
          df.format(account.getBalance()));
      i++;
    }

    System.out.print("\nSelect an account for more options, or type 0 to go back. ");
    int choice = Integer.parseInt(sc.nextLine());
    if (choice > 0) {
      viewAccountInfo(accounts.get(choice-1));
    } else {
      return;
    }
  }

  // Example only, will override basicInfo as viewInfo
  public static void viewAccountInfo(BankAccount account) {
    account.basicInfo();
    if (account instanceof VipBankAccount) {
      VipBankAccount vipAccount = (VipBankAccount) account;
      vipAccount.vipInfo();
    }
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

package banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Banking {

  public static final Scanner sc = new Scanner(System.in);
  public static final List<BankAccount> accounts = new ArrayList<>();
  public static final String errorString = "Invalid input, please try again.";
  
  public static void main(String[] args) {

    while(true) {

      int choiceInt;

      showChoices();

      while (true) {
        System.out.print("\nEnter your choice: ");

        try {
          choiceInt = Integer.parseInt(sc.nextLine());

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
              throw new Exception();
          }

        } catch (Exception e) {
          System.out.println(errorString);
          continue;
        }
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
    System.out.println("2. Manage accounts");
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

    while (true) {
      System.out.print("\nEnter your choice: ");

      try {

        int choice = Integer.parseInt(sc.nextLine());

        if (choice > 0 && choice <= accounts.size()) {
          accounts.get(choice-1).manage();
          showAccounts();
        } else if (choice == 0) {
          return;
        } else {
          throw new Exception();
        }

      } catch (Exception e) {
        System.out.println(errorString);
      }
    }
  }

  public static boolean showAccounts() {
    if (accounts.size() == 0) {
      return false;
    }

    System.out.println("\nSelect an account for more options, or type 0 to go back.\n");

    int i = 1;
    for (BankAccount account : accounts) {
      System.out.println(i + ". " + account.getSummary());
      i++;
    }

    System.out.println("0. Back");

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

  public static void tryLoop(Consumer<Object> consumer) {
    while (true) {
      try {
        consumer.accept(new Object());
      } catch (Exception e) {
        System.out.println(Banking.errorString);
        continue;
      }
      break;
    }
  }

}

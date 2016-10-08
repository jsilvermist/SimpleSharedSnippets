import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BankAccount {

  private String name;
  private double balance;

  BankAccount(String name, double balance) {

    this.name = name;
    this.balance = balance;

  }

  public void printInfo() {

    System.out.println("Account name: " + this.name + ", total balance: " + this.balance);

  }

}

public class BankAccounts {
  
  public static void main(String[] args) {
    
    System.out.print("Create multiple accounts? (Y/N) ");
    System.out.println();

    Scanner sc = new Scanner(System.in);
    String choice = sc.nextLine();

    if (choice.toLowerCase().charAt(0) == 'y') {

      List<BankAccount> accounts = new ArrayList<BankAccount>();

      boolean createMultipleAccounts = true;

      while (createMultipleAccounts) {

        System.out.print("Type your account name: ");
        String name = sc.nextLine();

        System.out.print("Type initial deposit balance: ");
        double balance = Double.parseDouble(sc.nextLine()); // Double.valueOf();

        accounts.add(new BankAccount(name, balance));

        System.out.print("Would you like to add another account? (Y/N) ");
        choice = sc.nextLine();
        if (choice.toLowerCase().charAt(0) != 'y') {
          createMultipleAccounts = false; // OR break;
        }

        System.out.println();

      }

      System.out.println("Account names and balances:");
      for (int i = 0; i < accounts.size(); i++) {
        accounts.get(i).printInfo();
      }

    } else {

      System.out.println("Exiting Program");

    }

    sc.close();

  }

}

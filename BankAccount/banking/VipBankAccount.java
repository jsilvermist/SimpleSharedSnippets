package banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VipBankAccount extends BankAccount {

  private double creditAmount;
  private double interestRate;

  public VipBankAccount() {
    super();

    Check.decimalNumber(o -> {
      System.out.print("\nEnter eligible credit amount: ");
      this.creditAmount = Double.parseDouble(sc.nextLine());
    });

    Check.decimalNumber(o -> {
      System.out.print("\nEnter monthly interest rate: ");
      this.interestRate = Double.parseDouble(sc.nextLine());
    });

    showInfo();
  }

  public void listChoices() {
    super.listChoices();
    System.out.println("3. Get loan on credit");
  }

  public void showInfo() {
    super.showInfo();
    
    System.out.println("\nYour VIP account information is:");
    System.out.println("Eligible credit amount: " + df.format(this.creditAmount));
    System.out.println("Monthly interest rate: " + df.format(this.interestRate));
  }

}

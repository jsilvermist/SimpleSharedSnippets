package banking;

public class VipBankAccount extends BankAccount {

  private double creditAmount;
  private double interestRate;

  public VipBankAccount() {
    super();

    Banking.tryLoop(o -> {
      System.out.print("\nEnter eligible credit amount: ");
      this.creditAmount = Double.parseDouble(sc.nextLine());
    });

    Banking.tryLoop(o -> {
      System.out.print("\nEnter monthly interest rate: ");
      this.interestRate = Double.parseDouble(sc.nextLine());
    });

    showInfo();
  }

  @Override
  public void showInfo() {
    super.showInfo();
    
    System.out.println("Eligible credit amount: $" + df.format(this.creditAmount));
    System.out.println("Monthly interest rate: " + df.format(this.interestRate) + "%");
  }

  @Override
  public void listChoices() {
    super.listChoices();

    System.out.println("4. Get loan on credit (Not yet implemented)");
  }

  @Override
  public String getSummary() {
    return super.getSummary() + "\t(VIP)";
  }

}

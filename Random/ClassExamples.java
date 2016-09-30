class ExampleNewClass {

  int number;

  ExampleNewClass(int number) {
    this.number = number;
  }

  public int plusTwo() {
    return (number + 2);
  }

}

public class ClassExamples {

  public static void main(String[] args) {
    
    ExampleNewClass withThree = new ExampleNewClass(3);

    ExampleNewClass withFive = new ExampleNewClass(5);

    System.out.println("withThree.plusTwo == " + withThree.plusTwo());

    System.out.println("withFive.plusTwo == " + withFive.plusTwo());

  }

}

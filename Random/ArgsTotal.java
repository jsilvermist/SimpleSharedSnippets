public class ArgsTotal {

  public static void main(String[] args) {

    if (args.length != 0) {

      int[] intArr = new int[args.length];

      for (int i = 0; i < args.length; i++) {
        intArr[i] = Integer.parseInt(args[i]);
      }

      int total = 0;

      for (int i = 0; i < intArr.length; i++) {
        total += intArr[i];
      }

      System.out.println("Total combined value of args is " + total + ".");

    } else {

      System.out.println("No arguements passed.");

    }

  }

}

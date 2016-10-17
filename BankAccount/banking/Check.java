package banking;

import java.util.Scanner;
import java.util.function.Consumer;

class Check {

  public static String genericString = "Invalid input, please try again.";
  public static String wholeNumberString = "Invalid entry, please enter a whole number.";
  public static String decimalNumberString = "Invalid entry, please enter a (decimal) number.";

  public static void generic(Consumer<Object> consumer) {
    while (true) {
      try {
        consumer.accept(new Object());
      } catch (Exception e) {
        System.out.println(genericString);
        continue;
      }
      break;
    }
  }

  public static void wholeNumber(Consumer<Object> consumer) {
    while (true) {
      try {
        consumer.accept(new Object());
      } catch (Exception e) {
        System.out.println(wholeNumberString);
        continue;
      }
      break;
    }
  }

  public static void decimalNumber(Consumer<Object> consumer) {
    while (true) {
      try {
        consumer.accept(new Object());
      } catch (Exception e) {
        System.out.println(decimalNumberString);
        continue;
      }
      break;
    }
  }

}

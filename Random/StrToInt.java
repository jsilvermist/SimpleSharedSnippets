public class StrToInt {

  public static void main(String[] args) {

    String[] strArr = {"3", "1", "4", "1", "5"};

    int[] intArr = new int[strArr.length];

    for (int i = 0; i < strArr.length; i++) {
      intArr[i] = Integer.parseInt(strArr[i]);
      System.out.println(intArr[i]);
    }

  }

}

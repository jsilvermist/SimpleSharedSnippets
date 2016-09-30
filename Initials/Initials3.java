import java.util.Scanner;

public class Initials3 {

    public static void main(String[] args) {

        printInitials();

    }

    public static void printInitials() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Please type your full name: ");
        String fullName = sc.nextLine();

        System.out.println("Your initials are: " + getInitials(fullName));

        sc.close();

    }

    public static String getInitials(String fullName) {

        char[] chars = fullName.toCharArray();
        String initials = "";
        boolean newWord = true;

        for (int i = 0; i < chars.length; i++) {

            if (newWord && Character.isLetter(chars[i])) {
                initials += String.valueOf(chars[i]).toUpperCase() + " ";
                newWord = false;
            } else if (Character.isWhitespace(chars[i]) || chars[i] == '.') {
                newWord = true;
            }

        }

        return initials;

    }

}

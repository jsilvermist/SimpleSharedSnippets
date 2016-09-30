import java.util.Scanner;

public class Initials5 {

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

        String initials = "";
        boolean newWord = true; // true if at beginning of string, or after space

        for (int i = 0; i < fullName.length(); i++) {

            if (newWord && Character.isLetter(fullName.charAt(i))) {

                initials += fullName.substring(i,i+1).toUpperCase() + " ";
                // initials += String.valueOf(fullName.charAt(i)).toUpperCase() + " ";

                newWord = false;

            } else if (Character.isWhitespace(fullName.charAt(i))) {

                newWord = true;

            }

        }

        return initials;

    }

}

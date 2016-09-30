import java.util.*;

public class Initials2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please Type in your first name: ");
        String firstName = sc.nextLine();
        System.out.println("Please Type in your last name ");
        String lastName = sc.nextLine();

        printInitials(firstName, lastName);

        sc.close();

    }

    public static void printInitials(String firstName, String lastName) {

        String firstInitial = firstName.substring(0,1);
        String secondInitial = lastName.substring(0,1);
        System.out.println("Your initials are: " + firstInitial + secondInitial);

    }

    public static String getInitials(String string) {

        char[] chars = string.toLowerCase().toCharArray();
        List<Character> initials = new ArrayList<Character>();
        boolean newWord = true;

        for (int i = 0; i < chars.length; i++) {

            if (newWord && Character.isLetter(chars[i])) {
                chars[i] = initials.push(chars[i]);
                newWord = false;
            } else if (Character.isWhitespace(chars[i]) || chars[i] == '.') {
                newWord = true;
            }

        }

        return String.valueOf(chars);

    }

}

// INCOMPLETE

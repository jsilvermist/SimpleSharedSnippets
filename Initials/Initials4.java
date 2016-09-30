import java.util.Scanner;

public class Initials4 {

    public static void outputInitials(String fullName) {

        String initials = fullName.replaceAll("(?<=\\w)\\w+", "").toUpperCase();

        System.out.println("Your initials are: " + initials);

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your full name: ");
        String fullName = input.nextLine();
        
        outputInitials(fullName);

        input.close();

    }

}

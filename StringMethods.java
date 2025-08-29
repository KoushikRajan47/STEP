import java.util.Scanner;
public class StringMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your full name : ");
        String fullName = scanner.nextLine();

        System.out.print("Enter your favorite programming language: ");
        String favLang = scanner.nextLine();

        System.out.print("Write a sentence about your programming experience: ");
        String experience = scanner.nextLine();

        int spaceIndex = fullName.indexOf(" ");

        String firstName = fullName.substring(0, spaceIndex); // from 0 to space
        String lastName = fullName.substring(spaceIndex + 1); // from after space to end


        String withoutSpaces = experience.replace(" ", "");
        int charCount = withoutSpaces.length();

        String favLangUpper = favLang.toUpperCase();

      
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Favorite Language (Uppercase): " + favLangUpper);
        System.out.println("Programming Experience: " + experience);
        System.out.println("Character count in sentence (excluding spaces): " + charCount);

        scanner.close();
    }
}

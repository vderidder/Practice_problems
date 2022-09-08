package Caesar_cipher;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Task_1
{
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println(
                """
                -------
                1. Encrypt
                2. Decrypt
                -------
                Enter choice:\s
                """
        );
        int choice = input.nextInt();
        input.nextLine(); // Filler line

        if(choice == 1)
        {
            encryptText();
        }
        else if (choice == 2)
        {
            decryptText();
        }
    }

    private static void encryptText()
    {
        System.out.println("Enter Text: ");
        String text = input.nextLine();
        System.out.println("Enter Key: "); // the key to how the text has moved
        int key_num = input.nextInt();
        input.nextLine();
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder coded_message = new StringBuilder();
        char character = ' '; // the character that will be added to build the coded message
        for(int i = 0; i < text.length(); i++) // runs through the text
        {
            if(text.charAt(i) != ' ') // checks if it's a space
            {
                for(int x = 0; x < abs(key_num); x++)  // runs for the absolute int value of the key
                {
                    if(lowerCase.contains(text.substring(i,i+1))) // checks if the letter is lower case
                    {
                        int lowerFinalIndex = lowerCase.indexOf(text.substring(i,i+1)) + key_num; // variable for the position of the letter in the alphabet
                        if(lowerFinalIndex > 25) {lowerFinalIndex = lowerFinalIndex - 26;} // overflow management tool for when it goes behind 'a'
                        else if(lowerFinalIndex < 0){lowerFinalIndex = 26 + lowerFinalIndex;} // overflow management tool for when it goes beyond 'z'
                        character = (lowerCase.charAt(lowerFinalIndex)); // sets the encrypted character of the final coded message
                    }
                    else if(upperCase.contains(text.substring(i,i+1))) // checks if the letter is upper case
                    {
                        int upperFinalIndex = upperCase.indexOf(text.substring(i,i+1)) + key_num; // variable for the position of the letter in the alphabet
                        if(upperFinalIndex > 25) {upperFinalIndex = upperFinalIndex - 26;} // overflow management tool for when it goes behind 'a'
                        else if(upperFinalIndex < 0){upperFinalIndex = 26 + upperFinalIndex;} // overflow management tool for when it goes beyond 'z'
                        character = (upperCase.charAt(upperFinalIndex)); // sets the encrypted character of the final coded message
                    }
                }
                coded_message.append(character); // adds the encrypted character to the final message
            }
            else
            {
                coded_message.append(" "); // adds a space when recognized in the text that there is one
            }
        }
        System.out.println(" ");
        System.out.println("Encrypted Message: " + coded_message);
    }

    private static void decryptText()
    {
        System.out.println("Enter encrypted text: ");
        String encrypted_text = input.nextLine();
        System.out.println("Enter Key: "); // the key to how the text has moved
        int key_num = input.nextInt();
        input.nextLine();
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder decrypted_message = new StringBuilder();
        char character = ' '; // the character that will be added to build the decrypted message
        for(int i = 0; i < encrypted_text.length(); i++) // runs through the text
        {
            if(encrypted_text.charAt(i) != ' ') // checks if it's a space
            {
                for(int x = 0; x < abs(key_num); x++) // runs for the absolute int value of the key
                {
                    if(lowerCase.contains(encrypted_text.substring(i,i+1)))
                    {
                        int lowerFinalIndex = lowerCase.indexOf(encrypted_text.substring(i,i+1)) - key_num; // variable for the position of the letter in the alphabet
                        if(lowerFinalIndex > 25) {lowerFinalIndex = lowerFinalIndex + 26;} // overflow management tool for when it goes behind 'a'
                        else if(lowerFinalIndex < 0){lowerFinalIndex = 26 - lowerFinalIndex;} // overflow management tool for when it goes beyond 'z'
                        character = (lowerCase.charAt(lowerFinalIndex)); // sets the decrypted character of the final message
                    }
                    else if(upperCase.contains(encrypted_text.substring(i,i+1)))
                    {
                        int upperFinalIndex = upperCase.indexOf(encrypted_text.substring(i,i+1)) - key_num; // variable for the position of the letter in the alphabet
                        if(upperFinalIndex > 25) {upperFinalIndex = upperFinalIndex + 26;} // overflow management tool for when it goes behind 'a'
                        else if(upperFinalIndex < 0){upperFinalIndex = 26 - upperFinalIndex;} // overflow management tool for when it goes beyond 'z'
                        character = (upperCase.charAt(upperFinalIndex)); // sets the decrypted character of the final message
                    }
                }
                decrypted_message.append(character); // adds the decrypted character to the final message
            }
            else
            {
                decrypted_message.append(" "); // adds a space when recognized in the text that there is one
            }
        }
        System.out.println(" ");
        System.out.println("Decrypted Message: " + decrypted_message);

    }
}

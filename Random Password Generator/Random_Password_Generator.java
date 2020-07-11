/**
 * This program acts as a random password generator. 
 * It ensures that each password includes at least one lower case, upper case, symbol, and number in each password.
 * 
 * @author Anthony Martino
 * @version July 11, 2020
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Random_Password_Generator 
{

	/** This is the main method */
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter desired password length: ");
		int length = input.nextInt();
		while(length <= 4)
		{
			System.out.println("Password too short. Please enter a length longer than 4.");
			length = input.nextInt();
		}
		input.nextLine();

		System.out.print("What is this password for?: ");
		String passFor = input.nextLine();

		String result = makePassword(length);
		System.out.println(result);
		input.close();

		File fileName = new File("rPass.txt");

		try{
			PrintWriter outputStream = new PrintWriter(new FileWriter(fileName, true));
			outputStream.append(passFor + " - " + result + "\n");
			outputStream.close();
		} catch(IOException e) {
			e.printStackTrace();
			}
	}

	/**
	 * This function picks a random character from a string of any length.
	 * 
	 * @param characters - This is the string of which the random charactor is chosen from.
	 * @return String - Returns the random charactor as a string.
	 */
	public static String randomCharacter(String characters) 
	{
		int n = characters.length();
		int r = (int) (n * Math.random());
		return characters.substring(r, r + 1);
	}

	/**
	 * This function takes two strings and randomly inserts one into the other.
	 * 
	 * @param str - The first string.
	 * @param toInsert - The second string to be inserted into the first string.
	 * @return String - Returns both strings as one.
	 */
	public static String insertAtRandom(String str, String toInsert) 
	{
		int n = str.length();
		int r = (int) ((n + 1) * Math.random());
		return str.substring(0, r) + toInsert + str.substring(r);

	}

	/**
	 * This function creates the actual full length random password.
	 * @param length - The length of the requested password.
	 * @return String password - Returns the random password.
	 */
	public static String makePassword(int length) 
	{
		String password = "";

		for (int i = 0; i < length - 4; i++) 
			password += randomCharacter("abcdefghijklmopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ]0123456789+-*/?!@#$%&_()^{}[]:;><");

		String randomCap = randomCharacter("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		password = insertAtRandom(password, randomCap);
		String randomLow = randomCharacter("abcdefghijklmnopqrstuvwxyz");
		password = insertAtRandom(password, randomLow);
		String randomDigit = randomCharacter("0123456789");
		password = insertAtRandom(password, randomDigit);
		String randomSymbol = randomCharacter("+-*/?!@#$%&_()^{}[]:;><");
		password = insertAtRandom(password, randomSymbol);


		System.out.println("Generating a random password... ");
		System.out.println();
		System.out.print("Your random password is: ");
		return password;
	}
}

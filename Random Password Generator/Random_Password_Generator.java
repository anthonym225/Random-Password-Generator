import java.io.*;
import java.util.Scanner; //Imports scanner for user input
public class Random_Password_Generator {

	public static String makePassword(int length) {
		String password = "";

		for (int i = 0; i < length - 2; i++) {
			password = password + randomCharacter("abcdefghijklmopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "+-*/?!@#$%&_()^{}[]:;><");
	}

		String randomDigit = randomCharacter("0123456789");
		password = insertAtRandom(password, randomDigit);
		String randomSymbol = randomCharacter("+-*/?!@#$%&_()^{}[]:;><");
		password = insertAtRandom(password, randomSymbol);


		System.out.println("Generating a random password... ");
		System.out.println();
		System.out.print("Your random password is: ");
		return password;
}
		/**
    Get random character from string
 		*/
	public static String randomCharacter(String characters) {
		int n = characters.length();
		int r = (int) (n * Math.random());
		return characters.substring(r, r + 1);
	}
	/**
	Inserts one string into another at a random position
 	*/
	public static String insertAtRandom(String str, String toInsert) {
		int n = str.length();
		int r = (int) ((n  + 1) * Math.random());
		return str.substring(0, r) + toInsert + str.substring(r);

	}

	/**
	Generate password
	*/
	public static void main(String[] args) {

		/**
		Ask user how many characters they would like password to be
		*/

		Scanner input = new Scanner(System.in);
		System.out.println("Enter desired password length: ");
		int i = input.nextInt();
		input.nextLine();

		System.out.println("What is this password for?: ");
		String passFor = input.nextLine();

		String result = makePassword(i);
		System.out.println(result);
		input.close();

		File fileName = new File ("rPass.txt");
		try{
			PrintWriter outputStream = new PrintWriter(new FileWriter(fileName, true));
			outputStream.append(result + " - " + passFor + "\n");
			outputStream.close();
		} catch(IOException e) {
			e.printStackTrace();
			}
	}


}

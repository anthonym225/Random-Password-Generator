/**
Random Password Generator: Lower, Upper, Symbol.
@auth Anthony Martino
**/

public class Random_Password_Generator {
/**
	Generate password
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String result = makePassword(12);
		System.out.println(result);
	}
	public static String makePassword(int length) {
		String password = "";

		for (int i = 0; i < length - 3; i++) {
			password = password + randomCharacter("abcdefghijklmopqrstuvwxyz");
	}

	String randomDigit = randomCharacter("0123456789");
	password = insertAtRandom(password, randomDigit);
	String randomSymbol = randomCharacter("+-*/?!@#$%&_");
	password = insertAtRandom(password, randomSymbol);
	String randomUpper = randomCharacter("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	password = insertAtRandom(password, randomUpper);
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
	Insert one string into another at a random position
 */
	public static String insertAtRandom(String str, String toInsert) {
		int n = str.length();
		int r = (int) ((n  + 1) * Math.random());
		return str.substring(0, r) + toInsert + str.substring(r);

	}
}

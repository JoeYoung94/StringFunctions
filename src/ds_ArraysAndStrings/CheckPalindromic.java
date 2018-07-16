package ds_ArraysAndStrings;

import java.util.Scanner;

/**
 * 
 * @author Joe Yang
 * This Class is to determine whether a string is palindromic
 * 
 * It checks the first i and the last i characters. Whether they are equal
 * 
 * the time complexity is O(n)
 * the space complexity is O(1)
 *
 */
public class CheckPalindromic {

	public static void main(String[] args) {
		// the Scanner that gets the string input
		Scanner scanner = new Scanner(System.in);
		String myString = scanner.next();
		scanner.close();
		
		// the return result which determines whether the string is palindromic
		boolean result = false;
		
		// Determine the result
		result = checkPalindromic(myString);
		
		if(result == false) {
			System.out.println("Not Palindromic");
		}else {
			System.out.println("Is Palindromic");
		}

	}

	
	/**
	 * 
	 * @param the input string
	 * @return the result of true or false to determine whether the string is palindromic
	 */
	private static boolean checkPalindromic(String myString) {
		for(int i = 0; i < myString.length(); i++) {
			if(myString.charAt(i) != myString.charAt(myString.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}

}

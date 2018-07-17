package ds_ArraysAndStrings;

import java.util.Scanner;

/**
 * 
 * @author yunqiaoyang
 * 
 * String Compression: like aaabbbbbccc -> a3b5c3. If the compressed string would not become smaller 
 * than the original string, then return the original string
 *
 */

public class StringCompression {

	public static void main(String[] args) {
		// the Scanner that gets the string input
		Scanner scanner = new Scanner(System.in);
		String myString = scanner.next();
		scanner.close();
		
		// the result return string
		String result = "";
		
		result = Compression2(myString);
		
		System.out.println(result);
	}

	/**
	 * StringBuilder Solution
	 * @param myString
	 * @return
	 */
	private static String Compression2(String myString) {
		StringBuilder compressed = new StringBuilder();
		
		int appearTimes = 0;
		
		for(int i = 0; i < myString.length(); i++) {
			appearTimes++;
			
			if(i + 1 >= myString.length() || myString.charAt(i) != myString.charAt(i + 1)) {
				compressed.append(myString.charAt(i));
				compressed.append(appearTimes);
				appearTimes = 0;
			}
		}
		return compressed.length() < myString.length() ? compressed.toString() : myString;
	}

	/**
	 * 
	 * @param myString
	 * @return the result of compressed string if the length of the compressed string is less than the 
	 * original one, or return the original one if they have the same length.
	 * 
	 * It's a better solution to use StringBuilder
	 */
	private static String Compression(String myString) {
		
		String result = "";
		
		// this parameter is used to record the  of a specific character 
		int appearTimes = 0;
		
		for(int i = 0; i < myString.length(); i++) {
			appearTimes++;
			
			// if the next character is different that current, append this char to result
			if(i + 1 >= myString.length() || myString.charAt(i) != myString.charAt(i + 1)) {
				// when add a new substring the "" is needed
				result += "" + myString.charAt(i) + appearTimes;
				appearTimes = 0;
			}
		}
		return result.length() < myString.length() ? result : myString;
	}

}

package ds_ArraysAndStrings;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author Joe Yang
 * 
 * This Class is used for determine whether there is duplicated character in a string.
 * The data structure used here is hash map
 * 
 * The time complexity is O(n)
 * The space complexity is O(1)
 * 
 * If we are not allowed to use the extra data structure, firstly we should ensure whether the string
 * contains all ASCLL codes. If no,for each character in the string, we can use char_set[i] to determine
 * the result. If yes, we can use the ASCLL characters to solve this problem
 *
 */

public class IsUnique {

	
	// Implement an algorithm to determine if a string has all unique characters. What if you cannot
	// use additional data structures?
	
	
	public static void main(String[] args) {
		
		// the Scanner that gets the string input
		Scanner scanner = new Scanner(System.in);
		String myString = scanner.next();
		scanner.close();
		
		// the return result which determines whether the string has all unique characters
		boolean result = false;
		
		// Determine the result
		result = determineUnique(myString);
		
		if(result == false) {
			System.out.println("Not Unique");
		}else {
			System.out.println("Is Unique");
		}

	}

	/**
	 * 
	 * @param The input string to be determined
	 * @return true or false if the string contains all unique characters
	 */
	private static boolean determineUnique(String myString) {
		HashMap<Character, Integer> table = new HashMap<Character, Integer>();
		
		// Initialize the hash map first according to the string
		table = tableInit(myString);
		
		for(HashMap.Entry<Character, Integer> entry : table.entrySet()) {
			int value = entry.getValue();
			if(value > 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param the input string to be determined
	 * @return the hash map. In the map the character acts as the key. The frequency acts as value
	 */
	static HashMap<Character, Integer> tableInit(String myString){
		HashMap<Character, Integer> table = new HashMap<Character, Integer>();
		
		StringBuilder sb = new StringBuilder();
		sb.append(myString);
		
		for(int i = 0; i < myString.length(); i++) {
			char c = sb.charAt(i);
			if(!table.containsKey(c)) {
				table.put(c, 0);
			}else {
				int tmp = table.get(c);
				table.put(c, ++tmp);
			}
		}
		return table;
	}

}

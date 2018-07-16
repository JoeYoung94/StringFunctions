package ds_ArraysAndStrings;

import java.util.Scanner;

/**
 * 
 * @author JoeYang
 * this class is used for determine whether two strings are permutations.
 * in this case, we should use the sort function to sort the two strings because they will be 
 * exactly the same after sorting. All we need to do is to compare two sorted strings
 *
 */
public class CheckPermutation {

	public static void main(String[] args) {
		
		// the Scanner that gets the string input
		Scanner scanner = new Scanner(System.in);
		String myString1 = scanner.nextLine();
		String myString2 = scanner.nextLine();
		scanner.close();
		
		// the return result which determines whether the strings are permutations
		boolean result = false;
		
		// Determine the result
		result = determinePermutation(myString1, myString2);
		
		if(result == false) {
			System.out.println("Not Permutation");
		}else {
			System.out.println("Is Permutation");
		}		
	}

	
	
	/**
	 * 
	 * @param the input strings which are sorted
	 * @return the result of true or false which stands for whether it is permutation
	 */
	private static boolean determinePermutation(String myString1, String myString2) {
		if(myString1.length() != myString2.length()) {
			return false;
		}
		
		return sort(myString1).equals(sort(myString2));
	}



	/**
	 * 
	 * @param the string to be sorted
	 * @return the sorted string
	 */
	private static String sort(String myString) {
		char[] charArray = myString.toCharArray();
		java.util.Arrays.sort(charArray);
		
		// hint: we cannot use charArray.toString() here
		return new String(charArray);
	}

}

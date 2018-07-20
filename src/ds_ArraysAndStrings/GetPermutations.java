package ds_ArraysAndStrings;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author yunqiaoyang
 * 
 * In this class, given a string text, it returns all of the permutations of the string using 
 * the recursive function.
 *
 */
public class GetPermutations {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.next();
		scanner.close();
		
		ArrayList<String> result = new ArrayList<String>();
		result = getPermutations(text);
		
		for(String str : result) {
			System.out.println(str);
		}

	}
	
	/**
	 * 
	 * @param the input String
	 * @return an arrayList of result which stands for all the permutations
	 */
	private static ArrayList<String> getPermutations(String text){
		ArrayList<String> results = new ArrayList<String>();

	    // the base case
	    if (text.length() == 1) {
	        results.add(text);
	        return results;
	    }

	    for (int i = 0; i < text.length(); i++) {
	        char first = text.charAt(i);
	        
	        // the sub-string except the specific character
	        String remains = text.substring(0, i) + text.substring(i + 1);

	        // recursively call function getPermutations(remains)
	        ArrayList<String> innerPermutations = getPermutations(remains);

	        for (int j = 0; j < innerPermutations.size(); j++)
	            results.add(first + innerPermutations.get(j));
	    }

	    return results;
	}

}

package ds_ArraysAndStrings;

import java.util.Scanner;

/**
 * 
 * @author yunqiaoyang
 * 
 * This class should be used to check whether two strings can be changed to each other with only one 
 * edit including inserting, deleting, and replacing. However, the edit can be only applied once.
 * 
 * Instead of doing the the traditional character check one by one, here I used the length of the strings
 * to check. There are actually only two situations inserting and replacing. When Replacing, we use a 
 * for loop, when the difference appears, we set the flag to true. But when the second difference appears,
 * we check the flag again, if it's true then we return false. For the inserting we can use the same 
 * strategy. We can just use a while loop, when it comes up difference for the first time, we add the index
 * of the second (longer) string. But now the current index should be equal. If it's not equal, we should 
 * return false here.
 *
 */
public class OneEditCheck {

	public static void main(String[] args) {
		// the Scanner that gets the string input
		Scanner scanner = new Scanner(System.in);
		String myString1 = scanner.nextLine();
		String myString2 = scanner.nextLine();
		scanner.close();
		
		// the return result which determines whether the strings are permutations
		boolean result = false;
		
		// Determine the result
		result = CheckOneEdit(myString1, myString2);
		
		if(result == false) {
			System.out.println("Not just one edit applied");
		}else {
			System.out.println("Just one edit applied");
		}	
	}
	
	private static boolean CheckOneEdit(String myString1, String myString2) {
		if(myString1.length() == myString2.length()) {
			return oneEditReplace(myString1, myString2);
		}else if(myString1.length() + 1 == myString2.length()) {
			return oneEditInsert(myString1, myString2);
		}else {
			return oneEditInsert(myString2, myString1);
		}
	}

	/**
	 * 
	 * @param myString1
	 * @param myString2
	 * @return the result whether it's edited only once.
	 */
	private static boolean oneEditInsert(String myString1, String myString2) {
		int index1 = 0;
		int index2 = 0;
		
		while(index1 < myString1.length() && index2 < myString2.length()) {
			if(myString1.charAt(index1) != myString2.charAt(index2)) {
				if(index1 != index2) {
					return false;
				}
				index2++;
			}else {
				index1++;
				index2++;
			}
		}
		
		return true;
	}

	/**
	 * 
	 * @param myString1
	 * @param myString2
	 * @return the result whether it's edited only once
	 */
	private static boolean oneEditReplace(String myString1, String myString2) {
		
		// there should be a flag parameter to show if there is difference between str1 and str2
		boolean foundDifference = false;
		
		for(int i = 0; i  < myString1.length(); i++) {
			if(myString1.charAt(i) != myString2.charAt(i)) {
				if(foundDifference) {
					return false;
				}
				foundDifference = true;
			}
		}
		
		return true;
	}

}

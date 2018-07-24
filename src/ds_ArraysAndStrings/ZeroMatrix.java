package ds_ArraysAndStrings;

import java.util.Scanner;

/**
 * 
 * @author yunqiaoyang
 * 
 * This class is an algorithm that if an element in an m*N matrix is 0, its entire row and column
 * are set to 0.
 * 
 * The complexity is O(n)
 *
 */
public class ZeroMatrix {

	public static void main(String[] args) {
		// first initialize the matrix 5*4 for example
		// You can change the initial matrix to whatever you want
		int tmp = 0;
		
		int[][] matrix = new int[5][4];
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 4; j++) {
				matrix[i][j] = ++tmp;
			}
		}

		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(String.format("%3s", matrix[i][j]));
			}
			System.out.println();
		}
		
		// the Scanner that gets the integer input
		// I did not do the boundary check here. If you want please feel free to add it.
		Scanner scanner = new Scanner(System.in);
		int integer1 = scanner.nextInt();
		int integer2 = scanner.nextInt();
		scanner.close();
		
		matrix[integer1][integer2] = 0;
		
		// change the entire row and column's value to 0
		zeroMatrix(matrix, integer1, integer2, 5, 4);
		
		// print it again
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(String.format("%3s", matrix[i][j]));
			}
			System.out.println();
		}
	}
	
	/**
	 * 
	 * @param matrix The matrix to be operated
	 * @param row The row number of the element
	 * @param column The column number of the element
	 * @param rowSize The row size of the matrix
	 * @param colSize The column size of the matrix
	 */
	private static void zeroMatrix(int[][] matrix, int row, int column, int rowSize, int colSize){
		// change the entire row and column's value to 0
		for(int i = 0; i < rowSize; i++) {
			matrix[i][column] = 0;
		}
		for(int i = 0; i < colSize; i++) {
			matrix[row][i] = 0;
		}
	}

}

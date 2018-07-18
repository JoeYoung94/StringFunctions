package ds_ArraysAndStrings;


/**
 * 
 * @author yunqiaoyang
 * 
 * This is a class for rotating matrix in clockwise direction. You can define the N*N matrix by 
 * you own. 
 * 
 * The algorithm: foreach layer: tmp = top[i]; top[i] = left[i]; left[i] = bottom[i]; bottom[i]
 *  = right[i]; right[i] = tmp
 *
 */
public class RotateNNMatrix {

	public static void main(String[] args) {
		
		// first initialize the matrix 4*4 for example
		int tmp = 0;
		
		int[][] matrix = new int[4][4];
		
		for(int i = 0; i < 4; i++) {
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
		
		// then rotate the matrix
		
		boolean result = false;
		result = rotate(matrix);
		System.out.println();
		if(result) {
			for(int i = 0; i < matrix.length; i++) {
				for(int j = 0; j < matrix[i].length; j++) {
					System.out.print(String.format("%3s", matrix[i][j]));
				}
				System.out.println();
			}
		}
	}
	
	private static boolean rotate(int[][] matrix) {
		if(matrix.length == 0 || matrix.length != matrix[0].length) {
			return false;
		}
		
		int n = matrix.length;
		
		// n/2 stands for the layers of the matrix. ex: the 4*4 matrix gets 2 circles (layers)
		for(int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			
			for(int i = first; i < last; i++) {
				int offset = i - first;
				
				int top = matrix[first][i];
				
				// left -> top
				matrix[first][i] = matrix[last - offset][first];
				
				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];
				
				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				
				// top -> right
				matrix[i][last] = top;
			}
		}
		
		return true;
	}

}

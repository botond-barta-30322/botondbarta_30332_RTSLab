package Lab_1;

public class exercise_2 {
	   public static void main(String[] args) {
	        int[][] matrix1 = { {2, 3, 1},
	                            {7, 1, 6},
	                            {9, 2, 4} };
	        
	        int[][] matrix2 = { {8, 5, 3},
	                            {3, 9, 2},
	                            {2, 7, 3} };
	                            
	/*                            
			Make sure you created the matrices right

	        System.out.println("Matrix 1:");
	        printMatrix(matrix1);

	        System.out.println("\n Matrix 2:");
	        printMatrix(matrix2);
	*/ 
	        int[][] sumMatrix = addMatrix(matrix1, matrix2);
	        int[][] prodMatrix = multiplyMatrix(matrix1, matrix2);

	        System.out.println("\nSum matrix:");
	        printMatrix(sumMatrix);

	        System.out.println("\nProduct matrix:");
	        printMatrix(prodMatrix);
	    }

	    public static int[][] addMatrix(int[][] matrix1, int[][] matrix2) {
	        int rows = matrix1.length;
	        int cols = matrix1[0].length;
	        int[][] result = new int[rows][cols];

	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                result[i][j] = matrix1[i][j] + matrix2[i][j];
	            }
	        }
	        return result;
	    }

	    public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
	        int rows1 = matrix1.length;
	        int cols1 = matrix1[0].length;
	        int cols2 = matrix2[0].length;
	        int[][] result = new int[rows1][cols2];

	        for (int i = 0; i < rows1; i++) {
	            for (int j = 0; j < cols2; j++) {
	                for (int k = 0; k < cols1; k++) {
	                    result[i][j] += matrix1[i][k] * matrix2[k][j];
	                }
	            }
	        }
	        return result;
	    }

	    
	    public static void printMatrix(int[][] m) {
	        for (int[] i : m) {
	        	 System.out.print( "|");
	            for (int j : i) {
	                System.out.print(j + " ");
	            }
	            System.out.println("|");
	        }
	    }
	
}

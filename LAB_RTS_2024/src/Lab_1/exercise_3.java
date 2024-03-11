package Lab_1;
import java.util.Arrays;
import java.util.Random;

	public class exercise_3 {
		
	    public static void main(String[] args) {
	    	
	        int[] randomNumbers = new int[10];
	        Random random = new Random();
	        
	        for (int i = 0; i < randomNumbers.length; i++) {
	            randomNumbers[i] = random.nextInt(100);
	        }
	        System.out.println("Unsorted array:");
	        
	        for (int number : randomNumbers) {
	            System.out.print(number + " ");
	        }
	        Arrays.sort(randomNumbers);

	        System.out.println("\nSorted Array:");
	        for (int number : randomNumbers) {
	            System.out.print(number + " ");
	        }
	        
	    }
	    
	}



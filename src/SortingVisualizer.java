import java.awt.Color;
import java.util.Arrays;
import java.util.Random;


public class SortingVisualizer {

	public static void main(String[] args) {
		int numElements = 20;
		int maxValue = 20;
		
		int[] sortMe = randomIntArray(numElements, maxValue);
		System.out.println(Arrays.toString(sortMe));
		
		Visualizer.setup(900, 600);
		Visualizer.setArray(sortMe, maxValue);
		Visualizer.setColors(Color.BLACK, Color.WHITE);
		
	}
	
	private static int[] randomIntArray(int arraySize, int maxValue) {
		int[] randomArray = new int[arraySize];
		
		Random random = new Random();
		for(int i = 0; i < randomArray.length; i++){
			randomArray[i] = random.nextInt(maxValue);
		}
		
		return randomArray;
	}
}

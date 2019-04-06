import java.awt.Color;
import java.util.Arrays;
import java.util.Random;


public class SortingVisualizer {

	public static void main(String[] args) {
		int windowWidth = 900;
		int windowHeight = 600;
		int numElements = 100; // TODO bug: if numElements > 300, only first part of the array is visualized
		int maxValue = 100;
		Color foregroundColor = Color.WHITE;
		Color backgroundColor = Color.BLACK;
		
		int[] sortMe = randomIntArray(numElements, maxValue);
		System.out.println("Array to be sorted: " + Arrays.toString(sortMe));
		
		Visualizer vis = new Visualizer(windowWidth, windowHeight);
		vis.setArray(sortMe, maxValue);
		vis.setColors(foregroundColor, backgroundColor);
		
	}
	
	private static int[] randomIntArray(int arraySize, int maxValue) {
		int[] randomArray = new int[arraySize];
		
		Random random = new Random();
		for(int i = 0; i < randomArray.length; i++)
			randomArray[i] = random.nextInt(maxValue + 1);
		
		return randomArray;
	}
}

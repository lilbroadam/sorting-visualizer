import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;


public class Visualizer extends Canvas {
	
	private static Graphics g;
	private static Color backgroundColor;
	private static Color blockColor;
	private static int[] sortMe;
	private static int windowWidth;
	private static int windowHeight;
	private static int maxValue; // TODO come up with a better name
	
	public static void setup(int windowWidth, int windowHeight) {
		System.out.println("setup!");
		Visualizer.windowWidth = windowWidth;
		Visualizer.windowHeight = windowHeight;
		
		Canvas visualizer = new Visualizer();
		visualizer.setSize(windowWidth, windowHeight);
		visualizer.setBackground(backgroundColor);
		
		JFrame frame = new JFrame("Visualizer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(visualizer);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void setArray(int[] arrayToBeVisualized, int maxValue) {
		System.out.println("setArray!");
		sortMe = arrayToBeVisualized;
		Visualizer.maxValue = maxValue;
	}
	
	public static void setColors(Color backgroundColor, Color blockColor) {
		System.out.println("colors!");
		Visualizer.backgroundColor = backgroundColor;
		Visualizer.blockColor = blockColor;
	}
	
	public void paint(Graphics g){
		System.out.println("paint!");
		g.setColor(Visualizer.blockColor);
		
		int blockWidth = windowWidth / sortMe.length;
		int blockHeightInterval = windowHeight / maxValue;
		
		for(int i = 0; i < sortMe.length; i++) {
			int currentValue = sortMe[i];
			
			int blockX = i * blockWidth;
			int blockY = windowHeight - (currentValue * blockHeightInterval);
			int blockHeight = currentValue * blockHeightInterval; // the value of the index
			
			g.fillRect(blockX, blockY, blockWidth, blockHeight);
		}
	}
	
}

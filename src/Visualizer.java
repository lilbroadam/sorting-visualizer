import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;


public class Visualizer {
	
	private int[] sortMe; // TODO come up with a better name
	private int maxValue; // this one too
	private int windowWidth;
	private int windowHeight;
	private Color foregroundColor;
	private Color backgroundColor;
	private JFrame frame;
	private Canvas canvas;
	
	
	public Visualizer(int windowWidth, int windowHeight) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		
		frame = new JFrame("Visualizer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		canvas = new VisualizerCanvas();
		canvas.setSize(windowWidth, windowHeight);
		
		frame.add(canvas);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		// TODO I think the canvas is being draw with the wrong colors initially here but it is updated
		// so fast after setColors(..) is called so it's not noticable
	}
	
	public void setArray(int[] arrayToVisualize, int maxValue) {
		sortMe = arrayToVisualize;
		this.maxValue = maxValue;
	}
	
	public void setColors(Color foreground, Color background) {
		foregroundColor = foreground;
		backgroundColor = background;
		
		canvas.setBackground(backgroundColor);
	}
	
	private class VisualizerCanvas extends Canvas {
		
		public void paint(Graphics g) {
			g.setColor(foregroundColor);
			
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
}

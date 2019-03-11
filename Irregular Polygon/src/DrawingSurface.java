


import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import processing.core.PApplet;



public class DrawingSurface extends PApplet {

	private IrregularPolygon poly;
	
	private int ANIMATION_TIME = 100;
	private float x,y,time;
	
	public DrawingSurface() {
		poly = new IrregularPolygon();
		
		runSketch();
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		//size(0,0,PApplet.P3D);
	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		background(255);   // Clear the screen with a white background
		fill(255);
		textAlign(CENTER);
		textSize(12);
		
		if (poly != null) {
			poly.draw(this);
		
			fill(0);
			text("Perimeter: " + poly.calcPerimeter() + "\nArea: " + poly.calcArea()+ "\nCentroid: (" + poly.calcCentroid().getX() + ","+poly.calcCentroid().getY()+ ")",(float)width/2,(float)20 );
		}
		if (time > 0) {
			time-=2;
			float size = (float)Math.sin((ANIMATION_TIME-time)/ANIMATION_TIME*Math.PI)*10;
			ellipse(x, y, size, size);
		}

	}
	
	
	public void mousePressed() {
		if (mouseButton == LEFT) {
			poly.add(new Point2D.Double(mouseX,mouseY));
			x = mouseX;
			y = mouseY;
			time = ANIMATION_TIME;
		} 
		if (mouseButton == RIGHT) {
			int index = poly.getClosestPoint(new Point2D.Double(mouseX,mouseY));
			x = mouseX;
			y = mouseY;
			
			poly.setPoint(index, x, y);
			time = ANIMATION_TIME;
		} 
	}
	
	
	
	public void keyPressed() {
		if (keyCode == KeyEvent.VK_SPACE) {
			poly = new IrregularPolygon();
		} 
		
		if (keyCode == KeyEvent.VK_UP) {
			poly.scale(1.25);
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			poly.scale(.75);
		}
	}
	
	
}











import java.awt.Point;
import java.awt.geom.Point2D;

public class Vehicle {


	public static final double XMax_Velocity = 5 ; 
	public static final double YMax_Velocity = 5 ; 
	private Point2D.Float  intial;
	private Point2D.Float  destination;

	private double xvelocity;
	private double yvelocity;
	private double accelerationx;
	private double accelerationy;




	public Vehicle(float x,float y, float dx,float dy, double xacceleration, double yaccelration) {

		destination = new Point2D.Float(dx,dy);
		intial = new Point2D.Float(x,y);
		this.accelerationx=accelerationx;
		this.accelerationy=accelerationy;

	}


	public void move() {

		if(Vehicle.XMax_Velocity>xvelocity) {

			xvelocity+=accelerationx;
		}

		if(Vehicle.YMax_Velocity>yvelocity) {

			yvelocity+=accelerationy;
		}


	}

	public void draw() {
		
		
		
		
		
	}





}

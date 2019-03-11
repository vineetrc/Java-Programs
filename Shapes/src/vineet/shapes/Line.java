package vineet.shapes;
import processing.core.PApplet;





/**
 * This class models a Processing -drawable Line
 * @author Vineet Chinthakindi
 * @version 9/21/17
 */
public class Line extends Shape {


	
	private double x2;
	private double y2;


	/**
	 *  Constructs a line from (x1, y1) to (x2, y2)
	 * @param x1 x coordinate of point1
	 * @param y1 y coordinate of point2
	 * @param x2 x coordinate of point1
	 * @param y2 y coordinate of point2
	 */
	public Line(double x1, double y1, double x2, double y2) {

		super(x1,y1);
		this.x2 = x2;
		
		this.y2 = y2;
	}
	 

	/**
	 *  Sets this line’s second point (x2, y2) to a new coordinate
	 * @param x2 x coordinate of second point
	 * @param y2 y coordinate of second point
	 */
	public void setPoint2(double x2, double y2) {

		this.x2=x2;
		this.y2=y2;
	}

	/**
	 *  Draws this line using the PApplet passed as an argument
	 * @param drawer Papplet object
	 */
	public void draw(PApplet drawer) {

		
		super.draw(drawer);
		drawer.line((float)this.getX(), (float)this.getY(), (float)x2, (float)y2);
	}

	/**
	 *  Returns true if this line segment and the segment other intersect each other. Returns false if they do not intersect.
	 * @param other the other Line you want to test for intersection
	 * @return true for intersection and false for no intersection
	 * @pre other != null
	 */
	public boolean intersects(Line other) {

		double lowX = 0;
		double heighX =0;
		double lowY=0;
		double heighY=0;
		double lowX1=0;
		double heighX1=0;
		double lowY1=0;
		double heighY1=0;
		

		double x3 = other.getX();
		double y3 = other.getY();
		double x4 = other.x2;
		double y4 = other.y2;

		double pX = ((this.getX()*y2 - this.getY()*x2)*(x3-x4) - (this.getX()-x2)*(x3*y4-y3*x4))/((this.getX()-x2)*(y3-y4)-(this.getY()-y2)*(x3-x4));
		double pY = ((this.getX()*y2 - this.getY()*x2)*(y3-y4) - (this.getY()-y2)*(x3*y4-y3*x4))/((this.getX()-x2)*(y3-y4)-(this.getY()-y2)*(x3-x4));

		/*System.out.println(pX+":"+pY);
		System.out.println(x1+":"+x2);
		System.out.println(x3+":"+x4);
		System.out.println(y1+":"+y2);
		System.out.println(y3+":"+y4);
        */


		if(this.getX()>x2) {
			lowX = x2;
			heighX= this.getX();
		}
		if(x2>this.getX()) {
			lowX = this.getX();
			heighX= x2;
		}
		if(this.getY()>y2) {
			lowY = y2;
			heighY= this.getY();
		}
		if(y2>this.getY()) {
			lowY = this.getY();
			heighY= y2;
		}
		if(other.getX()>other.x2) {
			lowX1 = other.x2;
			heighX1= other.getX();
		}
		if(other.x2>other.getX()) {
			lowX1 = other.getX();
			heighX1= other.x2;
		}
		if(other.getY()>other.y2) {
			lowY1 = other.y2;
			heighY1= other.getY();
		}
		if(other.y2>other.getY()) {
			lowY1 = other.getY();
			heighY1= other.y2;
		}
		

		 
		/* System.out.println(pX+":"+pY);
		System.out.println(lowX+":"+heighX);
		System.out.println(lowX1+":"+heighX1);
		System.out.println(lowY+":"+heighY);
		System.out.println(lowY1+":"+heighY1);
		*/
		
		if(y3==y4) {
			if((lowX<pX)&&(pX<heighX)&&(lowY<pY)&&(pY<heighY)&&(lowX1<pX)&&(pX<heighX1))
				  return true;
				
				
			}
		if(this.getY()==y2) {
			if((lowX<pX)&&(pX<heighX) &&(lowX1<pX)&&(pX<heighX1)&&(lowY1<pY)&&(pY<heighY1))
				  return true;
				
				
			}
		if(x3==x4) {
			if((lowX<pX)&&(pX<heighX) &&(lowY<pY)&&(pY<heighY) &&(lowY1<pY)&&(pY<heighY1))
				  return true;
				
				
			}
		if(this.getX()==x2) {
			if((lowX1<pX)&&(pX<heighX1)&&(lowY<pY)&&(pY<heighY) &&(lowY1<pY)&&(pY<heighY1))
				  return true;
				
				
			}
		
		if((lowX<pX)&&(pX<heighX) &&(lowX1<pX)&&(pX<heighX1)&&(lowY<pY)&&(pY<heighY) &&(lowY1<pY)&&(pY<heighY1)) {
			return true;
		}
		return false;

	}
	
	public double getP() {
		return 0;
		
		
		
		
		
		
	}
	


}


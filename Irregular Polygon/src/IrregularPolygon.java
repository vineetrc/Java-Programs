import java.awt.Color;
import java.awt.geom.*;  // for Point2D.Double
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;      // for ArrayList
import processing.core.PApplet;	// for Processing
import vineet.shapes.Line;
import vineet.shapes.Shape;

/*
 * (+): In calcPerimeter(), I like that you automatically return 0 if the polygon doesn't have more than 3 lines. It reduces code.
 * 
 * (-): The polygon can only be drawn with black lines.
 * 
 * To improve functionality, you can add a method that removes specific points of the polygon.
 */
public class IrregularPolygon extends Shape {
	private ArrayList <Point2D.Double> myPolygon;

	// constructors
	public IrregularPolygon() {  

		super(0,0);
		myPolygon = new ArrayList<Point2D.Double>();

		
	}

	// public methods
	public void add(Point2D.Double aPoint) {   


		myPolygon.add(aPoint);







	}

	public void draw(PApplet marker) {   





		marker.clear();
		marker.background(255);

		
		if(myPolygon.size()>=1) {
		
		Line l1,l2;
		for (int i = 0; i < this.myPolygon.size()-1; i++) {
			l1 = new Line(myPolygon.get(i).getX(),myPolygon.get(i).getY(),myPolygon.get(i+1).getX(),myPolygon.get(i+1).getY());
			l1.setStrokeColor(Color.RED);
			l1.draw(marker);
		}



		l2 = new Line(myPolygon.get(this.myPolygon.size()-1).getX(),myPolygon.get(this.myPolygon.size()-1).getY(),myPolygon.get(0).getX(),myPolygon.get(0).getY());
		l2.setStrokeColor(Color.RED);
		l2.draw(marker); 



		}

	}

	public double calcPerimeter() {  



		if (myPolygon.size() < 2){
			return 0.0;
		}

		int i = 0;
		double d = 0;
		double total = myPolygon.get(0).distance(myPolygon.get(myPolygon.size() - 1));;

		while (i < myPolygon.size() - 1 )
		{
			Point2D.Double point1 = myPolygon.get(i);

			Point2D.Double point2 = myPolygon.get(i+1);


			d = point1.distance(point2);
			System.out.println(d);

			total = total + d;
			i++;

		}
		return total;







	}

	public double calcArea() {

		double total = 0;

		if(myPolygon.size()>=1) {

		for(int i = 0; i < myPolygon.size()-1; i++)
		{
			double X1 = (myPolygon.get(i).getX());
			double Y1 = (myPolygon.get(i+1).getY());

			total += (X1 * Y1);
		}


		total+=(myPolygon.get(myPolygon.size()-1).getX()*myPolygon.get(0).getY());


		for(int i = 0; i < myPolygon.size()-1; i++)
		{
			double X1 = (myPolygon.get(i+1).getX());
			double Y1 = (myPolygon.get(i).getY());

			total -= (X1 * Y1);
		}

		total-=(myPolygon.get(myPolygon.size()-1).getY()*myPolygon.get(0).getX());




		return 0.5 * total;  


		}
		else 
			return 0;
	} 

	public void scale(double scaleFactor) {


		for(int i = 0;i<myPolygon.size() ;i++ ) {


			myPolygon.set(i, new Point2D.Double(myPolygon.get(i).getX()*scaleFactor,myPolygon.get(i).getY()*scaleFactor));


		}

	}


	public void translate(int x , int y) {


		for(int i = 0;i<myPolygon.size() ;i++ ) {


			myPolygon.set(i, new Point2D.Double(myPolygon.get(i).getX()+x,myPolygon.get(i).getY()+y));


		}






	}



	public Point2D calcCentroid() {

		double Xtotal = 0;
		double Ytotal = 0;

		for(int i = 0;i<myPolygon.size() ;i++ ) {
			Xtotal+=myPolygon.get(i).getX();
			Ytotal+=myPolygon.get(i).getY();



		}



		Xtotal = Xtotal/myPolygon.size();
		Ytotal = Ytotal/myPolygon.size();




		return new Point2D.Double(Xtotal,Ytotal);

	}




	public int getClosestPoint(Point2D.Double point) {

		double max = 0 ;
		int index = 0;
		for(int i = 0;i<myPolygon.size() ;i++ ) {

			if(point.distance(myPolygon.get(i))>=max) {

				max = point.distance(myPolygon.get(i));
				index = i;
			}



		}
		return index;

	}


	public Point2D.Double getPoint(int index){


		return myPolygon.get(index);
	}

	public void setPoint(int index , double x,double y){


		 myPolygon.set(index, new Point2D.Double(x,y));
	}
















}   























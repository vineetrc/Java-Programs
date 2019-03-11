import processing.core.PApplet;


/**
  @(#)KochCurve.java


  @author
  @version
 */
public class BoxFractal {

	private int level;
	private int length;


	public BoxFractal(int level, int length) {
		this.level = level;
		this.length = length;
	}

	public void draw(PApplet marker, int x, int y) {
		drawBoxFractal(x,y,level, length, marker);
		//drawKochCurve(x,y,level, length, marker,0);
		//drawPythTree(x,y,level, length, marker,0);
	}

	private void drawKochCurve(double x,double y,int level, double length, PApplet marker, double angle) {

		float lastX = 0;
		float lastY = 0 ;


		if(level<=1) {



			marker.line((float)x,(float) y,(float) (x+ length*Math.cos(angle)),(float) (y- length*Math.sin(angle)));

		}

		else {
			length /= 3;
			drawKochCurve(x,y,level-1, length, marker,angle);
			x+=length*Math.cos(angle);
			y-=length *Math.sin(angle);
			drawKochCurve(x,y,level-1, length, marker,Math.PI/3 + angle);
			x+=length*Math.cos(Math.PI/3 +angle);
			y-=length *Math.sin(Math.PI/3 +angle);
			drawKochCurve(x,y,level-1, length, marker, -Math.PI/3 + angle);
			x+=length*Math.cos(-Math.PI/3 +angle);
			y-=length *Math.sin(-Math.PI/3 +angle);
			drawKochCurve(x,y,level-1, length, marker,  angle);


			//    		    		Starting where the previous left off, draw a k-1 level Koch curve of 1/3 the current length, at an angle of 60 degrees with respect to the current angle
			//    		    		  
			//    		    		  Starting where the previous left off, draw a k-1 level Koch curve of 1/3 the current length, at an angle of -60 degrees with respect to the current angle
			//    		    		  
			//    		    		  Starting where the previous left off, draw a k-1 level Koch curve of 1/3 the current length
			//
			//    		
			//    		
		}



	}



	private void drawBoxFractal(double x,double y,int level, double length, PApplet marker ) {

		if(level <=1) {
			marker.fill(255);
			marker.rect((float)x,(float) y, (float)length, (float)length);	
		}
		else{

			marker.fill(255);

			drawBoxFractal((float)(x), (float)(y), level - 1,(float)((1/3.0)*length),marker);
			drawBoxFractal((float)(x+(2/3.0)*length), (float)(y),level-1, (float)((1/3.0)*length),marker);
			drawBoxFractal((float)(x+(1/3.0)*length), (float)(y+(1/3.0)*length), level - 1,(float)((1/3.0)*length),marker);

			drawBoxFractal((float)(x), (float)(y+(2/3.0)*length), level - 1,(float)((1/3.0)*length),marker);
			drawBoxFractal((float)(x+(2/3.0)*length), (float)(y+(2/3.0)*length), level - 1,(float)((1/3.0)*length),marker);



		}






	}

	private void drawPythTree(double x,double y,int level, double length, PApplet marker, double angle) {

		if(level <=1) {
			marker.fill(255);
			marker.line((float) x,(float)y,(float)x,(float) (y-length));	
		}
		
		drawKochCurve(x,y,level-1, length, marker,angle);
		x+=length*Math.cos(angle);
		y-=length *Math.sin(angle);
		drawKochCurve(x,y,level-1, length, marker,Math.PI/3 + angle);
		x+=length*Math.cos(Math.PI/3 +angle);
		y-=length *Math.sin(Math.PI/3 +angle);
		drawKochCurve(x,y,level-1, length, marker, -Math.PI/3 + angle);
		x+=length*Math.cos(-Math.PI/3 +angle);
		y-=length *Math.sin(-Math.PI/3 +angle);
		drawKochCurve(x,y,level-1, length, marker,  angle);
		
		
		
	}


}





















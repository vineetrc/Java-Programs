import java.awt.geom.Point2D;
import java.util.Arrays;

public class PathFindingAlgorithm {



	private Point2D.Double destination;
	private Point2D.Double start;


	private int [][] maze = 
			  { {1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,6,1,0,1,0,1,0,0,0,0,0,1},
				{1,0,1,0,0,0,1,0,1,1,1,0,1},
				{1,0,0,0,1,1,1,0,0,0,0,0,1},
				{1,0,1,0,0,0,0,0,1,1,1,0,1},
				{1,0,1,0,1,1,1,0,1,0,0,0,1},
				{1,0,1,0,1,0,0,0,1,1,1,0,1},
				{1,0,1,0,1,1,1,0,1,0,1,0,1},
				{1,0,0,0,0,0,0,0,0,0,1,4,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1}

		};





	public PathFindingAlgorithm(Point2D.Double destination, Point2D.Double start){
		this.destination = destination;
		this.start = start;

	}



	boolean Solve(int x,int y) {


		int startposrow = 1;
		int startposcol=1;

		int endposrow=8;
		int endposcol=11;



		if(isTarget(x,y)) 
			return(true);

		if(valid(x+1,y)&&maze[x+1][y]==0) {
			maze[x][y] = 3;
			if(Solve(x+1,y))
				return(true);
			maze[x][y] = 0;
		}
		if(valid(x-1,y)&&maze[x-1][y]==0) {
			maze[x][y] = 3;
			if(Solve(x-1,y))
				return(true);
			maze[x][y] = 0;
		}
		if(valid(x,y+1)&&maze[x][y+1]==0) {
			maze[x][y] = 3;
			if(Solve(x,y+1))
				return(true);
			maze[x][y] = 0;
		}
		if(valid(x,y-1)&&maze[x][y-1]==0) {
			maze[x][y] = 3;
			if(Solve(x,y-1))
				return(true);
			maze[x][y] = 0;
		}

		return(false);
	}



	public boolean valid(int row,int col){

		if(maze[row][col]==1)
			return false;

		return true;



	}



	public boolean isTarget(int row,int col) {


		return(maze[(int) destination.getY()][(int) destination.getX()]==4);


	}
	
	public void println() {
		
		
		for (int[] x : maze)
		{
		   for (int y : x)
		   {
		        System.out.print(y + " ");
		   }
		   System.out.println();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
}

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;

/*

	Represents a Game Of Life grid.

	Coded by: Vineet Chinthakindi
	Modified on:

 */

public class Connect {

	private int grid[][];
	private boolean redTurn;




	// Constructs an empty grid
	public Connect() {


		grid = new int[10][10];


	}

	// Constructs the grid defined in the file specified
	public Connect(String filename) {
		grid = new int[10][10];
		//grid[3][6] = 1;
		//		grid[1][7] = 1;
		//		grid[2][8] = 1;
		//		grid[3][9] = 1;

	}

	// Runs a single turn of the Game Of Life
	public String step() {
		int count = 0;
		for(int i = 0 ; i<grid.length; i++) {
			for(int j = 0 ; j<grid.length; j++) {
				if(grid[j][i]==2) {

					count++;

				}
				else
					count = 0;

				if(count ==4) {

					return "RED wins";
				}

			}


			count = 0;

		}

		for(int i = 0 ; i<grid.length; i++) {
			for(int j = 0 ; j<grid.length; j++) {
				if(grid[j][i]==1) {

					count++;

				}
				else
					count = 0;

				if(count ==4) {

					return "YELLOW wins";
				}

			}


			count = 0;

		}

		for(int i = 0 ; i<grid.length; i++) {
			for(int j = 0 ; j<grid.length; j++) {
				if(grid[i][j]==2) {

					count++;

				}
				else
					count = 0;

				if(count ==4) {

					return "RED wins";
				}

			}


			count = 0;

		}
		for(int i = 0 ; i<grid.length; i++) {
			for(int j = 0 ; j<grid.length; j++) {
				if(grid[i][j]==1) {

					count++;

				}
				else
					count = 0;

				if(count ==4) {

					return "YELLOW wins";
				}

			}


			count = 0;

		}


		int x =0;
		int y = 6;
		int length = 4;
		while(length<10) {

			y--;
			length ++;





			while(x<length) {

				if(grid[x][y] ==1) {

					count ++;

				}

				else
					count = 0;

				if(count == 4) {

					return "Win";


				}

				x++;
				y++;

			}




		}






		//		grid[0][6] = 1;
		//		grid[1][7] = 1;
		//		grid[2][8] = 1;
		//		grid[3][9] = 1;

		for(int i = 0; i<grid[0].length; i ++) {
			for(int j = 0; j<grid.length; j ++) {
		       if(getNeighbors(i, j)&& (grid[i][j] ==1 || grid[i][j] ==2)) {
		    	   return "daigonal Win";
		    	   
		       }
			}
		}
		       

		return "No one Wins, Yet!";








	}












	public boolean getNeighbors(int i , int j){




		if(i-3>=0 && j+3<10) {

			if( grid[i][j]==grid[i-1][j+1]&&grid[i][j]==grid[i-2][j+2]&&grid[i][j]==grid[i-3][j+3])
				return true;

		}

		if(i-3>=0 && j-3>=0) {

			if( grid[i][j]==grid[i-1][j-1]&&grid[i][j]==grid[i-2][j-2]&&grid[i][j]==grid[i-3][j-3])
				return true;

		}
		if(i+3<10 && j-3>=0) {

			if( grid[i][j]==grid[i+1][j-1]&&grid[i][j]==grid[i+2][j-2]&&grid[i][j]==grid[i+3][j-3])
				return true;

		}
		if(i+3<10 && j+3<10) {

			if( grid[i][j]==grid[i+1][j+1]&&grid[i][j]==grid[i+2][j+2]&&grid[i][j]==grid[i+3][j+3])
				return true;

		}
		return false;









	}







	// Runs n turns of the Game Of Life
	public void step(int n) {
	}

	// Formats this Life grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
		String response = "";

		for(int i = 0; i<grid[0].length; i ++) {
			for(int j = 0; j<grid.length; j ++) {


				if(grid[j][i]==1)
					response+="O";

				else if (grid[j][i]==2)
					response+="X";

				else
					response+="-";

			}
			response += "\n";


		}
		return response;
	}
	// Reads in array data from a simple text file containing asterisks (*)
	public void readData (String filename, boolean[][] gameData) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
				reader = new FileReader(dataFile);
				in = new Scanner(reader);

				while (in.hasNext()) {
					String line = in.nextLine();
					for(int i = 0; i < line.length(); i++)
						if (i < gameData.length && count < gameData[i].length && line.charAt(i)=='*')
							gameData[i][count] = true;

					count++;
				}
			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}

		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
	}







	/**
	 * Optionally, complete this method to draw the grid on a PApplet.
	 * 
	 * @param marker The PApplet used for drawing.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 */
	public void draw(PApplet marker, float x, float y, float width, float height) {

		marker.pushStyle();

		float cellWidth = width/ grid.length;
		float cellHeight = height/grid[0].length;


		marker.stroke(0);
		marker.fill(0,0,255);
		marker.rect(5, 0, width, height);


		for(int i = 0; i<grid[0].length; i ++) {
			for(int j = 0; j<grid.length; j ++) {
				if(grid[j][i]==0)
					marker.fill(255);

				else if(grid[j][i]==1)
					marker.fill(255,255,0);

				else
					marker.fill(255,0,0);

				marker.ellipse(cellWidth*j+x, cellHeight*i+y, cellWidth, cellHeight);
				//marker.text("C",cellWidth*j+x,cellHeight*i+y );
			}



		}


		marker.popStyle();


	}

	/**
	 * Optionally, complete this method to determine which element of the grid matches with a
	 * particular pixel coordinate.
	 * 
	 * @param p A Point object representing a graphical pixel coordinate.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 * @return A Point object representing a coordinate within the game of life grid.
	 */
	public Point clickToIndex(Point p, float x, float y, float width, float height) {

		float cellWidth = width/ grid.length;
		float cellHeight = height/grid[0].length;


		int j = (int)((p.x-x)/cellWidth);
		int i = (int)((p.y-y)/cellHeight);


		if(j<0|| j>=grid.length)
			return null;

		if(i<0|| j>=grid[0].length)
			return null;

		Point answer = new Point(j,i);

		for(int m = grid.length-1; m>=0; m--) {

			if(grid[j][m] == 0) {

				answer = new Point(j,m);
				break;

			}


		}






		if(grid[j][i] == 0) {
			return answer;

		}

		else
			return null;





	}

	/**
	 * Optionally, complete this method to toggle a cell in the game of life grid
	 * between alive and dead.
	 * 
	 * @param i The x coordinate of the cell in the grid.
	 * @param j The y coordinate of the cell in the grid.
	 */
	public void toggleCell(int i, int j) {


		if(redTurn) {
			grid[i][j] = 2;
		}

		else {
			grid[i][j] = 1;
		}


		redTurn = !redTurn;

	}



}
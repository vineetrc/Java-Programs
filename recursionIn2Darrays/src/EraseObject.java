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

public class EraseObject {

	private char grid[][];
	boolean wall = false;
	boolean solved;
	public static final int row = 20;
	public static final int col = 20;

	int j;
	int i;

	// Constructs an empty grid
	public EraseObject() {


		grid = new char[20][20];


	}

	// Constructs the grid defined in the file specified
	public EraseObject(String filename) {
		grid = new char[20][20];
		readData(filename,grid);
	}

	// Runs a single turn of the Game Of Life





	public String toString() {
		String response = "";

		for(int i = 0; i<grid[0].length; i ++) {
			for(int j = 0; j<grid.length; j ++) {

				response+=grid[j][i];

			}
			response += "\n";


		}
		return response;
	}



	public void erase(int x,int y) {


		if(grid[x][y]!='*') {
			return;

		}
		else {
			grid[x][y]=' ';


			if(x<19&&x>0) {
				erase(x-1,y);
				erase(x+1,y);
			}
			if(y<19&&y>0) {
				erase(x,y+1);


				erase(x,y-1);
			}

		}




	}

	public boolean solveMaze() {

		for(int i = 0; i<grid[0].length; i ++) {
			for(int j = 0; j<grid.length; j ++) {

				if(grid[j][i]=='C') {
					return solve(j,i);

				}






			}


		}
		return false;
	}





	private boolean solve(int x,int y) {

		if(grid[x][y]=='X') {

			return true;
		}

		else if(grid[x][y]=='.' ||grid[x][y]=='C') {

			/*if(x<0 || y<0 || x>=grid.length||y>=grid[0].length) {

				return false;
			}*/

			if(grid[x][y]=='.') {
				grid[x][y]='!';

			}

			if(grid[x][y]=='C') {
				grid[x][y]='c';

			}


			if(x<grid.length-1) {
				if (solve( x+1,y) == true) 
					return true;
			}
			if(x>0) {
				if (solve( x-1,y) == true) 
					return true;
			}
			if(y<grid[0].length-1) {
				if (solve( x,y+1) == true) 
					return true;
			}
			if(y>0) {
				if (solve( x,y-1) == true) 
					return true;



					grid[x][y] = '.';
				


				
				return false;







			}

		}
		return false;


	}























	// Formats this Life grid as a String to be printed (one call to this method returns the whole multi-line grid)


	// Reads in array data from a simple text file containing asterisks (*)
	public void readData (String filename, char[][] gameData) {
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
						if (i < gameData.length && count < gameData[i].length)
							gameData[i][count] = line.charAt(i);

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


		for(int i = 0; i<grid[0].length; i ++) {
			for(int j = 0; j<grid.length; j ++) {
				if(grid[j][i]=='#')
					marker.fill(0);
				else if(grid[j][i]=='!')
					marker.fill(120);
				else if(grid[j][i]=='X')
					marker.fill(255,0,0);
				else if(grid[j][i]=='C'||grid[j][i]=='c') {
					marker.fill(0,255,0);
					this.j=j;
					this.i=i;
				}
				else  
					marker.fill(255);

				marker.rect(cellWidth*j+x, cellHeight*i+y, cellWidth, cellHeight);

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


		return answer;









	}



}
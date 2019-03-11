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

public class Life {

	private boolean grid[][];



	// Constructs an empty grid
	public Life() {


		grid = new boolean[20][20];


	}

	// Constructs the grid defined in the file specified
	public Life(String filename) {
		grid = new boolean[20][20];
		readData(filename,grid);
	}

	// Runs a single turn of the Game Of Life
	public void step() {


		boolean space[][] = new boolean[20][20];

		for(int i = 0; i<grid[0].length; i ++) {
			for(int j = 0; j<grid.length; j ++) {

				
				
				if(getNeighbors(i,j) <=1||getNeighbors(i,j) >=4) {

					space[j][i] = false;

				}

				if(getNeighbors(i,j) ==3) {

					space[j][i] = true;

				}

				if(getNeighbors(i,j) ==2 && grid[j][i]==true) {

					space[j][i] = true;

				}



				

			}

		}

		for(int i = 0; i<space[0].length; i ++) {
			for(int j = 0; j<space.length; j ++) {

				grid[j][i]=space[j][i];

			}

		}








	}















	public int getNeighbors(int i , int j){

		//		int count  = 0;
		//		 if(i == 0&&j == 0) {
		//
		//			for(int m = i ; m<i+2; i ++) {
		//				for(int n = j; n<j+2; j ++) {
		//
		//					if(grid[m][n]) {
		//						count ++;
		//
		//					}
		//				}
		//				count -- ;
		//			}
		//		}
		//		else if(i == 0&&j == grid[0].length-1) {
		//
		//
		//			for(int m = i ; m<i+2; i ++) {
		//				for(int n = j-1; n<j+1; j ++) {
		//
		//					if(grid[m][n]) {
		//						count ++;
		//
		//					}
		//				}
		//				count -- ;
		//			}
		//
		//
		//
		//
		//		}
		//		else if(i == grid.length-1&&j == 0) {
		//			for(int m = i-1 ; m<i+1; i ++) {
		//				for(int n = j; n<j+1; j ++) {
		//
		//					if(grid[m][n]) {
		//						count ++;
		//
		//					}
		//				}
		//				count -- ;
		//			}
		//		}
		//
		//		else if(i ==grid.length-1 &&j == grid[0].length-1) {
		//
		//			for(int m = i-1 ; m<i+1; i ++) {
		//				for(int n = j-1; n<j+1; j ++) {
		//
		//					if(grid[m][n]) {
		//						count ++;
		//
		//					}
		//				}
		//				count -- ;
		//			}
		//		}
		//		else if(i == 0) {
		//
		//				for(int m = i ; m<i+2; i ++) {
		//					for(int n = j-1; n<j+2; j ++) {
		//
		//						if(grid[m][n]) {
		//
		//
		//							count ++;
		//
		//						}
		//					}
		//
		//
		//					count -- ;
		//
		//				}
		//
		//			}
		//
		//
		//
		//
		//
		//			else if(i == grid.length-1) {
		
		//				for(int m = i-1 ; m<i+1; i ++) {
		//					for(int n = j-1; n<j+2; j ++) {
		//
		//						if(grid[m][n]) {
		//
		//
		//							count ++;
		//
		//
		//
		//
		//						}
		//
		//
		//
		//					}
		//
		//
		//					count -- ;
		//
		//				}
		//
		//
		//			}
		//
		//			else if(j == grid[0].length-1) {
		//				for(int m = i-1 ; m<i+2; i ++) {
		//					for(int n = j-1; n<j+1; j ++) {
		//
		//						if(grid[m][n]) {
		//							count ++;
		//						}
		//					}
		//					count -- ;
		//
		//				}
		//
		//			}
		//
		//			else if(j == 0) {
		//				for(int m = i-1 ; m<i+2; i ++) {
		//					for(int n = j; n<j+2; j ++) {
		//
		//						if(grid[m][n]) {
		//							count ++;
		//
		//						}
		//					}
		//					count -- ;
		//				}
		//			}
		//
		//
		//		else {
		//			for(int m = i-1 ; m<i+2; i ++) {
		//				for(int n = j-1; n<j+2; j ++) {
		//
		//					if(grid[m][n]) {
		//						count ++;
		//					}
		//				}
		//
		//
		//				count -- ;
		//
		//			}
		//
		//		}
		//		return count;
		//

		int count = 0;


		int count1=0;
		int count2=0;
		int bound1=0;
		int bound2=0;


		if(i==0 && j ==0) {


			count1 = 0;
			count2 = 0;

			bound1 = count1+2;

			bound2 = count2+2;


		}
		else if(i==0 && j==grid.length-1) {


			count1 = i;
			count2 = j-1;

			bound1 = i+2;

			bound2 = j+1;


		}

		else if(i==grid[0].length-1 && j==0) {


			count1 = i-1;
			count2 = 0;

			bound1 = i+1;

			bound2 = 2;


		}
		else if(i==grid[0].length-1 && j==grid.length-1) {


			count1 = i-1;
			count2 = j-1;

			bound1 = i+1;

			bound2 = j+1;


		}


		else if(i==0) {


			count1 = i;
			count2 = j-1;

			bound1 = i+2;

			bound2 = j+2;







		}

		else if(j==0) {



			count1 = i-1;
			count2 = j;

			bound1 = i+2;

			bound2 = j+2;







		}

		else if(j==grid.length-1) {



			count1 = i-1;
			count2 = j-1;

			bound1 = i+2;

			bound2 = j+1;

		}

		
		else if(i==grid[0].length-1) {



			count1 = i-1;
			count2 = j-1;

			bound1 = i+1;

			bound2 = j+2;

		}

		
		
		else {

			count1 = i-1;
			count2 = j-1;

			bound1 = i+2;

			bound2 = j+2;

		}
        if(grid[j][i]==false) {
        	
        	count++;
        	
        	
        	
        }
		for(int m = count1 ; m<bound1; m ++) {
			for(int n = count2; n<bound2; n ++) {
				if(grid[n][m]) {
					count ++;
				}
			}
		}
		count -- ;
		return count;
	}




	// Runs n turns of the Game Of Life
	public void step(int n) {
	}

	// Formats this Life grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
		String response = "";

		for(int i = 0; i<grid[0].length; i ++) {
			for(int j = 0; j<grid.length; j ++) {

				if(j==4&&i==grid.length-1) {
					response+="@";

				}
				else if(grid[j][i]==true)
					response+="*";

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
		
		
		for(int i = 0; i<grid[0].length; i ++) {
			for(int j = 0; j<grid.length; j ++) {
				 if(grid[j][i]==true)
					marker.fill(0);

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

	/**
	 * Optionally, complete this method to toggle a cell in the game of life grid
	 * between alive and dead.
	 * 
	 * @param i The x coordinate of the cell in the grid.
	 * @param j The y coordinate of the cell in the grid.
	 */
	public void toggleCell(int i, int j) {
		
		
		grid[i][j] = !grid[i][j];
		
		
		
	}



}
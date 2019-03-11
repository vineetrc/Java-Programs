import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*

	This program erases objects (connected stars) from a 2D grid. 

	Coded by: 
	Modified on: 

 */

public class Erase {

	private static final int rows = 20;
	private static final int cols = 20;
	private char[][] data;

	// Constructs an empty grid
	public Erase() {
	}

	// Constructs the grid defined in the file specified
	public Erase(String filename) {
	}

	// Erases an object beginning at x,y
	public void eraseObject(int x, int y) {
	}

	// Formats this grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {

		String response = "";

		for(int i = 0; i<data[0].length; i ++) {
			for(int j = 0; j<data.length; j ++) {

				response+=data[i][j];

			}
			response += "\n";


		}
		return response;

	}

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

	public Point clickToIndex(Point p, float x, float y, float width, float height) {

		float cellWidth = width/ data.length;
		float cellHeight = height/data[0].length;


		int j = (int)((p.x-x)/cellWidth);
		int i = (int)((p.y-y)/cellHeight);


		if(j<0|| j>=data.length)
			return null;

		if(i<0|| j>=data[0].length)
			return null;

		Point answer = new Point(j,i);


		return answer;









	}

}
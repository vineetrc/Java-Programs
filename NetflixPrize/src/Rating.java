
public class Rating implements Comparable<Rating> {

	private int movieID;
	private double rating;

	//String userId;
	private int timestamp;


	public Rating(int movieID, double rating, int timestamp) {
		this.movieID = movieID;
		this.rating = rating;
		this.timestamp = timestamp;




	}

	public Rating(int movieID2) {
		// TODO Auto-generated constructor stub
		
		
		this.movieID = movieID2;
	}

	public double getRating() {

		return rating;

	}
	public double getmovieID() {

		return movieID;

	}




	public String toString() {


		return "[ "+ this.movieID + "|" + this.rating + "|" + this.timestamp +  " ]";





	}

	@Override
	public int compareTo(Rating o) {
		if(movieID>o.movieID) {
			return 1;
		}
		if(movieID<o.movieID) {
			return -1;
		}
		else {
			
			return 0;
		}
	}

	






}

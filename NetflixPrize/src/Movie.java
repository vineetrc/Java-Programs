import java.util.ArrayList;

public class Movie implements Comparable<Movie>{

	private String title;
	private int year;
	private String[] genres;
	private String imdbId;
	private int tmdbId;
	private int movieID;
	private ArrayList<Rating> ratings;
	private double avgRating;



	//constructor
	public Movie(String title,int id, String[] genres, int year) {

		this.title=title;
		this.movieID  =  id;
		this.genres = genres;
		this.year = year;
		ratings  = new ArrayList<Rating>();
		avgRating =3.5;



	}
	public Movie(int id) {
		
		
		this.movieID=id;
		
	}
	
	public String getTitle() {
		return title;
		
		
	}

	public String getImbd() {
		
		return this.imdbId;
	}
	
	
	public void addRating(Rating rating) {


		ratings.add(rating);
	}
	public ArrayList<Rating> getRating() {


		return ratings;
	}
	public int getYear() {

		return this.year;


	}

	public int getMovieID() {


		return this.movieID;

	}

	public double getavgRating(){

		double avg = 0;

		if(ratings.size()>1) {
			for(int i = 0; i<ratings.size();i++) {

				avg += ratings.get(i).getRating();

			}
		}

		else {


			return this.avgRating;

		}
		return avg/ratings.size();




	}




	//toString()



	public String toString() {



		//String result = ""+  this.movieID+"imbdbID="+this.imdbId +"tmbdID = "+ this.tmdbId+ ":"+this.title +"Year:" + this.year+ ", Genres: ";
		String result = "" + this.movieID;
		//		
		//		if(genres!=null) {
		//		
		//		for(int i = 0; i<genres.length; i++) {
		//			
		//			result += "|" + genres[i];
		//			
		//		
		//		}
		//		
		//		
		//		return result + "|";
		//		}
		//		else {
		//			
		//			
		//			return result+="n/a";
		//			
		//			
		//		}
		//		
		//		
		//		

		if(ratings!=null) {

			for(int i = 0; i<ratings.size(); i++) {

				result += "|" + ratings.get(i);


			}


			return result + "|";
		}
		else {


			return result+="n/a";


		}


	}




	public void setimbID(String i) {
		this.imdbId=i;

	}




	public void settmbID(int i) {
		// TODO Auto-generated method stub
		this.tmdbId=i;
	}


	public String[] getGenres() {
		
		
		return genres;
		
	}

	@Override
	public int compareTo(Movie o) {
		
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

import java.util.ArrayList;
import java.util.Collections;


public class NetFlixPredictor {

	ArrayList<Movie> movieData;
	ArrayList<User> userData;
	


	// Add fields to represent your database.


	/**
	 * 
	 * Use the file names to read all data into some local structures. 
	 * 
	 * @param movieFilePath The full path to the movies database.
	 * @param ratingFilePath The full path to the ratings database.
	 * @param tagFilePath The full path to the tags database.
	 * @param linkFilePath The full path to the links database.
	 */
	public NetFlixPredictor(String movieFilePath, String ratingFilePath, String tagFilePath, String linkFilePath) {

		ArrayList<String> movieStrings = FileIO.readFile( movieFilePath);
		ArrayList<String> movieStringsLinks = FileIO.readFile(linkFilePath);
		ArrayList<String> movieStringsRatings = FileIO.readFile(ratingFilePath);
		ArrayList<String> movieStringsTags = FileIO.readFile(tagFilePath);
		MovieLensCSVTranslator translator = new MovieLensCSVTranslator();
		movieData = translator.extractMovies(movieStrings, movieStringsLinks);
		userData = translator.extractUsers(movieStringsRatings,movieStringsTags);


		for(int i = 0; i<userData.size();i++) {


			if(userData.get(i).getRatings()!=null) {



				for(int j = 0; j <userData.get(i).getRatings().size(); j++) {

					for(Movie m : movieData) {

						if(m.getMovieID() == userData.get(i).getRatings().get(j).getmovieID()) {
							m.addRating(userData.get(i).getRatings().get(j));

						}
					}

				}
			}

		}

		//
		Collections.sort(movieData);
		Collections.sort(userData);
		//

	}

	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, return -1.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or -1 if the user does not exist in the database, the movie does not exist, or the movie has not been rated by this user.
	 */
	public double getRating(int userID, int movieID) {

		ArrayList<Rating> userRatings;


		int j = Collections.binarySearch(userData, new User((int) userID));

		if(j>=0) {
			userRatings = userData.get(j).getRatings();
		}
		else {

			return -1;
		}

		if(userRatings.size()>=1) {
			Collections.sort(userRatings);
			int i = Collections.binarySearch(userRatings, new Rating(movieID));
			if(i>=0) {

				return userRatings.get(i).getRating() ;
			}
			return -1;
		}

		return -1;
		//		User user;
		//		ArrayList<Rating> userRating;
		//		
		//		try {
		//		 user = userData.get(userID-1);
		//		}
		//		
		//		catch(IndexOutOfBoundsException ex){
		//			
		//			return -1;
		//			
		//		}
		//		
		//		userRating = user.getRatings();
		//		
		//		
		//		for(int i = 0; i<userRating.size();i++) {
		//			
		//			if(userRating.get(i).getmovieID()==movieID) {
		//				
		//				return userRating.get(i).getRating();
		//			}
		//			
		//			
		//		}
		//		
		//		
		//		return -1;
	}

	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, use other available data to guess what this user would rate the movie.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or the best guess if the movie has not been rated by this user.
	 * @pre A user with id userID and a movie with id movieID exist in the database.
	 */
	public double guessRating(int userID, int movieID) {


		Movie movie = null;
		User user = null;



		if(getRating(userID,movieID)!=-1) {

			return getRating(userID,movieID);


		}

		double total = 0;
		int iterations = 0;
		for(int i = 0; i<movieData.size();i++) {
			if(movieData.get(i).getavgRating()!=3.5) {
				total +=movieData.get(i).getavgRating();
				iterations++;
			}


		}

		double dataAvg = total/iterations;

		for(Movie m : movieData) {

			if(m.getMovieID()==movieID) {

				movie = m;

			}


		}
		double movieAvg = movie.getavgRating();

		
		
		
		int j = Collections.binarySearch(userData, new User((int) userID));

		if(j>=0) {
			user =  userData.get(j);
		}
		else {
			return 3.5;
		}

		double bestMovieRatings = user.getRatings().get(0).getRating();
		double bestMovieID = user.getRatings().get(0).getmovieID();
		for(int i = 0; i<user.getRatings().size();i++) {
			
			if(user.getRatings().get(i).getRating()>bestMovieRatings) {
				bestMovieRatings = user.getRatings().get(i).getRating();
				bestMovieID=user.getRatings().get(i).getmovieID();
			}
			
		}
		
		int k = Collections.binarySearch(movieData, new Movie((int) bestMovieID));
		Movie bestMovie =movieData.get(k); 
		int matches = 0;
		
		if(movie.getGenres() != null) {
		for(int i = 0; i<bestMovie.getGenres().length; i++) {
			//if( movie.getGenres()==null) {System.out.println(movie);}
			for(int n = 0; n< movie.getGenres().length; n++)
			if(bestMovie.getGenres()[i].equals(movie.getGenres()[n])) {
				
				matches++;
				
			}
			
		}
		matches/=movie.getGenres().length;
		
		}
		
		
		
		
		double worstMovieRatings = user.getRatings().get(0).getRating();
		double worstMovieID = user.getRatings().get(0).getmovieID();
		for(int i = 0; i<user.getRatings().size();i++) {
			
			if(user.getRatings().get(i).getRating()>worstMovieRatings) {
				worstMovieRatings = user.getRatings().get(i).getRating();
				worstMovieID=user.getRatings().get(i).getmovieID();
			}
			
		}
		
		int l = Collections.binarySearch(movieData, new Movie((int) worstMovieID));
		Movie worstMovie =movieData.get(l); 
		int worstmatches = 0;
		
		if(movie.getGenres() != null) {
		for(int i = 0; i<worstMovie.getGenres().length; i++) {
			//if( movie.getGenres()==null) {System.out.println(movie);}
			for(int n = 0; n< movie.getGenres().length; n++)
			if(worstMovie.getGenres()[i].equals(movie.getGenres()[n])) {
				
				worstmatches++;
				
			}
			
		}
		worstmatches/=movie.getGenres().length;
		
		}
		
		
		
		double userAvg =user.getavgUserRating();
		
		
		
		
		if(!movie.getRating().isEmpty()) {
			
			return .8*(userAvg - dataAvg) + 0.15*user.getavgUserRating()+0.75*movie.getavgRating()+.3*matches - .15*worstmatches;
		}
		else {
			return .2*(userAvg - dataAvg) + user.getavgUserRating() + .4*matches- .2*worstmatches;
		}
				//&& m.getRating().size()>=1)


	}

	/**
	 * Recommend a movie that you think this user would enjoy (but they have not currently rated it). 
	 * 
	 * @param userNumber The ID of the user.
	 * @return The ID of a movie that data suggests this user would rate highly (but they haven't rated it currently).
	 * @pre A user with id userID exists in the database.
	 */
	public int recommendMovie(int userID) {

		double rating =  guessRating(userID,movieData.get(0).getMovieID());
		int movieID = movieData.get(0).getMovieID();
		for(Movie m : movieData) {
			
			if(guessRating(userID,m.getMovieID())+.1>rating) {
				if(Math.random()<.5 && guessRating(userID,m.getMovieID())>rating) {
				rating = guessRating(userID,m.getMovieID());
				movieID = m.getMovieID();
				}
				
				else if(Math.random()<.25) {
					
					movieID = m.getMovieID();
					
				}
			}
		}




		return movieID;



	}


	public ArrayList<Movie> getMovies(){
		return movieData;




	}





}

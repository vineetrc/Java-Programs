import java.util.ArrayList;
import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



		ArrayList<String> movieStrings = FileIO.readFile("MovieFiles" + FileIO.fileSeparator + "movies.csv");
		ArrayList<String> movieStringsLinks = FileIO.readFile("MovieFiles" + FileIO.fileSeparator + "links.csv");
		ArrayList<String> movieStringsRatings = FileIO.readFile("MovieFiles" + FileIO.fileSeparator + "ratings.csv");
		ArrayList<String> movieStringsTags = FileIO.readFile("MovieFiles" + FileIO.fileSeparator + "tags.csv");
//				for(String s : movieStrings) {
//
//					System.out.println(s);
//
//
//				}


	
	MovieLensCSVTranslator translator = new MovieLensCSVTranslator();
	
	
	ArrayList<Movie> movieData = translator.extractMovies(movieStrings, movieStringsLinks);
	ArrayList<User> userData = translator.extractUsers(movieStringsRatings,movieStringsTags);
	
	
	
	
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
	
	double total = 0;
	int iterations = 0;
	for(int i = 0; i<movieData.size();i++) {
		if(movieData.get(i).getavgRating()!=3.5) {
			total +=movieData.get(i).getavgRating();
			iterations++;
		}
		
		
	}
	
//	for(Movie m : movieData) {
//
//		if(m.getMovieID()==1129) {
//
//			System.out.println("movieAvg"+  m.getavgRating());
//
//		}
//	
//	System.out.println("totalAvg"+ total/iterations);
//	System.out.println("userAvg" + userData.get(0).getavgUserRating());
	//System.out.println("movieAvg"+  movie.getavgRating());
	
	//1129,Escape from New York (1981),Action|Adventure|Sci-Fi|Thriller
	
	
//	
for(User m : userData) {
		
		
Arrays.toString(m.getGenreRatings(movieData));
		
	}
//	
	
	
	
	
	
	
//	for(Movie m : movieData) {
//		
//		System.out.println(m.getavgRating());
//		
//	}
//	
	
	
//	for(int i =1; i<338;i++) {
//		
//		
//		String[] result =translator.parseMovieTags(movieStringsTags.get(i));
//		
//		System.out.println("UserID:" + result[0]+ " movieID:" + result[1]+"tag:" + result[2]+ " timestamp:" + result[3]);
//		
//		
//	}
//		
//			double[] values = translator.parseMovieRatings(movieStringsRatings.get(i));
	
	
	
//	double temp = 0;
//	for(int i =1; i<movieStringsRatings.size();i++) {
//		
//			double[] values = translator.parseMovieRatings(movieStringsRatings.get(i));
//			
//			
//			
//		if(values[0]!=temp) {			
//			User user= new User((int) values[0]);
//			temp = values[0];
//			user.addRating(new Rating((int)(values[1]),values[2],(int)(values[3])));
//			userData.add(user);
//			
//		}
//		else {
//			temp = values[0];
//			userData.get((int) (temp-1)).addRating(new Rating((int)(values[1]),values[2],(int)(values[3])));
//			
//		}
//		
//		
//		
//		
//		
//	}
	
	
//	for(User m : userData) {
//	System.out.println(m);	}
////
	
	
	
	
	
	
	

//	for(Movie m : movieData) {
//		System.out.println(m);
//	}


	}

}


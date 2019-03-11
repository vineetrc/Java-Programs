import java.util.ArrayList;

public class User implements Comparable<User>{

	private int id;
	ArrayList<Rating> ratings;
	ArrayList<Tag> tags;

	public User(int id) {

		this.id=id;
		ratings = new ArrayList<Rating>();
		tags = new ArrayList<Tag>();
	}

	public void addRating(Rating rating) {

		ratings.add(rating);


	}
	public void addTag( Tag tag) {
		tags.add(tag);
	}
	
	public double getavgUserRating() {
		double total = 0;
		if(ratings.size()>=1) {
			
			for(int i = 0; i<ratings.size();i++) {
				total += ratings.get(i).getRating();
				
			}
			return total/ratings.size();
		}
		
		return 3.5;
	}
	
	

	public double avgYear(ArrayList<Movie> movieData) {

		int year = 0;

		if(ratings!=null) {
			for(int i = 0; i<ratings.size();i++) {
				for(int j = 0; i<movieData.size();j++) {

					if(ratings.get(i).getmovieID() == movieData.get(j).getMovieID()) {
						year+= movieData.get(i).getYear();


					}

				}



			}


			return year/ratings.size();

		}

		return -1;

	}




	public ArrayList<Rating>  getRatings(){
		return ratings;



	}

	public double[] getGenreRatings(ArrayList<Movie> data){

		double[] genreRating = new double[19] ;


		for(int i = 0 ; i<data.size();i++) {

			for(int j = 0 ; i<ratings.size();j++) {


				if(data.get(i).getMovieID() == ratings.get(j).getmovieID()) {

					for(int k = 0 ; k<data.get(i).getGenres().length;i++) {

						if(data.get(i).getGenres()[i].equals("Action")) {

							genreRating[0] += data.get(i).getavgRating();

						}
						if(data.get(i).getGenres()[i].equals("Adventure")) {

							genreRating[1] += data.get(i).getavgRating();

						}
						if(data.get(i).getGenres()[i].equals("Animation")) {

							genreRating[2] += data.get(i).getavgRating();

						}
						if(data.get(i).getGenres()[i].equals("Children")) {

							genreRating[3] += data.get(i).getavgRating();
						}

						}if(data.get(i).getGenres()[i]=="Comedy") {

							genreRating[4] += data.get(i).getavgRating();

						}if(data.get(i).getGenres()[i]=="Crime") {

							genreRating[5] += data.get(i).getavgRating();

						}if(data.get(i).getGenres()[i]=="Documentary") {

							genreRating[6] += data.get(i).getavgRating();

						}if(data.get(i).getGenres()[i]=="Drama") {

							genreRating[7] += data.get(i).getavgRating();

						}if(data.get(i).getGenres()[i]=="Fantasy") {

							genreRating[8] += data.get(i).getavgRating();

						}if(data.get(i).getGenres()[i]=="Film-Noir") {

							genreRating[9] += data.get(i).getavgRating();

						}if(data.get(i).getGenres()[i]=="Horror") {

							genreRating[10] += data.get(i).getavgRating();

						}if(data.get(i).getGenres()[i]=="Musical") {

							genreRating[11] += data.get(i).getavgRating();

						}if(data.get(i).getGenres()[i]=="Mystery") {

							genreRating[12] += data.get(i).getavgRating();

						}if(data.get(i).getGenres()[i]=="Romance") {

							genreRating[13] += data.get(i).getavgRating();

						}if(data.get(i).getGenres()[i]=="Sci-Fi") {

							genreRating[14] += data.get(i).getavgRating();

						}if(data.get(i).getGenres()[i]=="Thriller") {

							genreRating[15] += data.get(i).getavgRating();

						}if(data.get(i).getGenres()[i]=="War") {

							genreRating[16] += data.get(i).getavgRating();

						}if(data.get(i).getGenres()[i]=="Western") {

							genreRating[17] += data.get(i).getavgRating();

						}if(data.get(i).getGenres()[i]=="n/a") {

							genreRating[18] += data.get(i).getavgRating();

						}
					}


					
					
					
					
					
					
					


					//				Action
					//				* Adventure
					//				* Animation
					//				* Children's
					//				* Comedy
					//				* Crime
					//				* Documentary
					//				* Drama
					//				* Fantasy
					//				* Film-Noir
					//				* Horror
					//				* Musical
					//				* Mystery
					//				* Romance
					//				* Sci-Fi
					//				* Thriller
					//				* War
					//				* Western
					//				* (no genres listed)
				}

			}
		
		
		for(int  i = 0; i<genreRating.length; i++) {
			
			genreRating[i] /= ratings.size();
			
		}
		
		
		return genreRating;

		}

		







	public String toString() {


		//		String result= "ID:" + this.id + "Ratings";
		//
		//		for(int i = 0; i<ratings.size(); i++) {
		//
		//			result += ratings.get(i).toString();
		//
		//
		//		}
		//
		//
		//		return result;

		String result= "ID:" + this.id + "Tags";


		if(tags!=null) {

			for(int i = 0; i<tags.size(); i++) {

				result += tags.get(i).toString();


			}
		}

		return result;


	}

	@Override
	public int compareTo(User o) {
		if(id>o.id) {
			return 1;
		}
		if(id<o.id) {
			return -1;
		}
		else {
			
			return 0;
		}
	}





}

import java.util.ArrayList;

public class MovieLensCSVTranslator {


	private Movie parseMovie(String line) {


		String[] genres;
		int index  = line.indexOf(",");
		int index2 = line.lastIndexOf(",");
		if(line.substring(index2+1).equals("(no genres listed)")) {
			genres =null;
			line= line.substring(0, index2);
		}
		else {
			genres = line.substring(index2+1).split("\\|");

		}





		int year = Integer.parseInt(line.substring(line.lastIndexOf("(")+1,line.lastIndexOf("(")+5));
		int movieId = Integer.parseInt(line.substring(0, index));
		String title;
		if(line.indexOf("(") ==-1||line.indexOf(")") ==-1) {
			title = line.substring(index+1,index2);
			year = -1;
		}
		else {
			title = line.substring(index+1, line.lastIndexOf("("));
		}
		if(title.charAt(0)=='"' ) {
			title = title.substring(1);
		}
		if(title.charAt(title.length()-1)=='"' ) {
			title = title.substring(0,title.length()-1)+ " ";
		}

		if(!((title.charAt(title.length()-1)) == ' ')){
			title +=" ";

		}




		return new Movie(title,movieId,genres,year);


		//Extract peices of data from line
		//by looking for commas

		//construct a movie object

		//return the object 




	}

	private Movie parseMovieLinks(String line,Movie m) {


		int index  = line.indexOf(",");
		int index2 = line.lastIndexOf(",");

		int[] result = new int[3];

		result[0] = Integer.parseInt(line.substring(0, index));
		String result1= line.substring(index+1,index2 );

		if(!line.substring(index2+1).equals(""))
			result[2]=Integer.parseInt(line.substring(index2+1));

		else
			result[2]=-1;

		m.setimbID(result1);
		m.settmbID(result[2]);
		
		return m;



	}

	private double[] parseMovieRatings(String line) {


		int index  = line.indexOf(",");
		int index2 = line.indexOf(",", index+1);
		int index3  = line.indexOf(",", index2+1);
		
		double[] result = new double[4];

		 result[0] = Integer.parseInt(line.substring(0, index));
		result[1]= Integer.parseInt(line.substring(index+1,index2 ));
		result[2] = Double.parseDouble(line.substring(index2+1, index3));
		result[3]= Integer.parseInt(line.substring(index3+1));

		


		return result;



	}
	public String[] parseMovieTags(String line) {


		int index  = line.indexOf(",");
		int index2 = line.indexOf(",", index+1);
		int index3  = line.lastIndexOf(",");
		
		String[] result = new String[4];

		 result[0] = line.substring(0, index);
		result[1]= line.substring(index+1,index2 );
		result[2] = line.substring(index2+1, index3);
		
		if(result[2].charAt(0) == '"') {
			
			result[2] = result[2].substring(1, result[2].length()-1);
		}
		
		result[2] = result[2].replace("\"\"", "\"");
		
		result[3]= line.substring(index3+1);

		return result;






	}
	
	
	
	
	public ArrayList<Movie> extractMovies(ArrayList<String> movieStrings ,ArrayList<String> movieStringsLinks){
		ArrayList<Movie> movieData = new ArrayList<Movie>();
		
		for(int i =1; i<movieStrings.size();i++) {
			Movie m = parseMovie(movieStrings.get(i));
			m = parseMovieLinks(movieStringsLinks.get(i),m);
			movieData.add(m);
			
			
			
		}
		
		return movieData;
		
	}

	public ArrayList<User> extractUsers(ArrayList<String> movieStringsRatings,ArrayList<String> movieStringsTags){
		
		ArrayList<User> userData = new ArrayList<User>();
		
		double temp = 0;
		for(int i =1; i<movieStringsRatings.size();i++) {
			
				double[] values = parseMovieRatings(movieStringsRatings.get(i));
				
				
				
			if(values[0]!=temp) {			
				User user= new User((int) values[0]);
				temp = values[0];
				user.addRating(new Rating((int)(values[1]),values[2],(int)(values[3])));
				userData.add(user);
				
			}
			else {
				temp = values[0];
				userData.get((int) (temp-1)).addRating(new Rating((int)(values[1]),values[2],(int)(values[3])));
				
			}
			
			
		}
		
		
		
		
		
		for(int i =1; i<movieStringsTags.size();i++) {
			
			Tag userTag;
			String[] result =parseMovieTags(movieStringsTags.get(i));
			
			
			int userID = Integer.parseInt(result[0]);
			int movieID = Integer.parseInt(result[1]);
			String tag = result[2];
			int timestamp = Integer.parseInt(result[3]);
			
			userTag=new Tag(movieID,tag,timestamp);
			
			
			userData.get(userID-1).addTag(userTag);
			
			//System.out.println("UserID:" + result[0]+ " movieID:" + result[1]+"tag:" + result[2]+ " timestamp:" + result[3]);
			
			
		}
		
		
		
		
		
		
		
		
		return userData;
		
		
		
	}




}

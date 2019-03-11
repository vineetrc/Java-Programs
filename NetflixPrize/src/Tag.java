
public class Tag {

	private int movieID;
	private String tag;
	private int timestamp;
	
	
	public Tag(int m,String s,int t) {
		movieID = m;
		tag = s;
		timestamp = t;
		
		
	}
	
	public String toString() {
		
		String result = " [movieID:" + this.movieID + ", tag: " + this.tag + "timestamp: " + this.timestamp+"] " ;
		
		return result;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

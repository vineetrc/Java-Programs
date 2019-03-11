

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import processing.core.PApplet;
import processing.core.PImage;

public class DrawingMovie {

	private Movie movie;
	private PImage coverArt;
	
	public DrawingMovie(Movie m) {
		this.movie = m;
		coverArt = null;
	}
	
	public void draw(PApplet drawer, float x, float y, float width, float height) {
		if (movie != null) {
			if (coverArt != null) {
				drawer.image(coverArt, x, y,width,height);
			}
			
			String title = movie.getTitle();
			drawer.text(title, x + 30, y);
		}
		drawer.stroke(0);
		drawer.noFill();
		drawer.rect(x, y, width, height);
	}
	

	public void downloadArt(PApplet drawer) {
		
		Thread downloader = new Thread(new Runnable() {

			@Override
			public void run() {
				
				Scanner scan = null;
				// Find the cover art using IMDB links
				// Initialize coverArt
				try {
				String link = "0114709";
				
				String pageURLString = "http://www.imdb.com/title/tt"+ movie.getImbd()+"/";
				
				
				
				URL pageURL = new URL(pageURLString);
				
				InputStream is =  pageURL.openStream();
				
				 scan = new Scanner(is);
				
				String fileData = "";
				
				while(scan.hasNextLine()){
					
					String line  = scan.nextLine();
					fileData+=line;
				}
				
				
				System.out.println(fileData);
				
				
				
				int urlB = fileData.indexOf("src=\"", fileData.indexOf("<div class=\"poster\">"));
				urlB +=5;
				int urlF = fileData.indexOf("\"", urlB);
				
				
				
				
				
				
				
				
				
				//look for <dic class="poster">
				//look for src="
				//look for "
				
				String imageURL=fileData.substring(urlB, urlF);
				
				coverArt = drawer.loadImage(imageURL);
				
			}catch(IOException e){
				
				e.printStackTrace();
			}finally {
				
				if(scan!=null) {
					scan.close();
					
				}
				
				
			}
			
		}
			
			
		});
		
		downloader.start();

	}

	
}

import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
//		int[] arr = new int[50000];
//		int[] arr1 = {6,2,1,3,5,8,7};
//		for(int n =0; n<arr.length; n++) {
//			arr[n] = (int) (Math.random()*50000 +.5);
//
//		}
//
//		long startTime = System.currentTimeMillis();
//

//		for(int j = 0 ; j<arr.length-j; j++)
//			for(int i =1; i<arr.length; i++) {
//
//				if(arr[i]<arr[i-1]) {
//					int temp = arr[i];
//					arr[i] = arr[i-1];
//					arr[i-1] = temp;
//
//				}
//
//			}



//		System.out.println(Arrays.toString(selectionSort(arr1)));
//
//
//		long endTime = System.currentTimeMillis();
//		long time = (endTime-startTime);
//		long mins = time/60000;
//		long secs = time%60000/1000;
//		long millis = time % 1000;
//
//		//System.out.println(mins+":"+ secs+":"+millis);



		
		System.out.println("crypt");
		
		StringBuffer cipher = null;;

		//cipher[0] =  new StringBuffer("abcdefghijklmnopqrstuvwxyz");

		cipher = new StringBuffer("hippopotamus");
		int len = cipher.length();
		for(int i=0;i<len;i++) {
			while(cipher.indexOf(Character.toString(cipher.charAt(i))) != cipher.lastIndexOf(Character.toString(cipher.charAt(i)))){
		        cipher.deleteCharAt(cipher.lastIndexOf(Character.toString(cipher.charAt(i))));
		        len--;
		        //System.out.println(cipher);
			}
		}
		
		for(int j=0;j<26;++j) {
			int ch = 'z'-j;
			if(cipher.indexOf(Character.toString((char)ch)) == -1 ) {
			  cipher.append(Character.toString((char)ch));
			}
		}
		System.out.println(cipher);
		
		//test
		String line = "This is the 100th Etext file presented by Project Gutenberg, and\r\n" + 
				"				is presented in cooperation with World Library, Inc., from their\r\n" + 
				"				Library of the Future and Shakespeare CDROMS.  Project Gutenberg\r\n" + 
				"				often releases Etexts that are NOT placed in the Public Domain!!";
	
		System.out.println(line);
		//Encrypt
		StringBuffer linebuf = new StringBuffer(line);
		for(int k=0;k<line.length();++k) {
			
			if(Character.isUpperCase(linebuf.charAt(k))) {
				int index = Character.toLowerCase(linebuf.charAt(k))-'a';
				if(index >=0 && index<26)
				  linebuf.replace(k,k+1,Character.toString(Character.toUpperCase(cipher.charAt(index))));
				
			}
			int index = linebuf.charAt(k)-'a';
			if(index >=0 && index<26)
			  linebuf.replace(k,k+1,Character.toString(cipher.charAt(index)));
		}
		System.out.println(linebuf);
		
		//Decrypt
		for(int k=0;k<line.length();++k) {
			
			if(Character.isUpperCase(line.charAt(k))) {
				
				int index = cipher.indexOf(Character.toString(Character.toLowerCase(linebuf.charAt(k))));
				if(index >=0 && index<26)
				  linebuf.replace(k,k+1,Character.toString(Character.toUpperCase(((char)('a'+index)))));
			}
			else {
			int index = cipher.indexOf(Character.toString(linebuf.charAt(k)));
			if(index >=0 && index<26)
			  linebuf.replace(k,k+1,Character.toString((char)('a'+index)));
			}
		}
		System.out.println(linebuf);

	}



	
	
	
	
	
	
	public static int[] selectionSort(int[] arr) {

		int least;
		for(int j = 0 ; j<arr.length; j++) {
			 least = j;
			for(int i = j+1 ; i<arr.length; i++) {
				
				if(arr[i]<arr[least]) {
					least =i;


				}

				if(i==arr.length-1) {
				
				int temp = j;
				arr[j] = least;
				arr[i] = temp;
				}
				
			}

		}
		return arr;
	}
	
	
}


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * This class encrypts and decrypts text files using one of 3 algorithms:
 * 		Random monoalphabet, Vigenere, or Playfair
 * 
 * 
 * @author
 * @version
 * 
 */
public class Crypt {
	public static final String lineSeparator = System.getProperty("line.separator");


	/**
	 * 
	 * An integer representing the algorithm chosen.
	 * Set to:
	 * 1 for random monoalphabet
	 * 2 for Vigenere
	 * 3 for Playfair
	 * 
	 */
	public static final int algorithm = 1;


	/**
	 * Reads from the file specified, and writes out an encrypted version of the file. If the output file already
	 * exists, overwrite it.
	 * 
	 * @param inputFilename The path of the file to be encrypted.
	 * @param outputFilename The path of the encrypted file to be saved.
	 * @param keyword The keyword to be used in the encryption algorithm.
	 * 
	 */
	public void encrypt(String inputFilename, String outputFilename, String keyword) 
	{




		Scanner scan = null;
		FileWriter writer = null;
		BufferedWriter bWriter = null;
		StringBuffer cipher = null;;
		BufferedReader bReader = null;

		
		StringBuffer keyWord = new StringBuffer(keyword);
		//keyWord.append(keyword);

		for(int i =1 ;i<keyWord.length();i++) {

			if(keyWord.toString().charAt(i) ==keyWord.toString().charAt(i-1) ) {


				keyWord.deleteCharAt(i);
				i--;

			}

			cipher = new StringBuffer(keyWord);	

			for(int j=0;j<26;++j) {
				int ch = 'z'-j;
				if(cipher.indexOf(Character.toString((char)ch)) == -1 ) {
					cipher.append(Character.toString((char)ch));
				}
			}

			int len = cipher.length();
			for(int n=0;n<len;n++) {
				while(cipher.indexOf(Character.toString(cipher.charAt(n))) != cipher.lastIndexOf(Character.toString(cipher.charAt(n)))){
					cipher.deleteCharAt(cipher.lastIndexOf(Character.toString(cipher.charAt(n))));
					len--;
					//System.out.println(cipher);
				}
			}

		}
		try {
			FileReader reader = new FileReader(inputFilename);
			 bReader = new BufferedReader(reader);
			scan = new Scanner(bReader);


			writer = new FileWriter(outputFilename);
			bWriter = new BufferedWriter(writer);

			

			while(true) {
				String line = bReader.readLine();
				if(line==null) {
					break;
				}

				//encrypt the line


				//cipher[0] =  new StringBuffer("abcdefghijklmnopqrstuvwxyz");

				//cipher = new StringBuffer(keyWord);



				StringBuffer linebuf = new StringBuffer(line);
				for(int k=0;k<line.length();++k) {

					if(Character.isUpperCase(linebuf.charAt(k))) {
						int index = Character.toLowerCase(linebuf.charAt(k))-'a';
						if(index >=0 && index<26)
							linebuf.replace(k,k+1,Character.toString(Character.toUpperCase(cipher.charAt(index))));

					}

					else {
						int index = linebuf.charAt(k)-'a';
						if(index >=0 && index<26)
							linebuf.replace(k,k+1,Character.toString(cipher.charAt(index)));
					}
				}


				bWriter.write(linebuf.toString());
				bWriter.write(lineSeparator);


			}
		}catch(IOException e){


			e.printStackTrace();

		}finally {

			if(scan!=null)
				scan.close();

			try {

				if(bWriter!=null)
					bWriter.close();
				if(bReader!=null)
					bReader.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}









	}


	/**
	 * Reads from the (previously encrypted) file specified, and writes out a decrypted version of the file. 
	 * If the output file already exists, overwrite it.
	 * 
	 * @param inputFilename The path of the encrypted file.
	 * @param outputFilename The path of the decrypted file to be saved.
	 * @param keyword The keyword to be used in the decryption algorithm.
	 * 
	 */
	public void decrypt(String inputFilename, String outputFilename, String keyword) 
	{

		Scanner scan = null;
		FileWriter writer = null;
		BufferedWriter bWriter = null;
		StringBuffer cipher = null;;
		BufferedReader bReader = null;

		StringBuffer keyWord = new StringBuffer(keyword);
		


		for(int i =1 ;i<keyWord.length();i++) {

			if(keyWord.toString().charAt(i) ==keyWord.toString().charAt(i-1) ) {


				keyWord.deleteCharAt(i);
				i--;

			}

			cipher = new StringBuffer(keyWord);
			for(int j=0;j<26;++j) {
				int ch = 'z'-j;
				if(cipher.indexOf(Character.toString((char)ch)) == -1 ) {
					cipher.append(Character.toString((char)ch));
				}
			}


			int len = cipher.length();
			for(int n=0;n<len;n++) {
				while(cipher.indexOf(Character.toString(cipher.charAt(n))) != cipher.lastIndexOf(Character.toString(cipher.charAt(n)))){
					cipher.deleteCharAt(cipher.lastIndexOf(Character.toString(cipher.charAt(n))));
					len--;
					//System.out.println(cipher);
				}
			}
		}
		try {
			FileReader reader = new FileReader(inputFilename);
			 bReader = new BufferedReader(reader);
			scan = new Scanner(bReader);


			writer = new FileWriter(outputFilename);
			bWriter = new BufferedWriter(writer);



			while(true) {
				String line = bReader.readLine();
				if(line==null) {
					break;
				}


				//encrypt the line


				//cipher[0] =  new StringBuffer("abcdefghijklmnopqrstuvwxyz");

				//cipher = new StringBuffer(keyWord);



				StringBuffer linebuf = new StringBuffer(line);
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


				bWriter.write(linebuf.toString());
				bWriter.write(lineSeparator);


			}
		}catch(IOException e){


			e.printStackTrace();

		}finally {

			if(scan!=null)
				scan.close();

			try {

				if(bWriter!=null)
					bWriter.close();
				if(bReader!=null)
					bReader.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}



}

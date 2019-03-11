import java.util.Scanner;


public class RecursiveStringTools {

	// Example
	public static int length(String in) {
		if(in.isEmpty()){

			return 0;

		}
		else {

			return length(in.substring(1))+1;

		}

	}



	// Example
	public static boolean equals(String in1, String in2) {

		if (in1.length() != in2.length()) {
			return false;
		} else if (in1.length() == 0 && in2.length() == 0) {
			return true;
		} else {
			boolean eq = in1.charAt(0) == in2.charAt(0);
			String str1 = in1.substring(1);
			String str2 = in2.substring(1);
			return eq && equals(str1,str2);
		}
	}


	// Exercise #1
	public static boolean matches(String in1, String in2) {

		if (in1.length() != in2.length()) {
			return false;
		} else if (in1.length() == 0 && in2.length() == 0) {
			return true;
		} else {
			boolean eq = false;
			
			if(in1.charAt(0) == '?' || in2.charAt(0) == '?') {
				eq = true;
				
			}
			else {
				eq = (in1.charAt(0) == in2.charAt(0)); 
				//System.out.println(eq);
			}
			String str1 = in1.substring(1);
			String str2 = in2.substring(1);
			return eq && matches(str1,str2);		
		}


	}



	// Exercise #2
	public static boolean isPalindrome(String str) {



		if(str.length() < 2) {
			return true;
		}

		
		if(str.charAt(0) != str.charAt(str.length() - 1)){
			return false;
		}

		
		return isPalindrome(str.substring(1, str.length() - 1));



	}

//java
// j ava
	// a jva
	//v jvaa
	//a jav
	
	
	static public void printPermutations(String input)
	{
		printPermutations("", input);
	}
	
	private static void printPermutations(String charHolder, String in)
	{	
		if(in.length() == 0)
		{
			System.out.println(charHolder);
		}
		else
		{
			forLoop(0, in.length(), charHolder, in);
		}
	}
	
	
	
	
	

	// Exercise #3
//	
		
		
	
	
	
	private static void forLoop(int i, int n,String permutation, String input) {
		
		if(i>=n) {
			
			return;
			
		}
		
		else
			printPermutations(permutation+input.charAt(i), input.substring(0, i)+input.substring(i+1, input.length()));

			i++;
			forLoop(i,n, permutation,input);
		
	}
	
	
	
	
	
	
	
	



	public static String piglatinate(String in) {
		return "";
	}



	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		System.out.println("Please enter a string:");
		String s = kboard.nextLine();
		//String c = kboard.nextLine();
	     RecursiveStringTools.printPermutations(s);;
		//System.out.print("\n\nThe result is --> " + out + "\n\n");
	}
}

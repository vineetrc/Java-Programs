/**
 * @(#)Fibonacci.java
 *
 *
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fibonacci {

	//20th Fibonacci number is 6765
	public static long computeFibonacci(int x) {
		
		if(x<0) {
			
			throw new IllegalArgumentException("");
			
			
		}
		if (x <= 1) {
			return x;
		} else {
			long answer = computeFibonacci(x-2) + computeFibonacci(x-1);
			return answer;
		}
		

	}

	public static void main (String[] args) {
		
		
		try {
		
		Scanner kboard = new Scanner (System.in);
		System.out.print("Which fibonacci number would you like to find? --> ");
		int x = kboard.nextInt();
		long answer = computeFibonacci(x);
		System.out.println ("The " + x + " fibonacci number is " + answer + ".");
		}
		
		catch(InputMismatchException ex) {
			System.out.println ("bad input. Try again");
			main(args);
			
		}
		catch(StackOverflowError ex) {
			System.out.println ("ran out of memory. Try a different input");
			main(args);
			
		}
		catch(IllegalArgumentException ex) {
			System.out.println ("number can't be negative");
			main(args);
			
		}
		
		
	}

}




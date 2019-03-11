
/*
 * Puzzle Size:1	2	3	4	5	6	7	8	9	10
 * Iterations :1	3	7	15	31	63	127	255	511	1023
 * 
 * Equation:2^(PuzzleSize)-1 = iterations
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class RecursionPractice {


	public static int iterations;



	public static int triangleNumber(int n)
	{
		if (n == 1)
			return 1;
		else
			return n + triangleNumber(n-1);
	}


	public static int squareNumber(int n) {
		if (n == 1)
			return 1;
		else
			return squareNumber(n-1) +2*n-1;

	}


	public static int logBase2(int n) {

		if (n == 1)
			return 0;
		else
			return 1 + logBase2(n/2);



	}


	public static int pow(int n) {

		if(n ==1)
			return 1;

		else

			return 2*pow(n-1);
	}


	public static int pentagonalNumber(int n) {

		if(n ==1)
			return 1;

		else

			return  pentagonalNumber(n-1) + n*3 -2  ;
	}

	public static int recursiveFib(int n){
		iterations ++;


		if(n==0)
			return 0;

		else if(n==1)
			return 1;

		else
			return recursiveFib(n-1)+ recursiveFib(n-2);


	}

	public static int loopFib(int n){
		int fib = 0;
		int grandFib = 1;
		int parentFib = 1;

		if(n==0)
			return 0;

		else if(n==1)
			return 1;
		else {
			for(int i = 2; i<n;i++) {
				fib = parentFib + grandFib;
				grandFib = parentFib;
				parentFib = fib;


			}

		}

		return fib;
	}


	public static void printHanoiSolution(int numOfDisks) {

						 printHanoiSolution1(numOfDisks,1,3);

	}

	private static void printHanoiSolution1(int numOfDisks, int fromPeg, int toPeg) {
		iterations ++;
				if(numOfDisks == 1){
					
					System.out.println("Move disk from "+fromPeg+ " to " + toPeg);
					
				}
				
				else {
					
					int holderPeg = 6-(fromPeg + toPeg);
				printHanoiSolution1(numOfDisks-1,fromPeg,holderPeg);
				System.out.println("Move disk from "+fromPeg+ " to " + toPeg);
				printHanoiSolution1(numOfDisks-1,holderPeg,toPeg);

				}
	}



	public static void main(String[] args) {

		iterations = 0;


		int n = 5;
		printHanoiSolution(3);
		System.out.println(iterations);
		
	}


}

public class Statistics {

	private int[] data;
	private int realLength;

	public Statistics(int maxLength) {

		data =  new int[maxLength];


	}

	public void readData(String filename) {

		ArrayReader reader = new ArrayReader(filename);
		realLength = reader.fillArray(data);

	}



	public void printData() {

		for(int i = 0; i<realLength; i++) {


			System.out.println(data[i]);

		}


	}
	public double printAvg(){
		int total = 0;

		//		for(int x: data) {
		//			total+=x;
		//
		//
		//
		//		}
		//		return (double) (total)/data.length;

		for(int i = 0; i<realLength; i++) {


			total+=data[i];

		}

		return (double) (total)/realLength;


	}

	public double printSD() {
		double avg = printAvg();
		double total = 0;
		//		for(int x: data) {
		//			total+=Math.pow(x-avg, 2);
		//
		//
		//
		//		}
		for(int i = 0; i<realLength; i++) {


			total+=Math.pow(data[i]-avg, 2);

		}


		return Math.pow(total/(realLength-1), .5);




	}






	public int printMode() {

		int number = 0;
		int modeCounter = 0;
		int maxmode = 0;
		int numModes = 0 ;
		int index = 0;


		while(number<101) {


			for(int i = 0; i<realLength; i++) {
				if(number == data[i]) {


					modeCounter ++;
				}


			}
			if(modeCounter > maxmode) {


				maxmode = modeCounter;

				modeCounter =0;

				index = number;
				numModes ++;

			}


			else {
				modeCounter = 0;

			}


			number ++;

		}


		return index;


		//				int number = 0;
		//				int modeCounter = 0;
		//				int maxmode = 0;
		//				int numModes = 0 ;
		//				int mode = 0;
		//				int[] modeHolder = new int[1000];
		//		        int index = 0;
		//		        int[] finalMode ;
		//		
		//				while(number<101) {
		//		
		//		
		//					for(int i = 0; i<realLength; i++) {
		//						if(number == data[i]) {
		//		
		//		
		//							modeCounter ++;
		//						}
		//						
		//						 
		//					}
		//					if(modeCounter > maxmode) {
		//		
		//		                index = 0;
		//						maxmode = modeCounter;
		//		
		//						modeCounter =0;
		//		
		//						modeHolder = new int[1000];
		//						modeHolder[index] = number;
		//						numModes =1;
		//						index++;
		//		
		//					}
		//		
		//		
		//					else if(modeCounter < maxmode){
		//						modeCounter = 0;
		//		
		//					}
		//					else {
		//						
		//						modeHolder[index] = number;
		//						index++;
		//						modeCounter = 0;
		//						numModes++;
		//						
		//						
		//						
		//					}
		//		
		//		
		//					number ++;
		//		
		//				}
		//		
		//		
		//				
		//				
		//				finalMode = new int[numModes];
		//				
		//				
		//				for(int i = 0; i<numModes; i++) {
		//					
		//					finalMode[i] = modeHolder[i];
		//					
		//					
		//					
		//					
		//					
		//				}
		//				
		//				
		//				return finalMode;
		//		
		//		
		//		
		//		
		//		
		//
		//
		//
		//	}

	}




	// Precondition: data is non-null int array, size is the number of legitimate 
	// elements in data
	// Postcondition: Moves all non-zero integers to the front of the array data, leaving the 
	// order of integers otherwise unchanged. Returns the new number of legitimate data 
	// elements.
	public void compact() {

		int numZeros = 0;




//		for(int i = 0; i<realLength-numZeros; i++) {
//
//			if (data[i] == 0) {
//				
//				for(int j = i+1; j<realLength - numZeros; j++) {
//
//					data[j-1]= data[j] ;
//					if(j == (realLength - numZeros - 1)){
//						
//						data[j]=0;
//						
//					}
//					numZeros ++;
//
//				}
//

		
		
		for(int i = 0; i<realLength;i++) {
			
			
			if(data[i]!= 0) {
			
               
				int temp = data[i];
				data[i] = 0;
				data[numZeros] = temp;
				
				numZeros++;
				
			}
				
		}
		
		
		realLength -= numZeros;
		
		
		
		





			}




	

		


       












	}















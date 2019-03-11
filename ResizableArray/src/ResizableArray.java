import java.lang.reflect.Array;
import java.util.Arrays;

public class ResizableArray {

	private int[] data;
	private int size;
	private final int initialLength = 10;

	public ResizableArray() {

		data = new int [initialLength];
		size = 0;

	}


	public void add(int value) {


		if(size >= data.length) {


			resize();

		}


		data[size] = value;
		size++;



	}

	public void removeAll(int value) {

		int numValue = 0;
		for(int i = 0; i<size;i++) {


			if(data[i]!= value) {


				int temp = data[i];
				data[i] = value;
				data[numValue] = temp;

				numValue++;

			}

		}


		size -= numValue;

	}


	public String toString() {
//		String result = "[";
//
//		for (int i = 0; i<size - 1; i++) {
//
//
//			result+=data[i];
//			result += ",";
//
//
//		}
//
//
//		result+=data[size-1] + "]";
//
//		return result;
//
//
//
//	}
		
		
		int[] largerArray = new int[size]	;	

		for(int i = 0; i<size; i++) {

			largerArray[i] = data[i];






		}
		
		
		return Arrays.toString(largerArray);
		
		
		
		
	}

	public int size() {
		return size;

	}

	public int remove(int index) {


		if(index>=size) {

			throw new IllegalArgumentException("index is not valid");

		}


		for(int i = index; i<size-1; i++) {


			data[i] = data[i+1];

		}

		size = size-1;

		return data[index];


	}

	public  int indexOf(int value) {


		for(int i = 0; i<size; i++) {

			if(data[i] == value) {

				return i;
			}




		}
		return -1;





	}

	public void swap(int index1 , int index2) {

		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;




	}

	public void insert(int index, int value) {


		if(index > size) {
			
			throw new IllegalArgumentException("index is not valid");		
		}
		if(size == data.length) {
			resize();
		}
		//size = size+1;
		for(int i = size; i >index; i--) {


			data[i] = data[i-1];

		}
		data[index]= value;

		size = size+1;

	}




	private void resize() {


		int[] largerArray = new int[data.length+ initialLength]	;	

		for(int i = 0; i<data.length; i++) {

			largerArray[i] = data[i];






		}

		data = largerArray;
        //size+=initialLength;

	}

	public int get( int index ) {
		return data[index];





	}

	public void set ( int index, int value ) {

		data[index]=value;





	}
	public void sort ( ) {

//		for(int i = 0; i<data.length; i++) {
//
//			for(int j = 1; j<data.length; j++) {
//
//				if(data[j-1]>data[j]) {
//
//					this.swap(j,j-1);
//
//				}
//
//			}
//
//		}
		for (int i = 0; i<size; i++)
	    {
	        for (int j = 0; j<size; j++)
	        {
	            if (data[i] < data[j])
	            {
	                int temp = data[i];
	                data[i] = data[j];
	                data[j] = temp;
	            }
	        }
	    }

	}


	public boolean equals ( Object other ) {


		ResizableArray temp = (ResizableArray) other;

		if (temp.size != this.size) {

			return false;
		}

		else 
		{
			for(int i = 0; i<size; i++) {

				if (temp.get(i) != data[i]) {

					return false;


				}


			}
		}

		return true;


	}


	public int[] toArray() {


		int[] largerArray = new int[size]	;	

		for(int i = 0; i<data.length; i++) {

			largerArray[i] = data[i];

		}
		
		
		
		return largerArray;
		
	}




	//public void subArray(int startIndex)

	//public int[] toArray;

	//public void insert(int index, int value)


	//public boolean equals(Object other)

	//removeAtIndex
	// toString
	//findALl
	//clear
	//sortInOrder
	// indexof
	//shift
	//equals
	//reverse








}

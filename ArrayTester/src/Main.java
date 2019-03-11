
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
		
		Obj[] values = new Obj[3];
		values[0]= new Obj(5);
		values[1]= new Obj(32);
		values[2]= new Obj(9);

		for(Obj a : values) {
			
			values[2]= new Obj(60);
			
		}
		
       for(Obj a : values) {
			
			System.out.println(a);
			
		}
		
		
		
		
		
		
		
		
	}

}

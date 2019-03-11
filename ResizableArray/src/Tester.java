
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ResizableArray tester = new ResizableArray();
		
//		data.add(5);
//		data.add(6);
//		data.add(78);
//		data.add(69);
//		//data.sort();
////		data.remove(0);
//		data.insert(3, 3);
//		data.insert(6, 5);
////		//data.indexOf(78);
		tester.add(1);
		tester.add(3);
		tester.add(5);
		tester.add(7);
		tester.add(9);
		tester.add(11);
		tester.add(13);
		tester.insert(0,0);
		tester.insert(2,2);
		tester.insert(4,4);
		//System.out.println(tester);
		tester.insert(6,6);
		tester.insert(8,8);
		tester.insert(10,10);
		tester.insert(12,12);
	System.out.println(tester);
	int val = tester.get(1);
	tester.set(0,val);
	tester.remove(4);
	tester.remove(5);
	System.out.println(tester);
	tester.remove(5);
	System.out.println(tester);
	tester.remove(6);
	System.out.println(tester);
	tester.remove(6);
	System.out.println(tester);
	tester.remove(6);
	System.out.println(tester);
	tester.remove(6);
	
        
		System.out.println(tester);
	System.out.println(tester.size());

//		data.insert(2, 21);
//		System.out.println(data);
//		//System.out.println(data.indexOf(7));
		
		
		
	}

}

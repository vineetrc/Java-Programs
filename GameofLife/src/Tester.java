
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Life grid = new Life("gridData\\life tester.txt");
		System.out.println(grid);
		grid.step();
		grid.step();
		System.out.println(grid);
		System.out.println(grid.getNeighbors(19,19));
		
		
		
		
		
		
		
		
	}

}

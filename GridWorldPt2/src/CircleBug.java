
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class CircleBug extends Bug
{
	private int steps;
	private int sideLength;

	/**
	 * Constructs a box bug that traces a square of a given side length
	 * @param length the side length
	 */
	public CircleBug(int length)
	{
		steps = 0;
		sideLength = length;
	}



	public boolean canMove() {

		if(super.canMove()&& steps < sideLength) {
			return true;
		}else {
			return false;
		}
	}

	public void move()
	{


		super.move();
		steps++;

	}
	public void turn()
	{



		super.turn(); 

		steps=0;

	}


}

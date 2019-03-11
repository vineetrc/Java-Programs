

	import info.gridworld.actor.Bug;
	import info.gridworld.grid.Location;

	/**
	 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
	 * The implementation of this class is testable on the AP CS A and AB exams.
	 */
	public class ZBug extends Bug
	{
		private int steps;
		private int sideLength;
        private int turn = 0;
		/**
		 * Constructs a box bug that traces a square of a given side length
		 * @param length the side length
		 */
		public ZBug(int length)
		{
			steps = 0;
			sideLength = length;
		}

		/*
	    public void act()
	    {
	        if (steps < sideLength && canMove())
	        {
	            move();
	            steps++;
	        }
	        else
	        {
	            turn();
	            turn();
	            steps = 0;
	        }
	    }

		 */

		public boolean canMove() {

			if(super.canMove()&& steps < sideLength && turn<3) {
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

           if (turn == 0) {
            
			setDirection(getDirection() + Location.RIGHT + Location.HALF_RIGHT ); 
           }
           
           else if(turn == 1) {
        	   setDirection(getDirection() + 2*Location.RIGHT + Location.HALF_RIGHT );
           
		}
           
			steps=0;
			turn++;

		}


	}



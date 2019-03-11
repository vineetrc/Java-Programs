import info.gridworld.actor.Bug;

public class DancingBug extends Bug
{
	private int[] turns;
	private int ArrayCounter;

	public DancingBug(int[] turns)
	{
		this.turns = turns;
		ArrayCounter = 0;
	}

	public void act()
	{
		if((ArrayCounter < turns.length) && canMove())
		{
			for(int i=0; i<turns[ArrayCounter]; i++) {
				turn();

			}
			move();
			ArrayCounter++;
		}
		else
		{
			ArrayCounter = 0;
		}
	}
}

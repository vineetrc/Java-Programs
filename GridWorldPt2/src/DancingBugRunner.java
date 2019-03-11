
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;
public class DancingBugRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		int[] turns = {1,2,1};
		DancingBug bob = new DancingBug(turns);
		bob.setColor(Color.RED);
		world.add(new Location(5, 5), bob);
		world.show();
	}
} 
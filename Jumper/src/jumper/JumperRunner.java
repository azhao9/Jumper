package jumper;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.awt.Color;

public class JumperRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();

		Jumper jesseParks = new Jumper(Color.PINK);
		Jumper eaten = new Jumper(Color.CYAN);
		eaten.setDirection(Location.EAST);

		Jumper dodged = new Jumper(Color.MAGENTA);
		dodged.setDirection(Location.WEST);

		world.add(new Location(6, 4), jesseParks);
		world.add(new Location(4, 2), eaten);
		world.add(new Location(2, 7), dodged);

		world.add(new Location(3, 4), new Rock());
		world.add(new Location(2, 4), new Rock());

		world.add(new Location(0, 5), new Flower());
		world.add(new Location(0, 6), new Flower());

		world.add(new Location(0, 9), new Rock());

		world.add(new Location(8, 9), new Flower());
		world.add(new Location(9, 9), new Flower());

		world.add(new Location(9, 8), new Actor());
		world.add(new Location(9, 7), new Actor());

		world.show();
	}
}

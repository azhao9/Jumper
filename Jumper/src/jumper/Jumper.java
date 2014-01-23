package jumper;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;

public class Jumper extends Actor
{
	/**
	 * Constructs a Jumper with a specified color
	 * 
	 * @param color
	 *            the color of the Jumper
	 */
	public Jumper(Color color)
	{
		super();
		super.setColor(color);
	}

	/**
	 * makes the Jumper act
	 */
	public void act()
	{
		if (canMove())
			move();
		else
			turn();
	}

	/**
	 * turns the bug 45 degrees to the right
	 */
	public void turn()
	{
		super.setDirection(getDirection() + Location.HALF_RIGHT);
	}

	/**
	 * test first if grid is valid. then test if two spaces ahead is valid. if
	 * not, that space must be out of the grid, and then test if one space ahead
	 * is valid. if so, move there. otherwise, turn.
	 */
	public void move()
	{
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;

		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		Location second = next.getAdjacentLocation(getDirection());

		if (gr.isValid(second))
			moveTo(second);
		else if (gr.isValid(next))
			moveTo(next);
		else
			removeSelfFromGrid();
	}

	/**
	 * returns true if the jumper can move
	 * 
	 * @return true if the jumper can move
	 */
	public boolean canMove()
	{
		Grid<Actor> gr = getGrid();

		if (gr == null)
			return false;

		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());

		if (!gr.isValid(next))
			return false;

		return true;
	}
}

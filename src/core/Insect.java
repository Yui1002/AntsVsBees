package core;

/**
 * Represents an insect (e.g., an Ant or a Bee) in the game
 * @author Joel
 * @version Fall 2014
 */
public abstract class Insect
{
	protected int armor; //insect's current armor
	protected Place place; //insect's current location
	protected boolean watersafe;
	
	/**
	 * Creates a new Insect with the given armor in the given location
	 * @param armor The insect's armor
	 * @param place The insect's location
	 */
	public Insect(int armor, Place place)
	{
		if(armor <= 0)
			throw new IllegalArgumentException("Cannot create an insect with armor of 0");
		this.armor = armor;
		this.place = place;
		this.watersafe = false;
	}
	
	/**
	 * Creates an Insect with the given armor. The insect's location is null
	 * @param armor The insect's armor
	 */
	public Insect(int armor)
	{
		this(armor, null);
	}
		
	/**
	 * Set's the insect's current location
	 * @param place The insect's current location
	 */
	public void setPlace(Place place)
	{
		this.place = place;
	}
	
	/**
	 * Return's the insect's current location
	 * @return the insect's current location
	 */
	public Place getPlace()
	{
		return this.place;
	}

	/**
	 * Returns the insect's current armor
	 * @return the insect's current armor
	 */
	public int getArmor()
	{
		return this.armor;
	}

	/**
	 * Returns whether the insect is watersafe or not
	 * @returns whether the insect is watersafe or not
	 */
	public boolean getWatersafe() 
	{
		return this.watersafe;
	}
	
	/**
	 * Reduces the insect's current armor (e.g., through damage)
	 * @param amount The amount to decrease the armor by
	 */
	public void reduceArmor(int amount)
	{
		this.armor -= amount;
		if(this.armor <= 0)
		{
			System.out.println(this+" ran out of armor and expired");
			leavePlace();
		}
	}
	
	/**
	 * Has the insect move out of its current location. Abstract in case the insect takes action when it leaves
	 */
	public abstract void leavePlace();

	/**
	 * The insect takes an action on its turn
	 * @param colony The colony in which this action takes place (to support wide-spread effects)
	 */
	public abstract void action(AntColony colony);
	
	public String toString()
	{
		return this.getClass().getName()+"["+armor+", "+place+"]"; //supports inheritance!
	}
}

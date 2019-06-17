package Bag_application;

public class Product {

	private String name;
	private long id;
	private double weight;
	public String toString()
	{
		return id + ": " + name + ", weight: " + weight + " gr.";
	}
	public long getId ()
	{
		return this.id;
	}
	
	public void setId (long newId)
	{
		this.id=newId;
	}
	
	public String getName ()
	{
		return this.name;
	}
	public void setName (String newName)
	{
		this.name=newName;
	}
	
	public double getWeight()
	{
		return this.weight;
	}
	public void setWeight (double newWeight)
	{
		this.weight=newWeight;
	}
	
	public Product(long newId, String newName, double newWeight) 
	{
		id=newId; 
		name=newName; 
		weight=newWeight;
	}

}

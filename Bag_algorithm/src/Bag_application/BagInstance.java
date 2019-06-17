package Bag_application;

import java.util.ArrayList;
import java.util.Comparator;

public class BagInstance 
{
	public ArrayList<Product> productsList = new ArrayList<Product>();
	private double sumWeight=0;
	
	public double getWeight()
	{
		return this.sumWeight;
	}
	public void setWeight (double newWeight)
	{
		this.sumWeight=newWeight;
	}
	
	   public static Comparator<BagInstance> compareByWeight() 
	   {
		      return new Comparator<BagInstance>() 
		      {
		         public int compare(BagInstance i1, BagInstance i2) 
		         {
		            return Double.compare(i2.getWeight(), i1.getWeight());
		         }
		      };
	   }
}


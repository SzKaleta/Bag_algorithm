package Bag_application;

import java.util.ArrayList;
import java.util.List;

public class BagAlgorithm {
	
	ArrayList<BagInstance> bags =  new ArrayList<BagInstance>();
	
	public void solve(List<Product> items, double weight)
	{
		while(!items.isEmpty())
		{
			List<BagInstance> variance =  variances(items, weight);
			variance.sort(BagInstance.compareByWeight());
			bags.add(variance.get(0));
			for(Product prod : variance.get(0).productsList)
			{
				items.remove(prod);
			}
		}
	}
	
	public String toString(int index)
	{
	BagInstance inst =bags.get(index);
	index++;
	String returnString= "(" + index + "): ";
		
			for(Product prod : inst.productsList)
			{
				returnString= returnString+prod.getId() + ", ";
			}
			returnString= returnString+ "weight: " + inst.getWeight() + "\n";
			return returnString;		
	}
	
	private List<BagInstance> variances(List<Product> items, double weight) 
	   {
		   
		      List<BagInstance> mySets = new ArrayList<BagInstance>();
		      if (items.isEmpty()) 
		      {
		         mySets.add(new BagInstance());
		         return mySets;
		      }
		      
		      Product first = items.get(0);
		      List<BagInstance> instance = variances(items.subList(1, items.size()), weight);
		      for (BagInstance mySet : instance) 
			      {
		    	  	if((mySet.getWeight()<weight) && (!mySets.contains(mySet))) mySets.add(mySet);
			         		BagInstance newSet = new BagInstance();
				        		newSet.productsList.addAll(mySet.productsList);
				        		newSet.productsList.add(0, first);
				        		for(Product p: newSet.productsList)
				        		{				        			
				        			newSet.setWeight(newSet.getWeight()+p.getWeight());
				        		}
				    if((newSet.getWeight()<weight) && (!mySets.contains(newSet))) mySets.add(newSet);
			   }
		      return mySets;
	   } 
	public ArrayList<BagInstance> getBagsList()
	{
		return bags;
	}
	
	public void setBagsList (ArrayList<BagInstance> bagsNew)
	{
		this.bags=bagsNew;
	}
}

package Test_algorithm;

import Bag_application.*;

import java.util.ArrayList;
import java.util.Arrays;


import org.junit.Test;
import static org.junit.Assert.*;



public class Test_instance 
{
	
double testWeight=3000;
	
Product [] data1={
	 new Product(100154011, "Organic Chicken Breast Fillets",375),
	 new Product(20001011, "Parsnips", 750),
	 new Product(20001011, "Parsnips", 750),
	 new Product(207619011, "Smoked Back Bacon Twin Pack", 300),
	 new Product(207619011, "Smoked Back Bacon Twin Pack", 300),
	 new Product(207934011, "Lean Beef Steak Mince 5% Fat",250)
	 };
    
Product [] data2={
		 new Product(56967011, "British Whole Chicken Medium", 1400),
		 new Product(241714011, "Whole Peeled Pineapple",600),
		 new Product(56967011, "British Whole Chicken Medium", 1400),
		 new Product(81851011, "Shallots",400),
		 new Product(241714011, "Whole Peeled Pineapple",600),
		 new Product(65344011, "Brussels Sprouts",750)
		 };





double [] feedback1 = { 2725};
double [] feedback2 = { 2800.0, 2350.0};
		

private final double DELTA = 1e-15;

@Test
public void testCorrectMyValues() 
{
    ProductsRead test = new ProductsRead();
    
  
            test.readProducts();
            ArrayList<Product> temp= new ArrayList<Product>(Arrays.asList(data1));
            test.bagSolver.solve(temp, testWeight);

    for (int i=0; i<test.bagSolver.getBagsList().size(); i++)
    {
    	assertEquals(test.bagSolver.getBagsList().get(i).getWeight(), feedback1[i], DELTA);	   	
    }
	assertEquals(test.bagSolver.getBagsList().size(), feedback1.length);

}


@Test
public void testCorrectAssignedValues() 
{
    ProductsRead test = new ProductsRead();

            test.readProducts();
            ArrayList<Product> temp= new ArrayList<Product>(Arrays.asList(data2));
            test.bagSolver.solve(temp, testWeight);

    for (int i=0; i<test.bagSolver.getBagsList().size(); i++)
    {
    	assertEquals(test.bagSolver.getBagsList().get(i).getWeight(), feedback2[i], DELTA);	    	
    }
	assertEquals(test.bagSolver.getBagsList().size(), feedback2.length);	

}







}

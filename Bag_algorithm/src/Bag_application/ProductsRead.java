package Bag_application;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class ProductsRead 
{
	
	private  ArrayList<Product> productsList = new ArrayList<Product>();
	private  ArrayList<Product> itemsList = new ArrayList<Product>();

	public BagAlgorithm bagSolver = new BagAlgorithm();

	public void readProducts()
	{
        String csvFile = "resources/product_data.csv";
        String line = "";

        try (LineNumberReader  prodReader = new LineNumberReader (new FileReader(csvFile))) {

            while ((line = prodReader.readLine()) != null) 
            {
                if(prodReader.getLineNumber()<=1 )
                {
                    continue;
                }
            
                String[] tempProduct = line.split(",(?!\\s)");
                if(tempProduct[3].equals("KG"))
                {
                	tempProduct[2]=Double.toString(Double.parseDouble(tempProduct[2])*1000);
                }
                
              Product newProduct = new Product (Long.parseLong(tempProduct[0]), tempProduct[1], Double.parseDouble(tempProduct[2]));
              productsList.add(newProduct);
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }     
        
	}
	
	public  ArrayList<Product> getProductsList()
	{
		return productsList;
	}
	
	public void setProductsList (ArrayList<Product> ProductsList)
	{
		this.productsList=ProductsList;
	}
	public  ArrayList<Product> getItemsList()
	{
		return itemsList;
	}
	
	public void setItemsList (ArrayList<Product> itList)
	{
		this.itemsList=itList;
	}

}

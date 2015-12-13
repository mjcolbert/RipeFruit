package com.sainsburys.supermarket.model;

import java.math.BigDecimal;

/**
 * @author Matthew
 * Domain Model class representing a single instance of a product.
 *
 */
public class Product 
{
    /**
     *  Title of the product on the screen
     */
    private final String title;
    
    /**
     * The size (in kb) of the linked HTML (no assets) For example 90.6kb
     */
    private final String size;
        
    /**
     * Unit prices of the product. For example 1.65
     */
    private final BigDecimal unit_Price;
   
    /**
     * Product Description 
     */
    private final String description;
    
    
    
    /**
     * @param title
     * @param size
     * @param unit_Price
     * @param description
     */
    public Product(String title, String size,  BigDecimal unit_Price, String description)
    {
	this.title = title;
	this.size = size;
	this.unit_Price = unit_Price;
	this.description = description;
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
	return title;
    }

    /**
    * @return
    */
   public String getSize() 
   {
	return size;
   }

   /**
    * @return the unitPrice
    */
   public BigDecimal getUnitPrice()
   {
	return unit_Price;
   }
   
   /**
    * @return the description
    */
   public String getDescription() 
   {
	return description;
   }
}

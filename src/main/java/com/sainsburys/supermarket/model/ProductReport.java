package com.sainsburys.supermarket.model;

import java.util.List;

/**
 * @author Matthew
 * Domain model class for the Product Report contain the products and the total cost.
 *
 */
public class ProductReport {
   
    private final List<Product> results;
    
    private final String total;
   
    public ProductReport( List<Product> results, String total)
    {
	this.results = results;
	this.total = total;
    }

    /**
     * @return the results
     */
    public List<Product> getResults() {
	return results;
    }
    
    
    /**
     * @return the total
     */
    public String getTotal() {
	return total;
    }
 }


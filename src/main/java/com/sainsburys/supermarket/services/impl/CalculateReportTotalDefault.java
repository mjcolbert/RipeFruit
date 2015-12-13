package com.sainsburys.supermarket.services.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.sainsburys.supermarket.model.Product;
import com.sainsburys.supermarket.services.CalculateReportTotal;

/**
 * @author Matthew
 * Calculates the total unit prices for all the products
 */
public class CalculateReportTotalDefault implements CalculateReportTotal {

   
    /* (non-Javadoc)
     * @see com.sainsburys.supermarket.services.CalculateReportTotal#calculateReportTotalUnitPrice(java.util.List)
     */
    @Override
    public String calculateReportTotalUnitPrice(List<Product> results)
    {
	BigDecimal totalCost = new BigDecimal(0);	        
	for (Product currentProduct : results)
	{
	    totalCost = totalCost.add(currentProduct.getUnitPrice());
	}
	return totalCost.setScale(2, RoundingMode.CEILING).toString();
    }
   
    
}

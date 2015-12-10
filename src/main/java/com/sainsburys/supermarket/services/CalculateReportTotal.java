package com.sainsburys.supermarket.services;

import java.util.List;

import com.sainsburys.supermarket.model.Product;

/**
 * @author Matthew
 * Interface for calculating the report
 */
public interface CalculateReportTotal {
    
    /**
     * @param products
     * @return
     */
    public String calculateReportTotalUnitPrice(List<Product> products);
    

}

package com.sainsburys.supermarket.services;

import com.sainsburys.supermarket.model.ProductReport;

/**
 * @author Matthew
 * Interface for converting to Json output
 */
public interface ConstructJsonOutput {
    
    /**
     * @param producReport
     * @return
     */
    public String gsonToJsonConversion(ProductReport producReport);
    
}

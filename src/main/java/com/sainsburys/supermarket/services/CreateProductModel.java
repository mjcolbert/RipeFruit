package com.sainsburys.supermarket.services;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.sainsburys.supermarket.model.Product;

/**
 * @author Matthew
 * 
 * Interface for creating the list of Products from the elements
 */
public interface CreateProductModel {

    
    /**
     * @param listOfProductElements
     * @return
     */
    public List<Product>  parseProductElements(List<WebElement>  listOfProductElements);
}

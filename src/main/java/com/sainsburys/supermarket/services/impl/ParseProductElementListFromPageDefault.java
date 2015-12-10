package com.sainsburys.supermarket.services.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sainsburys.supermarket.services.ParseProductElementListFromPage;


/**
 * @author Matthew
 * Takes the webdriver with the page and returns all the 'product' elements
 *
 */
public class ParseProductElementListFromPageDefault implements ParseProductElementListFromPage {
    
    
    /**
     * Used to identify all the products on the page and output a list of WebElements
     */
    private static final String PRODUCT = "product";
    
    
    
    /* (non-Javadoc)
     * @see com.sainsburys.supermarket.services.ParseProductElementListFromPage#getProductElementList(org.openqa.selenium.WebDriver)
     */
    @Override
    public List<WebElement> getProductElementList(WebDriver webDriver)
    {
	List<WebElement> elements = webDriver.findElements(By.className(PRODUCT));
	return elements;
    }
}

package com.sainsburys.supermarket.services.impl;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sainsburys.supermarket.model.Product;
import com.sainsburys.supermarket.services.CalculatePageSize;
import com.sainsburys.supermarket.services.CreateProductModel;

/**
 * @author Matthew 
 * Creates the list of Products from the given list of Elements
 *
 */
public class CreateProductModelDefault implements CreateProductModel {

    private static final String PRICE_PER_UNIT = "pricePerUnit";
    private static final String ANCHOR = "h3 > a";
    private static final String HREF = "href";
    private static final String PRODUCT_TEXT = "productText";

    private CalculatePageSize calculatePageSize;
    
    /**
     * Logger for the class
     */
    private static final Logger logger = Logger.getLogger(CreateProductModelDefault.class);

    
    /**
     * 
     */
    public CreateProductModelDefault(CalculatePageSize calculatePageSize)
    {
	this.calculatePageSize = calculatePageSize;
    }
    
    
    /*
     * (non-Javadoc)
     * 
     * @see com.sainsburys.supermarket.services.CreateProductModel#
     * parseProductElements(java.util.List)
     */
    @Override
    public List<Product> parseProductElements(List<WebElement> listOfProductElements)
    {
	List<Product> products = new LinkedList<>();

	for (WebElement productElement : listOfProductElements)
	{
	    // Find the drill down element
	    WebElement anchor = productElement.findElement(By.cssSelector(ANCHOR));
	    // Get the title form the anchor for the Product Object
	    String title = "";
	    if (anchor != null)
	    {
		title = anchor.getText();
	    }

	    WebDriver webDriverProductPage = new FirefoxDriver();
	    webDriverProductPage.manage().window().setPosition(new Point(-2000, 0));
	    
	    String pageSizeBytes = ""; 
       	    String description = "";
	    if (webDriverProductPage != null && anchor != null)
	    {
		webDriverProductPage.get(anchor.getAttribute(HREF));
		pageSizeBytes = calculatePageSize.setPageSize(webDriverProductPage);
		WebElement element = null;
		try 
		{
		    element =  webDriverProductPage.findElement(By.className(PRODUCT_TEXT));
		    description = element.getText();
		}
		catch (NoSuchElementException nsee)
		{
		    logger.error(nsee.getMessage(), nsee);
		}
	    }

  
	    // Get the unit price and set to a BigDecimal for precision
	    String unitPriceFromSite = "";
	    BigDecimal unitPrice = new BigDecimal(0);
	    if (productElement != null)
	    {
		unitPriceFromSite = productElement.findElement(By.className(PRICE_PER_UNIT)).getText();
		if (unitPriceFromSite != null)
		{	
		    unitPrice = new BigDecimal(unitPriceFromSite.substring(1, unitPriceFromSite.indexOf("/unit")));
		}
	    }
	    products.add(new Product(title, pageSizeBytes, unitPrice, description));
	    webDriverProductPage.close();
	    webDriverProductPage.quit();
	}
	return products;
    }

}

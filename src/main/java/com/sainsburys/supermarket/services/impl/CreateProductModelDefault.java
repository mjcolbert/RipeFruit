package com.sainsburys.supermarket.services.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sainsburys.supermarket.model.Product;
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

    /**
     * Logger for the class
     */
    private static final Logger logger = Logger.getLogger(CreateProductModelDefault.class);

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
	   	pageSizeBytes = setPageSize(webDriverProductPage);
       	        description = webDriverProductPage.findElement(By.className(PRODUCT_TEXT)).getText();

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

    /**
     * @param webDriverProductPage
     * @return Getting the size of the product page in kb. For the purpose of
     *         this exercise I am assuming UTF-8 Encoding. You could also write
     *         to a file and count the bytes.
     */
    private String setPageSize(WebDriver webDriverProductPage)
    {
	String productPageSource = webDriverProductPage.getPageSource();
	byte[] utf8Bytes = null;
	;
	try {
	    utf8Bytes = productPageSource.getBytes("UTF-8");
	} catch (UnsupportedEncodingException error) {
	    logger.error(error.getMessage(), error);
	}
	int pageSizeBytes = 0;
	if (utf8Bytes != null) {
	    pageSizeBytes = utf8Bytes.length;
	} else {
	    return "Not Known";
	}
	// append b or kb depending on the size
	if (pageSizeBytes < 1024) {
	    return Integer.toString(pageSizeBytes) + "b";
	} else {
	    return Integer.toString(pageSizeBytes / 1024) + "kb";
	}
    }
}

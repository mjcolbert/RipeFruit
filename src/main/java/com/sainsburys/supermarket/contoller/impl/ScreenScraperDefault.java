package com.sainsburys.supermarket.contoller.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sainsburys.supermarket.contoller.ScreenScraper;
import com.sainsburys.supermarket.model.Product;
import com.sainsburys.supermarket.model.ProductReport;
import com.sainsburys.supermarket.services.CalculateReportTotal;
import com.sainsburys.supermarket.services.ConstructJsonOutput;
import com.sainsburys.supermarket.services.CreateProductModel;
import com.sainsburys.supermarket.services.GetLoadedWebDriver;
import com.sainsburys.supermarket.services.ParseProductElementListFromPage;


/**
 * @author Matthew
 * A default implementation for ScreenScraper wired together with the the services that help scrape a screen
 */
public class ScreenScraperDefault implements ScreenScraper 
{
    
    /**
     * Getting top the web page
     */
    private final GetLoadedWebDriver getLoadedWebDriver;

    /**
     * Extracting the products from the web page 
     */
    private final ParseProductElementListFromPage parseProductElementListFromPage;
    
    /**
     * Creating all the products from the screen
     */
    private final CreateProductModel createProductModel;
    
    /**
    * Calculating the total for the report opf all the products
    */
    private final CalculateReportTotal calculateReportTotal;
       
   
    /**
     * Creating the josn output
     */
    private final ConstructJsonOutput constructJsonOutput;
    
     /**
     *  Logger for the class
     */
    private static final Logger logger = Logger.getLogger(ScreenScraperDefault.class);
    
    /**
     * @param getLoadedWebDriver
     * @param parseHtmlPageData
     * @param totalUnitCostCalcualtion
     */
    public ScreenScraperDefault(GetLoadedWebDriver getLoadedWebDriver, ParseProductElementListFromPage parseProductElementListFromPage,   CreateProductModel createProductModel,  
	    CalculateReportTotal calculateReportTotal,  ConstructJsonOutput constructJsonOutput) 
    {
	this.getLoadedWebDriver = getLoadedWebDriver;
	this.parseProductElementListFromPage = parseProductElementListFromPage;
	this.createProductModel = createProductModel;
	this.calculateReportTotal = calculateReportTotal;
	this.constructJsonOutput = constructJsonOutput;
    }
    
    /* (non-Javadoc)
     * @see com.sainsburys.supermarket.services.ScreenScraper#getRequestedScrapedInformation(java.lang.String)
     */
    @Override
    public String getRequestedScrapedInformation(String urlToScrape) 
    {
	WebDriver webDriver = getLoadedWebDriver.getLoadedWebDriverFromUrl(urlToScrape);
	List<WebElement> listOfProductElements = parseProductElementListFromPage.getProductElementList(webDriver);
	List<Product> listOfProducts = createProductModel.parseProductElements(listOfProductElements);
	String total = calculateReportTotal.calculateReportTotalUnitPrice(listOfProducts);
	ProductReport productReport = new ProductReport(listOfProducts, total); 
	getLoadedWebDriver.shutWebDriver(webDriver);
	String reportToPrint = constructJsonOutput.gsonToJsonConversion(productReport);
	logger.info(reportToPrint);
	return reportToPrint;
    }

}

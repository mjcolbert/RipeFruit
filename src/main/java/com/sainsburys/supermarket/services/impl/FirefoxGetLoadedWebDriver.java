package com.sainsburys.supermarket.services.impl;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sainsburys.supermarket.services.GetLoadedWebDriver;


/**
 * @author Matthew
 *
 * Implementation for obtaining an instance of the Firefox web driver navigated to the passed in URL.
 * Other classes could be used for other types of web browsers.
 * The HTMLUnitDriver headless browser was attempted to be used but resulted in Exceeded Stack Maximum.
 * 
 */
public class FirefoxGetLoadedWebDriver implements GetLoadedWebDriver {
        
    /**
     *  Logger for the class
     */
    private static final Logger logger = Logger.getLogger(FirefoxGetLoadedWebDriver.class);
    
    
    /**
     *  Constants used for the waiting logic
     */
    public static final String DOCUMENT_READYSTATE ="return document.readyState";
    public static final String COMPLETE = "complete";
    
       
    /* (non-Javadoc)
     * @see com.sainsburys.supermarket.services.GetLoadedWebDriver#getDocumentFromUrl(java.lang.String)
     * 
     * Get the web driver for FireFox. Set timeouts and get the supplied URL waiting for the javascript to load if needed. 
     * 
     */
    @Override
    public WebDriver getLoadedWebDriverFromUrl(String url) 
    {
	WebDriver webDriver = new FirefoxDriver();
	webDriver.manage().window().setPosition(new Point(-2000, 0));
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.get(url);
        waitForPageLoad(webDriver);
        return webDriver;
    }
 
    /* (non-Javadoc)
     * @see com.sainsburys.supermarket.services.GetLoadedWebDriver#shutWebDriver(org.openqa.selenium.WebDriver)
     */
    @Override
    public void shutWebDriver(WebDriver webDriver)
    {
	webDriver.close();
        webDriver.quit();
    }
    
    
    
    /**
     * @param webDriver
     * Checks if the document is ready and all the java script has been loaded.
     */
    private void waitForPageLoad(WebDriver webDriver)
    {
	ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>()
        {
            public Boolean apply(WebDriver driver)
            {
                return ((JavascriptExecutor) driver).executeScript(DOCUMENT_READYSTATE).equals(COMPLETE);
            }
        };
        Wait<WebDriver> wait = new WebDriverWait(webDriver, 30);
        try
        {
            wait.until(expectation);
        }
        catch (Throwable error)
        {
            logger.error(error.getMessage(), error);
        }
    }
}

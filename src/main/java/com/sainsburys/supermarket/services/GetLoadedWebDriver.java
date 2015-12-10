package com.sainsburys.supermarket.services;

import org.openqa.selenium.WebDriver;


/**
 * @author Matthew
 * Interface for obtaining an instance of the web driver navigated to the passed in URL.
 * Also for shutting the web driver
 */
public interface GetLoadedWebDriver {
    
    /**
     * @param url
     * @return
     */
    public WebDriver getLoadedWebDriverFromUrl(String url);
    
    /**
     * @param webDriver
     */
    public void shutWebDriver(WebDriver webDriver);
      
 
}

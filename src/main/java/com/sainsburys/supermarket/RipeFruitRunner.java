package com.sainsburys.supermarket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

import com.sainsburys.supermarket.contoller.ScreenScraper;

/**
 * @author Matthew
 *  
 * The Runner class for the Ripe fruiit application with injected urlToScrape from a property file
 */
public class RipeFruitRunner implements CommandLineRunner
{
    private final ScreenScraper screenScraper;
    
    @Value("${urlToScrape:NotFound}")
    private String urlToScrape;
    
    
    public RipeFruitRunner(ScreenScraper screenScraper)
    {
	this.screenScraper = screenScraper;
    }
    
    
    public void run(String... args) 
    {
       screenScraper.getRequestedScrapedInformation(urlToScrape);
    }
}

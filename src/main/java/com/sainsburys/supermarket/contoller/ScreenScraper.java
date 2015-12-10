package com.sainsburys.supermarket.contoller;

/**
 * @author Matthew
 *  
 *Interface for Screen Scraper
 */
public interface ScreenScraper {


    /**
     * @param url
     */
    public String getRequestedScrapedInformation(String url);
}

package com.sainsburys.supermarket.services;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Matthew
 * Interface for taking a WebDriver and getting a list of Elements off it representing Products
 *
 */
public interface ParseProductElementListFromPage {

    /**
     * @param webdriver
     * @return
     */
    public List<WebElement> getProductElementList(WebDriver webdriver);
}

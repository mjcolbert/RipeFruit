package com.sainsburys.supermarket.services.impl;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sainsburys.supermarket.services.ParseProductElementListFromPage;

public class ParseProductsElementListFromPageDefaultTest {

    private WebDriver mockDriver;
    private WebElement mockElement;
    
    private static final String PRODUCT = "product";
        
    @Before
    public void setup() 
    {
	this.mockDriver = mock(WebDriver.class);
	this.mockElement = mock(WebElement.class);
	List<WebElement> mockElements = new LinkedList<>();
	mockElements.add(mockElement);
	when(this.mockDriver.findElements(By.className(PRODUCT))).thenReturn(mockElements);
    }
    
    @Test
    public void getProductElementList() 
    {
	ParseProductElementListFromPage parseProductElementListFromPage = new ParseProductElementListFromPageDefault();
	List<WebElement> mockElement = parseProductElementListFromPage.getProductElementList(mockDriver);
	assertNotNull(mockElement);
    }

}

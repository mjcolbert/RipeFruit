package com.sainsburys.supermarket.services.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sainsburys.supermarket.services.CalculatePageSize;

public class CacxlculatePageSizeByBytesTest {

    private  FirefoxDriver webDriverProductPage;
    private  CalculatePageSize calculatePageSizeByBytes;
    
    @Before
    public void setup() 
    {
	this.calculatePageSizeByBytes = new CalculatePageSizeByBytes();
	this.webDriverProductPage = mock(FirefoxDriver.class);
	when(webDriverProductPage.getPageSource()).thenReturn("ABCDE");
    }
    
    @Test
    public void testCalculation() {
	String size = calculatePageSizeByBytes.setPageSize(webDriverProductPage);
	assertEquals("5b",size);
    }
}

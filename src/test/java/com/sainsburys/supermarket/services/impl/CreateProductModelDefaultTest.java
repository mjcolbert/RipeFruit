package com.sainsburys.supermarket.services.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sainsburys.supermarket.model.Product;
import com.sainsburys.supermarket.services.CalculatePageSize;
import com.sainsburys.supermarket.services.CreateProductModel;

public class CreateProductModelDefaultTest 
{
    private WebElement mockElementOrange;
    private WebElement mockElementMango;
    private WebElement mockElementBanana;
    private WebElement mockElementOrangePPUnit;
    private WebElement mockElementOrangeAnchor;
    private WebElement mockElementMangoPPUnit;
    private WebElement mockElementBananaPPUnit;
    private CreateProductModel createProductModel;
    private List<WebElement> elements;
    private static final String PRICE_PER_UNIT = "pricePerUnit";
    private static final String ANCHOR = "h3 > a";
    private static final String HREF =  "href";
    private CalculatePageSize calculatePageSizeByBytes;
    private WebElement mockAnchor;
    
    @Before
    public void setup() 
    {
	this.mockAnchor = mock(WebElement.class);
	this.calculatePageSizeByBytes = mock(CalculatePageSize.class);
	createProductModel = new CreateProductModelDefault(calculatePageSizeByBytes);
	this.mockElementOrange = mock(WebElement.class);
	this.mockElementMango  = mock(WebElement.class);
	this.mockElementBanana = mock(WebElement.class);
	this.mockElementOrangeAnchor = mock(WebElement.class);
	this.mockElementOrangePPUnit = mock(WebElement.class);
	this.mockElementMangoPPUnit  = mock(WebElement.class);
	this.mockElementBananaPPUnit = mock(WebElement.class);
	
	when(mockElementOrange.findElement(By.cssSelector(ANCHOR))).thenReturn(mockElementOrangeAnchor);
	
	when(mockElementOrange.findElement(By.className(PRICE_PER_UNIT))).thenReturn(mockElementOrangePPUnit);
	when(mockElementOrangePPUnit.getText()).thenReturn("5.00/unit");
	when(mockElementMango.findElement(By.className(PRICE_PER_UNIT))).thenReturn(mockElementMangoPPUnit);
	when(mockElementOrangePPUnit.getText()).thenReturn("4.00/unit");
	when(mockElementBanana.findElement(By.className(PRICE_PER_UNIT))).thenReturn(mockElementBananaPPUnit);
	when(mockElementOrangePPUnit.getText()).thenReturn("3.00/unit");
	elements = new LinkedList<>();
	elements.add(mockElementOrange);
	elements.add(mockElementMango);
	elements.add(mockElementBanana);
	when(calculatePageSizeByBytes.setPageSize(new FirefoxDriver())).thenReturn("100kb");
	when(mockElementOrange.findElement(By.cssSelector(ANCHOR))).thenReturn(mockAnchor);
	when(mockAnchor.getAttribute(HREF)).thenReturn("TestHREF");
    }
    
    @Test
    public void parseProductElements() {
	List<Product> productList = createProductModel.parseProductElements(elements);
	assertEquals(3,productList.size());
    }

}

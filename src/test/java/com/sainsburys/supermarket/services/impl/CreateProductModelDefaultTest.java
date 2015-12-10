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

import com.sainsburys.supermarket.model.Product;
import com.sainsburys.supermarket.services.CreateProductModel;

public class CreateProductModelDefaultTest 
{
    private WebElement mockElement;
    private CreateProductModel createProductModel;
    private List<WebElement> elements;
    private static final String PRICE_PER_UNIT = "pricePerUnit";
    
    @Before
    public void setup() 
    {
	createProductModel = new CreateProductModelDefault();
	this.mockElement = mock(WebElement.class);
	when(mockElement.findElement(By.className(PRICE_PER_UNIT))).thenReturn(mockElement);
	elements = new LinkedList<>();
	elements.add(mockElement);
    }
    
    @Test
    public void parseProductElements() {
	List<Product> productList = createProductModel.parseProductElements(elements);
	assertEquals(1,productList.size());
    }

}

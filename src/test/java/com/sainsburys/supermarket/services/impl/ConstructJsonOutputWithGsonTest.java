package com.sainsburys.supermarket.services.impl;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sainsburys.supermarket.model.Product;
import com.sainsburys.supermarket.model.ProductReport;
import com.sainsburys.supermarket.services.ConstructJsonOutput;

public class ConstructJsonOutputWithGsonTest {

    //TODO - Improve test for json
    @Test
    public void gsonToJsonCconversion() {
	ConstructJsonOutput constructJsonOutput  = new ConstructJsonOutputWithGson();
	
	Product prod1 = new Product("apple", "10kb", new BigDecimal(1.10),"red");
	Product prod2 = new Product("orange", "20kb", new BigDecimal(1.40), "orange");
	
	List<Product> products = new LinkedList<>();
	
	products.add(prod1);
	products.add(prod2);
	
	ProductReport productReport = new ProductReport(products,"5.00");
	
	String json = constructJsonOutput.gsonToJsonConversion(productReport);
	Assert.assertTrue(json.contains("title\": \"apple\""));
	Assert.assertTrue(json.contains("red"));

    }

}

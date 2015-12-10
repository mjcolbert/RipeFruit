package com.sainsburys.supermarket.services.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.sainsburys.supermarket.model.Product;
import com.sainsburys.supermarket.model.ProductReport;
import com.sainsburys.supermarket.services.CalculateReportTotal;

public class CalculateReportTotalDefaultTest {

    @Test
    public void addTheValueOfThreeProucts() {
	Product prod1 = new Product("apple", "10kb", new BigDecimal(1.10),"red");
	Product prod2 = new Product("orange", "20kb", new BigDecimal(1.40), "orange");
	Product prod3 = new Product("banana", "30kb", new BigDecimal(1.00), "yellow");
	
	List<Product> products = new LinkedList<>();
	
	products.add(prod1);
	products.add(prod2);
	products.add(prod3);
	
	CalculateReportTotal calculateReportTotal =  new CalculateReportTotalDefault();
	
	String total = calculateReportTotal.calculateReportTotalUnitPrice(products);
		
	assertEquals("3.50",total);
	
    }
}


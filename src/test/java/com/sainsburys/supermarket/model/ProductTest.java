package com.sainsburys.supermarket.model;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.sainsburys.supermarket.model.Product;

public class ProductTest {

    @Test
    public void testProductCreations() {
	Product product = new Product("orange","15kb", new BigDecimal(10.5),"The ripe orange");
	assertEquals("orange",product.getTitle());
	assertEquals("15kb",product.getSize());
	assertEquals(new BigDecimal(10.5),product.getUnitPrice());
	assertEquals("The ripe orange",product.getDescription());
    }

}

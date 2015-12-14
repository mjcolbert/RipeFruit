package com.sainsburys.supermarket.services.impl;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sainsburys.supermarket.services.CalculatePageSize;

public class CalculatePageSizeByBytes implements CalculatePageSize{
    
    /**
     * Logger for the class
     */
    private static final Logger logger = Logger.getLogger(CalculatePageSizeByBytes.class);

    
    
    /**
     * @param webDriverProductPage
     * @return Getting the size of the product page in kb. For the purpose of
     *         this exercise I am assuming UTF-8 Encoding. You could also write
     *         to a file and count the bytes.
     */
    @Override
    public String setPageSize(WebDriver webDriverProductPage)
    {
	String productPageSource = webDriverProductPage.getPageSource();
	byte[] utf8Bytes = null;
	;
	try {
	    utf8Bytes = productPageSource.getBytes("UTF-8");
	} catch (UnsupportedEncodingException error) {
	    logger.error(error.getMessage(), error);
	}
	int pageSizeBytes = 0;
	if (utf8Bytes != null) {
	    pageSizeBytes = utf8Bytes.length;
	} else {
	    return "Not Known";
	}
	// append b or kb depending on the size
	if (pageSizeBytes < 1024) {
	    return Integer.toString(pageSizeBytes) + "b";
	} else {
	    return Integer.toString(pageSizeBytes / 1024) + "kb";
	}
    }
    

}

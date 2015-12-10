package com.sainsburys.supermarket.services.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.sainsburys.supermarket.services.GetLoadedWebDriver;

public class FireFoxGetLoadedWebDriverTest {

    private GetLoadedWebDriver getLoadedWebDriver;
    
    @Before
    public void setup()
    {
	getLoadedWebDriver = new FirefoxGetLoadedWebDriver();
    }
        

    @Test
    public void getLoadedWebDriverFromUrlValidUrl() {
	String url = "http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay?listView=true&orderBy=FAVOURITES_FIRST&parent_category_rn=12518&top_category=12518&langId=44&beginIndex=0&pageSize=20&catalogId=10137&searchTerm=&categoryId=185749&listId=&storeId=10151&promotionId=#langId=44&storeId=10151&catalogId=10137&categoryId=185749&parent_category_rn=12518&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0&hideFilters=true";
	WebDriver webDriver = getLoadedWebDriver.getLoadedWebDriverFromUrl(url);
	String title = webDriver.getTitle();
	assertEquals("Ripe & ready | Sainsbury's",title);
    }
    
    @Test
    public void getLoadedWebDriverFromUrlInValidUrl() {
	String url = "http://www.sainsys";
	WebDriver webDriver = getLoadedWebDriver.getLoadedWebDriverFromUrl(url);
	String title = webDriver.getTitle();
	assertNotEquals("Ripe & ready | Sainsbury's",title);
    }

    @Test
    public void shutWebDriver()
    {
	String url = "http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay?listView=true&orderBy=FAVOURITES_FIRST&parent_category_rn=12518&top_category=12518&langId=44&beginIndex=0&pageSize=20&catalogId=10137&searchTerm=&categoryId=185749&listId=&storeId=10151&promotionId=#langId=44&storeId=10151&catalogId=10137&categoryId=185749&parent_category_rn=12518&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0&hideFilters=true";
	WebDriver webDriver = getLoadedWebDriver.getLoadedWebDriverFromUrl(url);
	getLoadedWebDriver.shutWebDriver(webDriver);
	assertNotEquals(null,webDriver);
    }

}

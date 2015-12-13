package com.sainsburys.supermarket.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sainsburys.supermarket.RipeFruitRunner;
import com.sainsburys.supermarket.contoller.ScreenScraper;
import com.sainsburys.supermarket.contoller.impl.ScreenScraperDefault;
import com.sainsburys.supermarket.services.CalculateReportTotal;
import com.sainsburys.supermarket.services.ConstructJsonOutput;
import com.sainsburys.supermarket.services.CreateProductModel;
import com.sainsburys.supermarket.services.GetLoadedWebDriver;
import com.sainsburys.supermarket.services.ParseProductElementListFromPage;
import com.sainsburys.supermarket.services.impl.CalculateReportTotalDefault;
import com.sainsburys.supermarket.services.impl.ConstructJsonOutputWithGson;
import com.sainsburys.supermarket.services.impl.CreateProductModelDefault;
import com.sainsburys.supermarket.services.impl.FirefoxGetLoadedWebDriver;
import com.sainsburys.supermarket.services.impl.ParseProductElementListFromPageDefault;


/**
 * @author Matthew
 *
 * Spring Java Configuration for RipeFruit Scraping Application 
 */
@Configuration
public class RipeFruitConfig {

    @Bean(name="firefoxGetLoadedWebDriver")
    public GetLoadedWebDriver firefoxGetLoadedWebDriver() {
        return new FirefoxGetLoadedWebDriver();
    }

    @Bean(name="parsePorductElementListFromPageDefault")
    public ParseProductElementListFromPage parsePorductElementListFromPageDefault() {
        return new ParseProductElementListFromPageDefault();
    }
    
    @Bean(name="createProductModelDefault")
    public CreateProductModel createProductModel() {
        return new CreateProductModelDefault();
    }
    
    @Bean(name="constructJsonOutputWithGson")
    public ConstructJsonOutput constructJsonOutputWithGson() {
        return new ConstructJsonOutputWithGson();
    }
    
    @Bean(name="calculateReportTotalDefault")
    public CalculateReportTotal calculateReportTotalDefault() {
        return new CalculateReportTotalDefault();
    }
        
    @Bean(name="screenScraper")
    public ScreenScraper screenScraper() {
        return new ScreenScraperDefault(firefoxGetLoadedWebDriver(), parsePorductElementListFromPageDefault(), createProductModel(), 
        				calculateReportTotalDefault(), constructJsonOutputWithGson());
    }
    
    @Bean(name="ripeFruitRunner")
    public RipeFruitRunner ripeFruitRunner() {
        return new RipeFruitRunner(screenScraper());
    }
  
  
}

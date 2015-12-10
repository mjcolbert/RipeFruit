package com.sainsburys.supermarket.services.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sainsburys.supermarket.model.ProductReport;
import com.sainsburys.supermarket.services.ConstructJsonOutput;


/**
 * @author Matthew
 * Construct the Json from the Model
 *
 */
public class ConstructJsonOutputWithGson implements ConstructJsonOutput {

    /* (non-Javadoc)
     * @see com.sainsburys.supermarket.services.ConstructJsonOutput#gsonToJsonCconversion(com.sainsburys.supermarket.model.ProductReport)
     */
    @Override
    public String gsonToJsonConversion(ProductReport productReport) 
    {
	// Display the results in JSON format
	Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
	return gson.toJson(productReport);
    }

}

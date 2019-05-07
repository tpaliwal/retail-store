package com.mycompany.retail_store.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.retail_store.dto.RetailStoreRequest;
import com.mycompany.retail_store.service.RetailStoreService;

@RestController
@RequestMapping("/store")
public class RetailStoreController {

	private ObjectMapper mapper = new ObjectMapper();
	private static Logger LOGGER = LoggerFactory.getLogger(RetailStoreController.class);

	@Autowired
	RetailStoreService retailStoreService;

	/*
	 * Rest Api for calculating payable amount
	 */
	@RequestMapping(value = "/calculatePayableAmount", method = RequestMethod.POST)
	public double calculatePayableAmount(@RequestBody String requestBody)
			throws JsonParseException, JsonMappingException, IOException {
		LOGGER.info("Start process controller for calculating amount");
		LOGGER.debug("Input data string is: " + requestBody);
		
		RetailStoreRequest retailStoreRequest = mapper.readValue(requestBody, RetailStoreRequest.class);
		
		LOGGER.debug("Input data after marshalling: " + retailStoreRequest);
		LOGGER.info("End process controller for calculating amount");
		return retailStoreService.calculatePayableAmount(retailStoreRequest);

	}

}
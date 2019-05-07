package com.mycompany.retail_store.controller;

import java.io.IOException;

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

	@Autowired
	RetailStoreService retailStoreService;

	/*
	 * Rest Api for calculating payable amount
	 */
	@RequestMapping(value = "/calculatePayableAmount", method = RequestMethod.POST)
	public double calculatePayableAmount(@RequestBody String requestBody)
			throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Data is: " + requestBody);
		RetailStoreRequest retailStoreRequest = mapper.readValue(requestBody, RetailStoreRequest.class);
		return retailStoreService.calculatePayableAmount(retailStoreRequest);

	}

}
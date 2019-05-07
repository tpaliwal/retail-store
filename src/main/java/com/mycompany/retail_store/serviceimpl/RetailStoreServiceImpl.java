package com.mycompany.retail_store.serviceimpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.retail_store.dto.Cart;
import com.mycompany.retail_store.dto.Product;
import com.mycompany.retail_store.dto.RetailStoreRequest;
import com.mycompany.retail_store.dto.User;
import com.mycompany.retail_store.service.DiscountPolicy;
import com.mycompany.retail_store.service.RetailStoreService;

@Service
public class RetailStoreServiceImpl implements RetailStoreService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(RetailStoreServiceImpl.class);


	@Override
	public double calculatePayableAmount(RetailStoreRequest retailStoreRequest) {
		
		LOGGER.info("Start process service for calculating amount ");

		User user = retailStoreRequest.getUser();
		List<Product> products = retailStoreRequest.getProducts();
		DiscountPolicy discountPolicy = new ThresholdDiscount();

		Cart cart = new Cart(user, discountPolicy);
		products.forEach(product -> cart.add(product, product.getUnits()));
		
		LOGGER.info("payable amount before rounding off " + cart.total());
		
		BigDecimal bd = new BigDecimal(cart.total()).setScale(2, RoundingMode.HALF_UP);
		
		LOGGER.info("End process service for calculating amount " + bd.doubleValue());
		return bd.doubleValue();
	}

}

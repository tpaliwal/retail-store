package com.mycompany.retail_store.serviceimpl;

import org.springframework.stereotype.Service;

import com.mycompany.retail_store.service.DiscountPolicy;

/*
 * To generate discount of $5 for every 100 dollars in cart
 */
@Service
public class ThresholdDiscount implements DiscountPolicy {

	@Override
	public double applyDiscount(double totalAmount) {
		
		if (totalAmount < 100) {
			return totalAmount;
		}
		
		int discountFactor = (int) totalAmount / 100;
		double discount = discountFactor * 5;
		return totalAmount - discount; 
	}

}

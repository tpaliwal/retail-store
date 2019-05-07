package com.mycompany.retail_store.service;

/*
 * Interface for Overall Discount Policy for all items of cart
 */
public interface DiscountPolicy {
	double applyDiscount(double totalAmount);
}

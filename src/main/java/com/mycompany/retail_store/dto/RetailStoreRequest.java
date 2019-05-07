package com.mycompany.retail_store.dto;

import java.util.List;

/** Class for input payload
 * @author tusharpaliwal
 *
 */
public class RetailStoreRequest {

	private User user;
	private List<Product> products;
	private int quantities;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getQuantities() {
		return quantities;
	}

	public void setQuantities(int quantities) {
		this.quantities = quantities;
	}

}

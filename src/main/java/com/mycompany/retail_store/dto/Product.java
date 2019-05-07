package com.mycompany.retail_store.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.mycompany.retail_store.ItemType;
import com.mycompany.retail_store.service.Item;

/*
 * Class for actual product items
 */
public class Product implements Item {

	private final String name;
	private final double unitPrice;
	private final int units;
	private final ItemType type;

	/** Method is used to convert data from json to oject
	 * @param object
	 * @return
	 */
	@JsonCreator
	public static Product create(Map<String, Object> object) {
		return new Product((String) object.get("name"), (double) object.get("unitPrice"),
				ItemType.valueOf((String) object.get("type")), (int) object.get("units"));
	}

	public Product(String name, double priceInDollars, ItemType type, int units) {
		this.name = name;
		this.unitPrice = priceInDollars;
		this.type = type;
		this.units = units;
	}
	

	public int getUnits() {
		return units;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public String getName() {
		return name;
	}

	public double priceForQuantity(int quantity) {
		return unitPrice * quantity;
	}

	public ItemType getType() {
		return type;
	}
}

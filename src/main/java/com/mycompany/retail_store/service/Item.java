package com.mycompany.retail_store.service;

import com.mycompany.retail_store.ItemType;

/*
 * Interface for all items
 */
public interface Item {
    double getUnitPrice();
    
    double priceForQuantity(int quantity);
    
    String getName();
    
    ItemType getType();
}

package com.mycompany.retail_store.serviceimpl;

import com.mycompany.retail_store.ItemType;
import com.mycompany.retail_store.service.Item;

/*
 * Class to apply percentage discount on items based on type
 */
public class PromotionPricing extends PricingPolicy {

    private final double priceFactor;

    public PromotionPricing(Item baseItem, int percentPromotion) {
        super(baseItem);
        if (percentPromotion < 0 || percentPromotion > 100 ) {
            throw new IllegalArgumentException("percentPromotion must be in [0,100]");
        }
        this.priceFactor = (100 - percentPromotion) / 100.0;
    }

    @Override
    public double priceForQuantity(int quantity) {
    	// If Grocery then don't apply the percentage discount
    	if (super.getType() == ItemType.GROCERY) {
    		return super.priceForQuantity(quantity);
    	}
    	
    	// else apply percentage discount
        return (super.priceForQuantity(quantity) * priceFactor);
    }
}

package com.company.store.Retail_Store;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.mycompany.retail_store.ItemType;
import com.mycompany.retail_store.UserType;
import com.mycompany.retail_store.dto.Cart;
import com.mycompany.retail_store.dto.Product;
import com.mycompany.retail_store.dto.User;
import com.mycompany.retail_store.service.Item;

/*
 * Test Cases for no discount policy for any type and just to see if cart is working
 */
public class TestWithoutDiscounts {

    private Cart cart;
    private Item item;

    @Before
    public void setUp() {
    	User user = new User(UserType.SIMPLE, "John");
        cart = new Cart(user);
        item = new Product("something", 1000, ItemType.OTHER, 3);
    }

    @Test
    public void test_emptyCartCostsZero() {
        assertEquals(0, cart.total(), 0.01);
    }

    @Test
    public void test_singleBasicItemCostsItsUnitPrice() {
        cart.add(item);
        assertEquals(item.getUnitPrice(), cart.total(), 0.01);
    }

    @Test
    public void test_multipleBasicItemsCostProportionally() {
        int howMany = 3;
        cart.add(item, howMany);
        assertEquals(howMany * item.getUnitPrice(), cart.total(), 0.01);
    }

    @Test
    public void test_separatelyAdding() {
        int howMany = 3;
        for (int i = howMany; i > 0; i--) {
            cart.add(item);
        }
        assertEquals(howMany * item.getUnitPrice(), cart.total(), 0.01);
    }
}

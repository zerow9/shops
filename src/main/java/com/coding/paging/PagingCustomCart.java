package com.coding.paging;
import com.coding.pojo.Cart;
import org.springframework.stereotype.Component;

@Component
public class PagingCustomCart extends Paging {
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}

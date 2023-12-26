package com.techMall.api.services.cart;

import com.techMall.api.models.entities.CartEntity;
import com.techMall.api.models.entities.CartItemEntity;
import com.techMall.api.models.requests.RemoveProductFromCartRequest;
import com.techMall.api.services.cartItems.DeleteCartItemService;
import com.techMall.api.services.cartItems.FindCartItemByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveProductFromCartService {

    @Autowired
    private FindCartByIdService findCartByIdService;

    @Autowired
    private FindCartItemByIdService findCartItemByIdService;

    @Autowired
    private DeleteCartItemService deleteCartItemService;

    public void removeProductFromCart(Long cartId, RemoveProductFromCartRequest data){
        CartEntity cart = findCartByIdService.findCartById(cartId);
        CartItemEntity cartItem = findCartItemByIdService.findCartItemById(data.productId());
        cart.getCartItems().remove(cartItem);
        deleteCartItemService.delete(data.productId());
    }
}
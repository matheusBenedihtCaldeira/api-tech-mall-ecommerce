package com.techMall.api.services.cart;

import com.techMall.api.models.entities.CartEntity;
import com.techMall.api.models.entities.CartItems;
import com.techMall.api.models.entities.ProductEntity;
import com.techMall.api.models.requests.AddProductToCartRequest;
import com.techMall.api.repositories.CartItemsRepository;
import com.techMall.api.repositories.CartRepository;
import com.techMall.api.services.product.FindProductByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddProductToCartService {

    @Autowired
    private CartRepository repository;

    @Autowired
    private FindProductByIdService findProductByIdService;

    @Autowired
    private CartItemsRepository cartItemsRepository;

    @Autowired
    private FindCartByIdService findCartByIdService;

    public CartEntity addProductToCart(Long id, AddProductToCartRequest data){
        CartEntity cart = findCartByIdService.findCartById(id);
        ProductEntity product = findProductByIdService.findProductById(data.productId());
        CartItems cartItems = new CartItems();
        cartItems.setCart(cart);
        cartItems.setProduct(product);
        cartItems.setQuantity(data.quantity());
        cartItemsRepository.save(cartItems);
        cart.getCartItems().add(cartItems);
        return repository.save(cart);
    }

}
package com.techMall.api.services.cart;

import com.techMall.api.models.entities.CartEntity;
import com.techMall.api.models.entities.CartItemEntity;
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
        CartItemEntity cartItemEntity = addCartItem(cart, product, data.quantity());
        cart.getCartItems().add(cartItemEntity);
        return repository.save(cart);
    }

    private CartItemEntity addCartItem(CartEntity cart, ProductEntity product, Integer quantity){
        CartItemEntity cartItemEntity = new CartItemEntity();
        cartItemEntity.setCart(cart);
        cartItemEntity.setProduct(product);
        cartItemEntity.setQuantity(quantity);
        cartItemsRepository.save(cartItemEntity);
        return cartItemEntity;
    }
}
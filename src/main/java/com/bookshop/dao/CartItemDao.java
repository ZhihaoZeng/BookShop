package com.bookshop.dao;

import com.bookshop.entity.CartItem;

import java.util.List;

/**
 * @InterfaceName: CartItemDao
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 1:52
 */
public interface CartItemDao {
    List<CartItem> getCartItems(Long userId);

    void insertCartItem(CartItem cartItem);

    void updateCartItem(CartItem cartItem);
    void updateCartItems(List<CartItem> cartItems);

    void deleteCartItem(CartItem cartItem);
    void deleteCartItems(List<CartItem> cartItems);

}
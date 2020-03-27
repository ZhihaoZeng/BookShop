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
    public List<CartItem> getCartItems(Long userId);

    public void insertCartItem(CartItem cartItem);

    public void updateCartItem(CartItem cartItem);
    public void updateCartItems(List<CartItem> cartItems);

    public void deleteCartItem(CartItem cartItem);
    public void deleteCartItems(List<CartItem> cartItems);

}
package com.bookshop.dao;

import com.bookshop.entity.Cart;

/**
 * @InterfaceName: CartDao
 * @Description: TODO
 * @Author: 曾志昊
 * @Date: 2020/3/28 1:50
 */
public interface CartDao {
    public Cart getCart(Long userId);

 /* 这些都在CartItemDao中实现了
    public void addBook(CartItem cartItem,Long userId);//购物车增加一本书
    public void addBooks(List<CartItem> cartItems,Long userId);//购物车增加多个书籍

    public void deleteCartItem(CartItem cartItem,Long userId);
    public void deleteCartItems(List<CartItem> cartItems,Long userId);

    public void updateCartItem(CartItem cartItem);//修改，用实体作为参数
    public void updateCartItems(List<CartItem> cartItems);*/
}
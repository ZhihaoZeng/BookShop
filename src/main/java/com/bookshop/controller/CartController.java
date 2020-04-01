package com.bookshop.controller;

import com.bookshop.common.responseFromServer;
import com.bookshop.entity.CartItem;
import com.bookshop.entity.User;
import com.bookshop.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: CartController
 * @Description:
 * @Author: 曾志昊
 * @Date: 2020/3/28 1:48
 */

@Controller
@RequestMapping("/cart")
public class CartController {

    @Resource
    CartService cartService;

    @RequestMapping("/getCart")
    @ResponseBody
    public responseFromServer getCart(@RequestBody Map<String,Object> reqeustMap, HttpSession session){
        /*reqeustmap中需要有userid startpage*/
        if(reqeustMap.get("userId")==null){
            /*用户申请查看购物车没有传入userid参数直接从session中获取*/
            reqeustMap.put("userId",((User)session.getAttribute("user")).getUserId());
        }
        return cartService.getCart(reqeustMap);
    }

    @RequestMapping("/getCartItems")
    @ResponseBody
    public responseFromServer getCartItems(@RequestBody Map<String,Object> requestMap){
       return cartService.getCartItems(requestMap);
    }


    @RequestMapping("/getCartItem")
    @ResponseBody
    public responseFromServer getCartItem(Map<String,Object> reqeustMap){
        return cartService.getCartItem(reqeustMap);
    }

    @RequestMapping("/getCartItemsPage")
    @ResponseBody
    public responseFromServer getCartItemsPage(Map<String,Object> requestMap){
        return cartService.getCartItemsPage(requestMap);
    }

    @RequestMapping("/insertCartItem")
    @ResponseBody
    public responseFromServer insertCartItem(CartItem cartItem){
        return cartService.insertCartItem(cartItem);

    }


    @RequestMapping("/updateCartItem")
    @ResponseBody
    public responseFromServer updateCartItem(CartItem cartItem){
        return cartService.updateCartItem(cartItem);
    }


    @RequestMapping("/updateCartItems")
    @ResponseBody
    public responseFromServer updateCartItems(List<CartItem> cartItems){
        return cartService.updateCartItems(cartItems);
    }

    @RequestMapping("/deleteCartItem")
    @ResponseBody
    public responseFromServer deleteCartItem(CartItem cartItem){
        return cartService.deleteCartItem(cartItem);
    }


    @RequestMapping("/deleteCartItems")
    @ResponseBody
    public responseFromServer deleteCartItems(List<CartItem> cartItems){
        return cartService.deleteCartItems(cartItems);
    }


}

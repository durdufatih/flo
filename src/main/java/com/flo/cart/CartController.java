package com.flo.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Bu Controller <b>Cart</b> Entity'sinin html sayfalarla veri alışverişi sağlar
 *
 */
@Controller
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    /**
     * Bu metod cart'ta bulunan butun verileri döner.
     * @param model
     * @return String
     */
    @RequestMapping(value = "/cart")
    private String cart(Model model){
        model.addAttribute("cartList",cartRepository.findAll());
        return "cart/index";
    }


}

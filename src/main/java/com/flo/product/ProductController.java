package com.flo.product;

import com.flo.cart.Cart;
import com.flo.cart.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fatihdurdu on 07/02/17.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(Model model) {

        for (int i = 0; i < 5; i++) {
            productRepository.save(productRepository.save(new Product("TRY", "Deneme Ürünüdür ", "Ürün" + i, 50 * i)));
        }
        model.addAttribute("productList", productRepository.findAll());
        model.addAttribute("cartCount",cartRepository.count());
        return "product/index";
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable String id, Model model) {

        model.addAttribute("product", productRepository.findOne(Long.parseLong(id)));
        return "product/detail";
    }

    @RequestMapping(value = "/addcart/{id}", method = RequestMethod.GET)
    public String addcart(@PathVariable String id, Model model) {

        model.addAttribute("cart", cartRepository.save(new Cart(productRepository.getOne(Long.parseLong(id)))));
        return "redirect:/";
    }
}

package com.flo.order;

import com.flo.cart.Cart;
import com.flo.cart.CartRepository;
import com.flo.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by fatihdurdu on 08/02/17.
 */
@Controller
public class OrderController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartRepository cartRepository;

    @RequestMapping(value = "/orderList",method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("orderList",orderRepository.findAll());

        return "order/index";

    }

    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public String buy(@PathVariable String id){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        orderRepository.save(new Order(reportDate,productRepository.findOne(Long.parseLong(id))));
        for(Cart cart:cartRepository.findAll()){
            if(cart.getProduct().getId()==Long.parseLong(id)){
                cartRepository.delete(cart);
                break;
            }
        }
        return "redirect:/cart";

    }
}

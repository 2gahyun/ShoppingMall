package com.shopping.controller;

import java.util.List;

import com.shopping.service.ShoppingCartService;
import com.shopping.vo.ProductInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShoppingCartController {
    @Autowired ShoppingCartService service;

    // http://localhost/cart 만 입력했을 때 로그인페이지로 가도록 설정
    @GetMapping("/cart")
    public String getShoppingCartDefault(){ return "redirect:/login"; }

    // http://localhost/cart/{member_id}?RQ4qVx7=123
    @GetMapping("/cart/{member_id}")
    public String getShoppingCart(
        @PathVariable @Nullable String member_id,
        // RQ4qVx7 = 사용자의 DB상의 seq 번호, url에 써있어도 개발자만 알 수 있도록 설정
        @RequestParam Integer RQ4qVx7, Model model
    ){
        if(member_id == null){
            return "/redirect:/login";
        }
        List<ProductInfoVO> list = service.selectCartProducts(RQ4qVx7);
        model.addAttribute("list", list);
        
        return "/product/cart";
    }
}

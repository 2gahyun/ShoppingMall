package com.shopping.controller;

import javax.servlet.http.HttpSession;

import com.shopping.mapper.CategoryMapper;
import com.shopping.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired CategoryMapper cate_mapper;
    @Autowired ProductService prod_service;

    @GetMapping("/")
    public String getMain(Model model, HttpSession session){
        session.setAttribute("catelist", cate_mapper.selectCategories());
        // model.addAttribute("catelist", cate_mapper.selectCategories());
        model.addAttribute("reco_list", prod_service.selectRecommandPrducts());
        
        return "/index";
    }
}

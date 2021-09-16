package com.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.shopping.service.OrderService;
import com.shopping.vo.MemberInfoVO;
import com.shopping.vo.OrderProductVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    @Autowired OrderService service;

    @GetMapping("/member/order")
    public String getMemberOrder(HttpSession session, Model model){
        MemberInfoVO member = (MemberInfoVO)session.getAttribute("member");
        // 로그인이 안되어있을 때 처리
        if(member == null){
            return "redirect:/login";
        }
        // 로그인이 되어있을 때 처리
        Integer mi_seq = member.getMi_seq();

        List<OrderProductVO> list = service.selectOrderInfo(mi_seq);
        model.addAttribute("order_list", list);

        return "/member/order";
    }
}

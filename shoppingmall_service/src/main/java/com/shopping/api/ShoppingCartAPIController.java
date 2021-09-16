package com.shopping.api;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.shopping.service.ShoppingCartService;
import com.shopping.vo.ShoppingCartVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartAPIController {
    @Autowired ShoppingCartService service;

    @PostMapping("/cart/add")
    public Map<String, Object> postCartAdd(
        @RequestBody ShoppingCartVO vo,
        HttpSession session
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        // 카트로 추가를 하는 코드
        service.insertProduct(vo);
        resultMap.put("status", true);
        resultMap.put("message", "카트에 상품이 추가되었습니다.");

        Integer cart_cnt = service.selectCount(vo.getSc_mi_seq());
        session.setAttribute("cart_cnt", cart_cnt);
        return resultMap;
    }
    @DeleteMapping("/cart/remove")
    public Map<String, Object> deleteCart(@RequestParam Integer pi_seq, @RequestParam Integer mi_seq, HttpSession session){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.deleteCartProduct(pi_seq, mi_seq);

        resultMap.put("status", true);
        resultMap.put("message", "삭제되었습니다.");

        Integer cart_cnt = service.selectCount(mi_seq);
        session.setAttribute("cart_cnt", cart_cnt);
        return resultMap;
    }
    @PatchMapping("/cart/increase")
    public Map<String, Object> cartIncrease(@RequestParam Integer pi_seq, @RequestParam Integer mi_seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.increaseProductCnt(pi_seq, mi_seq);
        resultMap.put("status", true);
        return resultMap;
    }
    @PatchMapping("/cart/decrease")
    public Map<String, Object> cartdecrease(@RequestParam Integer pi_seq, @RequestParam Integer mi_seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.decreaseProductCnt(pi_seq, mi_seq);
        resultMap.put("status", true);
        return resultMap;
    }
    @PatchMapping("/cart/change")
    public Map<String, Object> cartChange(
        @RequestParam Integer pi_seq, @RequestParam Integer mi_seq, @RequestParam Integer cnt){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.changeProductCnt(pi_seq, mi_seq, cnt);
        resultMap.put("status", true);
        return resultMap;
    }
}

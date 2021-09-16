package com.shopping.service;

import java.util.List;

import com.shopping.mapper.ProductMapper;
import com.shopping.mapper.ShoppingCartMapper;
import com.shopping.vo.ProductInfoVO;
import com.shopping.vo.ShoppingCartVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
    @Autowired ShoppingCartMapper mapper;
    @Autowired ProductMapper p_mapper;

    public void insertProduct(ShoppingCartVO vo){
        Integer cnt = mapper.selectCartProductCnt(vo);
        if(cnt == 1){
            mapper.updateCartProductCnt(vo);
        } else {
            mapper.insertProduct(vo);
        }
    }
    public Integer selectCount(Integer mi_seq){
        return mapper.selectCount(mi_seq);
    }

    public List<ProductInfoVO> selectCartProducts(Integer mi_seq){
        List<ProductInfoVO> list = mapper.selectCartProducts(mi_seq);
        for(ProductInfoVO item : list) {
            // 판매자의 번호(seq)를 가져와서
            int i = item.getPi_si_seq();
            // 판매자의 이름(si_name)을 mapper에서 가져온다.
            String si_name = p_mapper.getSellerName(i); // 판매자 이름 알아냄
            item.setSeller_name(si_name); // 판매자 이름 저장한다.

            Integer rate = item.getPi_discount_rate();
            Integer price = item.getPi_price();
            Integer discounted = price - price * rate /100;
            // dicounted_price 변수 타입이 string이기때문에 .toString()을 붙여준다
            item.setDiscounted_price(discounted.toString());
        }
        return list;
    }
    public void deleteCartProduct(Integer pi_seq, Integer mi_seq){
        mapper.deleteCartProduct(pi_seq, mi_seq);
    }
    public void increaseProductCnt(Integer pi_seq, Integer mi_seq){
        mapper.increaseProductCnt(pi_seq, mi_seq);
    }
    public void decreaseProductCnt(Integer pi_seq, Integer mi_seq){
        mapper.decreaseProductCnt(pi_seq, mi_seq);
    }
    public void changeProductCnt(Integer pi_seq, Integer mi_seq, Integer cnt){
        mapper.changeProductCnt(pi_seq, mi_seq, cnt);
    }
}

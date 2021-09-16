package com.shopping.mapper;

import java.util.List;

import com.shopping.vo.ProductInfoVO;
import com.shopping.vo.ShoppingCartVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShoppingCartMapper {
    public void insertProduct(ShoppingCartVO vo);
    public Integer selectCartProductCnt(ShoppingCartVO vo);
    public void updateCartProductCnt(ShoppingCartVO vo);
    public Integer selectCount(Integer mi_seq);
    public List<ProductInfoVO> selectCartProducts(Integer mi_seq);

    public void deleteCartProduct(Integer pi_seq, Integer mi_seq);
    public void increaseProductCnt(Integer pi_seq, Integer mi_seq);
    public void decreaseProductCnt(Integer pi_seq, Integer mi_seq);
    public void changeProductCnt(Integer pi_seq, Integer mi_seq, Integer cnt);
}

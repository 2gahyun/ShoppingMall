package com.shopping.mapper;

import java.util.List;

import com.shopping.vo.ProductInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    public ProductInfoVO selectProductBySeq(Integer seq);

    public List<ProductInfoVO> selectRecommandProducts();
    public String getSellerName(Integer si_seq);
    public String getCategoryName(Integer cate_seq);
    public String getProductImageFileName(String uri);

    public List<ProductInfoVO> selectProductsByCategory(Integer cate_seq);
}

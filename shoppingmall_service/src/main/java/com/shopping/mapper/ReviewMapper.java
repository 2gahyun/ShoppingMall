package com.shopping.mapper;

import com.shopping.vo.ReviewVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
    public void insertReview(ReviewVO vo);
    public Integer selectReviewCntByOrderId(Integer oi_seq);
    public Double selectProdReviewRateAvg(Integer pi_seq);
    public void insertSellerRate(Integer si_seq, Integer rate);
}

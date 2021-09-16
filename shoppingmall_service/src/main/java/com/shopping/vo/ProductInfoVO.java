package com.shopping.vo;

import lombok.Data;

@Data
public class ProductInfoVO {
    private Integer pi_seq;
    private String pi_name;
    private Integer pi_cate_seq;
    private Integer pi_stock;
    private Integer pi_si_seq;
    private String pi_create_dt;
    private Integer pi_discount_rate;
    private String pi_caution;
    private Integer pi_weight;
    private Integer pi_point_rate;
    private Integer pi_di_seq;
    private Integer pi_price;
    private String pi_img_uri;
    
    private String seller_name;
    private String category_name;

    private String discounted_price;
    private String original_price;

    private Integer sc_count;
}

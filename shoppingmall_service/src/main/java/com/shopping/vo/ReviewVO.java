package com.shopping.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewVO {
    private Integer rev_seq;
    private Integer rev_pi_seq;
    private Integer rev_mi_seq;
    private Date rev_reg_dt;
    private Date rev_mod_dt;
    private String rev_content;
    private Integer rev_rate;
    private Integer rev_oi_seq;

    private Integer si_seq;
    private Integer seller_rate;
}

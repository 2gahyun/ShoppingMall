package com.shopping.service;

import java.text.DecimalFormat;
import java.util.List;

import com.shopping.mapper.ProductMapper;
import com.shopping.vo.ProductInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired ProductMapper mapper;

    public ProductInfoVO selectProductBySeq(Integer seq){
        ProductInfoVO item = mapper.selectProductBySeq(seq);

        int i = item.getPi_si_seq(); // 번호를 가져와서
        String si_name = mapper.getSellerName(i); // 판매자 이름 알아냄
        item.setSeller_name(si_name); // 판매자 이름 저장한다.

        i = item.getPi_cate_seq(); // 카테고리 번호 가져오기
        String cate_name = mapper.getCategoryName(i); // 카테고리 이름 알아내고
        item.setCategory_name(cate_name); // 카테고리 이름 저장.

        int discount_rate = item.getPi_discount_rate();
        int discounted = (int)(item.getPi_price() - (item.getPi_price() * discount_rate / 100.0));
        DecimalFormat formatter = new DecimalFormat("#,##0");
        item.setDiscounted_price(formatter.format(discounted));
        item.setOriginal_price(formatter.format(item.getPi_price()));

        return item;
    }

    public List<ProductInfoVO> selectRecommandPrducts(){
        List<ProductInfoVO> list = mapper.selectRecommandProducts();
        for(ProductInfoVO item : list) {
            // 판매자의 번호(seq)를 가져와서
            int i = item.getPi_si_seq();
            // 판매자의 이름(si_name)을 mapper에서 가져온다.
            String si_name = mapper.getSellerName(i); // 판매자 이름 알아냄
            item.setSeller_name(si_name); // 판매자 이름 저장한다.

            int discount_rate = item.getPi_discount_rate();
            int discounted = (int)(item.getPi_price() - (item.getPi_price() * discount_rate / 100.0));
            DecimalFormat formatter = new DecimalFormat("#,##0");
            item.setDiscounted_price(formatter.format(discounted));
            item.setOriginal_price(formatter.format(item.getPi_price()));
        }
        // 가공시킨 list를 return시킨다.
        return list;
    }

    public String getProductImageFileName(String uri){
        return mapper.getProductImageFileName(uri);
    }

    public List<ProductInfoVO> selectProductsByCategory(Integer cate_seq) {
        List<ProductInfoVO> list = mapper.selectProductsByCategory(cate_seq);
        for(ProductInfoVO item : list) {
            // 판매자의 번호(seq)를 가져와서
            int i = item.getPi_si_seq();
            // 판매자의 이름(si_name)을 mapper에서 가져온다.
            String si_name = mapper.getSellerName(i); // 판매자 이름 알아냄
            item.setSeller_name(si_name); // 판매자 이름 저장한다.

            int discount_rate = item.getPi_discount_rate();
            int discounted = 
                (int)(discounted = (int)(item.getPi_price() - (item.getPi_price() * discount_rate / 100.0)));
            DecimalFormat formatter = new DecimalFormat("#,##0");
            item.setDiscounted_price(formatter.format(discounted));
            item.setOriginal_price(formatter.format(item.getPi_price()));
        }
        // 가공시킨 list를 return시킨다.
        return list;
    } 
}

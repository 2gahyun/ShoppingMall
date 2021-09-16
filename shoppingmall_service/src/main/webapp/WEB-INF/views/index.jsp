<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>마켓컬리 :: 내일의 장보기, 마켓컬리</title>
    <link rel="stylesheet" href="/assets/css/index.css">
</head>

<body>
    <main>
        <section class="main_banner_area">
            <div class="banner_item">
            </div>
        </section>
        <section class="recommand_prod_area">
            <h1>이 상품 어때요?</h1>
            <div class="recommand_wrap">
                <c:forEach items="${reco_list}" var="item">
                    <a href="/detail?prod_seq=${item.pi_seq}" class="recommand_item prod_item">
                        <div class="img_area">
                            <img src="/image/${item.pi_img_uri}">
                        </div>
                        <div class="text_area">
                            <h2>[${item.seller_name}] ${item.pi_name}</h2>
                            <p class="price">
                                <c:if test="${item.pi_discount_rate != 0}">
                                    <span class="discount_rate">${item.pi_discount_rate}%</span>
                                </c:if>
                                <span>
                                    ${item.discounted_price}원
                                </span>
                            </p>
                            <c:if test="${item.pi_discount_rate != 0}">
                                <p class="origin_price">${item.original_price} 원</p>
                            </c:if>
                        </div>
                    </a>
                </c:forEach>
            </div>
        </section>
    </main>
</body>

</html>
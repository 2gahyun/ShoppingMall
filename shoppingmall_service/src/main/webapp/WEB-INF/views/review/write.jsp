<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="/assets/js/review.js"></script>
</head>
<body>
    <h1>리뷰관리</h1>
    <input type="text" id="product" value="${product.pi_seq}" disabled hidden>
    <input type="text" id="member"value="${member.mi_seq}" disabled hidden>
    <input type="text" id="seller" value="${product.pi_si_seq}" disabled hidden>
    <div class="review_container">
        <h2>판매자 평가</h2>
        <p>판매자의 배송, 질문 응대 등 전체적인 서비스는 어떠셨나요?</p>
        <div id="seller_rate_area">
            <span>만족도</span>
            <input type="radio" id="seller_rate_1" value="1" name="seller_rate">
            <label for="seller_rate_1">매우 불만족</label>
            <input type="radio" id="seller_rate_2" value="2" name="seller_rate">
            <label for="seller_rate_2">불만족</label>
            <input type="radio" id="seller_rate_3" value="3" name="seller_rate">
            <label for="seller_rate_3">보통</label>
            <input type="radio" id="seller_rate_4" value="4" name="seller_rate">
            <label for="seller_rate_4">만족</label>
            <input type="radio" id="seller_rate_5" value="5" name="seller_rate">
            <label for="seller_rate_5">매우 만족</label>
        </div>

        <h2>상품 리뷰 작성</h2>
        <p>이 상품에 대해서 얼마나 만족하시나요?</p>
        <div class="review_rate">
            <img src="/image/${product.pi_img_uri}" style="width: 100px">
            <div class="review_rate_input">
                <p>${product.pi_name}</p>
                <input type="radio" id="rate1" name="rate" value="1">
                <label for="rate1">1</label>
                <input type="radio" id="rate2" name="rate" value="2">
                <label for="rate2">2</label>
                <input type="radio" id="rate3" name="rate" value="3">
                <label for="rate3">3</label>
                <input type="radio" id="rate4" name="rate" value="4">
                <label for="rate4">4</label>
                <input type="radio" id="rate5" name="rate" value="5">
                <label for="rate5">5</label>
            </div>
        </div>
        <div class="review_detail">
            <span>상세리뷰</span>
            <textarea id="review_detail_content" placeholder="상품에 대한 고객님의 솔직한 리뷰를 남겨주세요."></textarea>
        </div>
        <div class="review_btn">
            <button id="cancel">작성취소</button>
            <button id="save">등록하기</button>
        </div>
    </div>
</body>
</html>
// assets/js/detail.js
$(function(){
    let count = 1;
    // * 1 해주는 이유는, 문자열에서 숫자값으로 강제로 형태 변환을 주기 위함.
    let price = $(".discounted").html().replace(",", "") * 1;
    $(".total_price b").html(price); // 총금액 맞춰주기
    let point_rate = $(".save_point").attr("data-point-rate");
    let point = Math.floor(price * point_rate / 100); // 포인트 값이 됨
    $(".save_point b").html(point+"원");
    // replace(",", ""); 문자열에서 ,를 아무것도 없는걸로 바꾼다.
    $("#plus").click(function(){
        count++;
        if(count >= $(".stock").html()) count = $(".stock").html(); // 재고수량보다 넘을 수 없도록 설정
        $("#count").html(count);
        $(".total_price b").html(price * count);
        let point = Math.floor(price * point_rate / 100 * count); // 수량이 증가하면 적립포인트도 증가
        $(".save_point b").html(point+"원");
    })
    $("#minus").click(function(){
        count--;
        if(count < 1) count = 1;
        $("#count").html(count);
        $(".total_price b").html(price * count);
        let point = Math.floor(price * point_rate / 100 * count); // 수량이 감소하면 적립포인트도 감소
        $(".save_point b").html(point+"원");
    });
    $("#shopping_bag").click(function(){
        if(memberInfo.seq == "" || memberInfo.seq == null || memberInfo.seq == undefined){
            alert("로그인 후 사용하실 수 있습니다.");
            return;
        }

        let data = {
            sc_mi_seq:memberInfo.seq,
            sc_pi_seq:$(".detail_container").attr("data-prod-seq"),
            sc_count:$("#count").html()
        }

        $.ajax({
            type:"post",
            url:"/cart/add",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    })
})
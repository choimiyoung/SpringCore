package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService;

    OrderService orderService;
    @BeforeEach
    public void  beforeEach(){

        AppConfig appConfig = new AppConfig();
         memberService = appConfig.memberService();
         orderService =appConfig.orderService();


    }


    @Test
    void createOrder(){
        //given
        Long memberId=1L;
        Member memberA = new Member(memberId, "meberA", Grade.VIP);
        memberService.join(memberA);



        //when
        Order itemA = orderService.createOrder(memberId, "itemA", 10000);


        //then
        Assertions.assertThat(itemA.getDiscountPrice()).isEqualTo(1000);

    }

}
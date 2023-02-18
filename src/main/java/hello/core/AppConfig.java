package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.DiscountPolicyImpl;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberRepositoryImpl;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return  new MemberServiceImpl(memberRepository());
    }

    @Bean
    private static MemberRepository memberRepository() {
        return new MemberRepositoryImpl();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());

    }

    @Bean
    private static DiscountPolicy discountPolicy() {
        return new DiscountPolicyImpl();
    }

}

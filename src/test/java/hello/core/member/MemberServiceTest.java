package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class MemberServiceTest {


    MemberService memberService;


    @BeforeEach
    public  void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();

    }


    @Test
    void join(){
        //given
        Member memberA = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(memberA);
        Member findMember = memberService.findMember(1l);


        //then
        Assertions.assertThat(memberA).isEqualTo(findMember);

    }

}
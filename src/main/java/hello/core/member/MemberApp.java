package hello.core.member;

import hello.core.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

       /* AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member merberA = new Member(1L, "merberA", Grade.VIP);

        memberService.join(merberA);
        Member findMember = memberService.findMember(1l);

        System.out.println(merberA.getId());
        System.out.println(findMember.getId());
    }


}

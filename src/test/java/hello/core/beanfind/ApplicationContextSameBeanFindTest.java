package hello.core.beanfind;

import hello.core.member.MemberRepository;
import hello.core.member.MemberRepositoryImpl;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.plaf.PanelUI;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {


    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 , 중복 오류가 발생한다")
    void findBeanTypeDuplicate(){
       // MemberRepository bean = ac.getBean(MemberRepository.class);
       //검증
        assertThrows(NoUniqueBeanDefinitionException.class,() ->
                ac.getBean(MemberRepository.class));


    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면,빈 이름을 지정하면 된다 ")
    void findBeanByName(){
        MemberRepository memberRepository = ac.getBean("memberRepository1",MemberRepository.class);



    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기  ")
    void findBeanByType(){

        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            //key와 vlaue조회
            System.out.println("key = " + key+ "value=" + beansOfType.get(key));

        }

        //목록 조회
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);

    }






    @Configuration
    static  class  SameBeanConfig {


        @Bean
        public MemberRepository memberRepository1() {

            return new MemberRepositoryImpl();

        }

        @Bean
        public  MemberRepository memberRepository2(){

            return  new MemberRepositoryImpl();
        }

    }
}

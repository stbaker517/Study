package example.account_controll;

import example.account_controll.domain.Member;
import example.account_controll.repository.MemberRepository;
import example.account_controll.repository.MemoryMemberRepository;
import example.account_controll.service.MemberService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository(){

        return new MemoryMemberRepository();
    }
}

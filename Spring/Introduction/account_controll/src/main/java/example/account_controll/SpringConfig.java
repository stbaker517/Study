package example.account_controll;

import example.account_controll.domain.Member;
import example.account_controll.repository.JdbcMemberRepository;
import example.account_controll.repository.MemberRepository;
import example.account_controll.repository.MemoryMemberRepository;
import example.account_controll.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource=dataSource;

    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        //interface를 두고 구현체를 바꾸면 간단하게 코드가 바뀜.
        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}

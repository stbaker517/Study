package example.account_controll.service;

import example.account_controll.domain.Member;
import example.account_controll.repository.MemberRepository;
import example.account_controll.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemoryMemberRepository memberRepository;//=new MemoryMemberRepository();
    MemberService memberService;// = new MemberService(memberRepository);

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository); // DI Dependancy Injection.
    }
    @AfterEach
    public void afterEach(){
        memberRepository.clear();
    }
    @Test
    void 회원가입() {//테스트는 함수명에 한글을 사용해도 됨.
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        Long saveId = memberService.join(member);

        //then
        Member one =memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(one.getName());

    }
    @Test
    public void 중복_회원_예외(){
        //given

        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        /*
        try{
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        }
        */


        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }

    @Test
    void testJoin() {
    }

    @Test
    void testFindMembers() {
    }

    @Test
    void testFindOne() {
    }
}
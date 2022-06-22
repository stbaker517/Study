package example.account_controll.controller;

import example.account_controll.domain.Member;
import example.account_controll.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;// = new MemberService();

    @Autowired // 스프링 빈에 하나의 인스턴스만을 존재하게 할 수 있음. 굳이 각 컨트롤러가  new해서 따로 쓸 필요 없으니까 스프링 컨테이너 안에 하나의 객체만 존재하도록 한다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //self test
    @GetMapping("signup")
    @ResponseBody
    public Long postSignUpAPI(@RequestParam("name") String name){
        Member member = new Member();
        member.setName(name);
        Long id = memberService.join(member);
        return id;
    }

    @GetMapping("userlist")
    @ResponseBody
    public List<Member> getUserListAPI(){
        return memberService.findMembers();

    }


}

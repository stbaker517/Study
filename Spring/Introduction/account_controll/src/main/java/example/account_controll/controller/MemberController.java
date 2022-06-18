package example.account_controll.controller;

import example.account_controll.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;// = new MemberService();

    @Autowired // 스프링 빈에 하나의 인스턴스만을 존재하게 할 수 있음. 굳이 각 컨트롤러가  new해서 따로 쓸 필요 없으니까 스프링 컨테이너 안에 하나의 객체만 존재하도록 한다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}

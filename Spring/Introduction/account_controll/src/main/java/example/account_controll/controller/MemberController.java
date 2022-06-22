package example.account_controll.controller;

import example.account_controll.domain.Member;
import example.account_controll.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;// = new MemberService();

    /*
     필드 주입. 필드 주입 별로 안 좋아함.
    * @Autowired
    * private MemberService memberService;
    * */

    //DI :: 생성자 주입. 가장 추천되는 방법. why: 어플리케이션 빌드 때에만 설정되고 그 이후에 건들 수가 없음.
    //@Autowired // 스프링 빈에 하나의 인스턴스만을 존재하게 할 수 있음. 굳이 각 컨트롤러가  new해서 따로 쓸 필요 없으니까 스프링 컨테이너 안에 하나의 객체만 존재하도록 한다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /*
      DI::setter주입
      단점. 퍼블릭으로 선언 돼야함. 퍼블릭하게 노출이 되는 것이 문제.
      private MemberService memberService;
    * @Autowired
    * public void setMemberService(MemberService memberService){
    *   this.memberService = memberService;
    * }
    * */

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

    @GetMapping("/members/new")
    //@ResponseBody
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/"; //리다이렉션
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";

    }

}

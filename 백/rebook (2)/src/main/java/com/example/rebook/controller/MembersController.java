package com.example.rebook.controller;


import com.example.rebook.dto.membersForm;
import com.example.rebook.entity.Member;
import com.example.rebook.repository.MemberRepository;
import jakarta.persistence.criteria.Join;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
public class MembersController {
    @Autowired //스프링부트가 미리 생성해 놓은 리파지터리 객체 주입
    private MemberRepository memberRepository;

    //회원가입페이지 불러오기
    @GetMapping("/members/join")
    public String newMemberForm() {
        return "members/join";
    }

    //회원가입 정보 데이터로 보내기
    @PostMapping("/members/create")
    public String createMember(membersForm form) {  //폼 데이터를 dtom로 받기
        System.out.println(form.toString());  //폼에 데이터에 잘 담겨 있는지 확인

        //1. DTO(FORM)를 엔티티로 변환
        Member member = form.toEntity();
//        System.out.println(member.toString());
        log.info(member.toString());

        //2. 리파지터리로 인티티를 DB에 저장
        Member saved = memberRepository.save(member);
//        System.out.println(saved.toString());
        log.info(saved.toString());
        return "redirect:/members/" + saved.getId();
    }

    //개별 회원 정보 불러오기
    @GetMapping("/members/{id}")
    public String member_show(@PathVariable Long id, Model model) {
        log.info("id= " + id);

        //1.id를 조회해 데이터 가져오기
        Member member = memberRepository.findById(id).orElse(null);

        //2. 모델에 데이터 등록하기
        model.addAttribute("member", member);  //""안의 이름을 머스타치에 사용한다 {{#  }}  {{/}}

        //3. 뷰 페이지 반환하기

        return "members/idMember";
    }

    // 전체 회원 목록 불러오기
    @GetMapping("/AllMembers")
    public String AllMembers(Model model) {

        //1. 모든 데이터 가져오기
        List<Member> memberList = memberRepository.findAll();

        //2. 모델에 데이터 등록하기
        model.addAttribute("memberList", memberList);

        //3. 뷰 페이지 설정하기
        return "members/AllMembers";
    }

    //회원 정보 수정하기
    @GetMapping("/members/{id}/edit")
    public String member_edit(@PathVariable Long id, Model model){
        //1. 수정할 데이터 가져오기
        Member member = memberRepository.findById(id).orElse(null);

        //2. 모델에 데이터 등록하기
        model.addAttribute("member", member);

        //3. 뷰 페이지 설정하기
        return "members/EditMember";
    }

    @PostMapping("/members/update")
    public String update(membersForm form) {
        log.info(form.toString());

        //1. DTO를 엔티티로 변환하기
        Member member = form.toEntity();
        log.info(member.toString());

        //2. 엔티티를 DB에 저장하기
        Member target = memberRepository.findById(member.getId()).orElse(null);
        if (target !=null) {
            memberRepository.save(member);
        }

        //3. 수정 결과 페이지로 리다이렉트하기
        return "redirect:/members/" + member.getId();
    }

    @GetMapping("/members/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        log.info("회원 삭제 요청이 들어왔습니다.");

        //1. 삭제할 대상 가져오기
        Member target = memberRepository.findById(id).orElse(null);
        log.info(target.toString());

        //2. 대상 엔티티 삭제하기
        if (target !=null) {
            memberRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제되었습니다.");

        }

        //3. 결과 페이지로 리다이렉트하기
        return "redirect:/AllMembers";
    }

    //로그인 페이지 호출
    @GetMapping("/login")
    public String loginPage() {
        return "members/loginPage";
    }
}

package com.example.rebook.controller;


//import com.example.rebook.dto.CommentDto;
import com.example.rebook.Service.CommentService;
import com.example.rebook.dto.CommentDto;
import com.example.rebook.dto.booksForm;
import com.example.rebook.entity.Register;
import com.example.rebook.repository.RegisterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class booksController {

    @Autowired
    private RegisterRepository regiRepository;

    @Autowired
    private CommentService commentService;

    //상품등록페이지
    @GetMapping("/admin/register")
    public String newForm() {
        return "admin/register";
    }

    //등록한 상품 저장하기
    @PostMapping("/admin/create")
    public String createbooks(booksForm form) {
        System.out.println(form.toString());

        Register register = form.toEntity();
        log.info(register.toString());
        //System.out.println(register.toString());

        Register saved = regiRepository.save(register);
        System.out.println(saved.toString());
        return "redirect:/admin/" + saved.getId();
    }

    //관리자가 상품 개별 정보 호출
    @GetMapping("/admin/{id}")
    public String book_show(@PathVariable Long id, Model model) {
        //log.info("id = " + id);
        System.out.println("id = " + id);

        Register register = regiRepository.findById(id).orElse(null);


        model.addAttribute("register", register);

        return "admin/IdBook";
    }

    //관리자가 모든 상품 호출
    @GetMapping("/admin/AllBooks")
    public String Allbooks_show(Model model) {

        ArrayList<Register> registerList = regiRepository.findAll();

        //리스트의 길이
        // System.out.println(registerList.toArray().length);

        model.addAttribute("registerList", registerList);
        return "admin/AllBooks";

    }

    //관리자가 개별 상품 정보 수정하기
    @GetMapping("/admin/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        //log.info("id = " + id);
        System.out.println("id = " + id);

        Register register = regiRepository.findById(id).orElse(null);

        model.addAttribute("register", register);
        return "admin/BookEdit";
    }


    //관리자가 개별상품 수정한 정보 업데이트하기
    @PostMapping("/admin/update")
    public String update(booksForm form) {
        log.info(form.toString());

        Register register = form.toEntity();
        log.info(register.toString());

        Register target = regiRepository.findById(register.getId()).orElse(null);

        if (target != null) {
            regiRepository.save(register);
        }

        return "redirect:" + register.getId();
    }

    //관리자가 상품 삭제하기
    @GetMapping("/admin/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        log.info("삭제 요청이 들어왔습니다.");

        Register target = regiRepository.findById(id).orElse(null);
        log.info(target.toString());

        if (target != null) {
            regiRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제 되었습니다!");
        }

        return "redirect:/admin/AllBooks";
    }

    //고객이 소분류페이지 호출
    @GetMapping("/books/sortPage")
    public String sortPage(Model model) {
        ArrayList<Register> registerList = regiRepository.findAll();


        //리스트의 길이
        // System.out.println(registerList.toArray().length);

        model.addAttribute("registerList", registerList);
        return "books/sort_Books";

    }

    //고객이 책소개 페이지 호출
    @GetMapping("/books/{id}/bookintro")
    public String bookintro(@PathVariable Long id, Model model) {
        Register register = regiRepository.findById(id).orElse(null);
        List<CommentDto> commentDtos = commentService.comments(id);

        model.addAttribute("register", register);
        model.addAttribute("commentsDtos", commentDtos);
        return "books/BookIntro";

    }

    @GetMapping("/books/mainPage")
    public String mainPage(Model model) {

        ArrayList<Register> registerList = regiRepository.findAll();


        //리스트의 길이
        // System.out.println(registerList.toArray().length);

        model.addAttribute("registerList", registerList);
        return "books/mainPageBookList";

    }
}
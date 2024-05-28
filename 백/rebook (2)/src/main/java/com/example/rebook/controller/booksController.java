package com.example.rebook.controller;


//import com.example.rebook.dto.CommentDto;
import com.example.rebook.Service.CommentService;
import com.example.rebook.dto.CommentDto;
import com.example.rebook.dto.booksForm;
import com.example.rebook.entity.Item;
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
    @GetMapping("/books/register")
    public String newtForm() {
        return "books/register";
    }

    //등록한 상품 저장하기
    @PostMapping("/books/create")
    public String createbooks(booksForm form) {
        System.out.println(form.toString());

        Item register = form.toEntity();
        log.info(register.toString());
        //System.out.println(register.toString());

        Item saved = regiRepository.save(register);
        System.out.println(saved.toString());
        return "redirect:" + saved.getId();
    }

    //관리자가 상품 개별 정보 호출
    @GetMapping("/books/{id}")
    public String book_show(@PathVariable Long id, Model model) {
        //log.info("id = " + id);
        System.out.println("id = " + id);

        Item register = regiRepository.findById(id).orElse(null);


        model.addAttribute("register", register);

        return "books/IdBook";
    }

    //관리자가 모든 상품 호출
    @GetMapping("/AllBooks")
    public String Allbooks_show(Model model) {

        ArrayList<Item> registerList = regiRepository.findAll();



        //리스트의 길이
        // System.out.println(registerList.toArray().length);

        model.addAttribute("registerList", registerList);
        return "/books/AllBooks";

    }

    //관리자가 개별 상품 정보 수정하기
    @GetMapping("/books/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        //log.info("id = " + id);
        System.out.println("id = " + id);

        Item register = regiRepository.findById(id).orElse(null);

        model.addAttribute("register", register);
        return "books/BookEdit";
    }


    //관리자가 개별상품 수정한 정보 업데이트하기
    @PostMapping("/books/update")
    public String update(booksForm form) {
        log.info(form.toString());

        Item register = form.toEntity();
        log.info(register.toString());

        Item target = regiRepository.findById(register.getId()).orElse(null);

        if (target != null) {
            regiRepository.save(register);
        }

        return "redirect:" + register.getId();
    }

    //관리자가 상품 삭제하기
    @GetMapping("/books/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        log.info("삭제 요청이 들어왔습니다.");

        Item target = regiRepository.findById(id).orElse(null);
        log.info(target.toString());

        if (target != null) {
            regiRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제 되었습니다!");
        }

        return "redirect:/AllBooks";
    }

    //고객이 메인페이지 호출
    @GetMapping("/books/sortPage")
    public String sortPage(Model model) {
        ArrayList<Item> registerList = regiRepository.findAll();



        //리스트의 길이
        // System.out.println(registerList.toArray().length);

        model.addAttribute("registerList", registerList);
        return "books/sort_Books";

    }

    //고객이 책소개 페이지 호출
    @GetMapping("/books/{id}/bookintro")
    public String bookintro(@PathVariable Long id, Model model) {
        Item register = regiRepository.findById(id).orElse(null);
        List<CommentDto> commentDtos = commentService.comments(id);

        model.addAttribute("register", register);
        model.addAttribute("commentsDtos", commentDtos);
        return "books/BookIntro";

    }

}
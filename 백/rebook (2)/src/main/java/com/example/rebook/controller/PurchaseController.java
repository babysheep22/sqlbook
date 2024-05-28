package com.example.rebook.controller;


import com.example.rebook.dto.purchaseForm;
import com.example.rebook.entity.Purchase;
import com.example.rebook.repository.PurchaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class PurchaseController {
    @Autowired
    private PurchaseRepository purchaseRepository;

    //상품매입 요청
    @GetMapping("/purchase/requestPurchase")
    public String requestPurchase() {
        return "purchase/requestPurchase";
    }

    //매입요청 정보 저장하기
    @PostMapping("/purchase/create")
    public String createpurchase(purchaseForm form) {
        System.out.println(form.toString());

        Purchase purchase = form.toEntity();
        log.info(purchase.toString());

        Purchase saved = purchaseRepository.save(purchase);
        System.out.println(saved.toString());
        return "redirect:" + saved.getId();
    }

    @GetMapping("/purchase/{id}")
    public String purchase_show(@PathVariable Long id, Model model) {
        System.out.println("id + " + id);

        Purchase purchase = purchaseRepository.findById(id).orElse(null);

        model.addAttribute("purchase", purchase);

        return "purchase/IdPurchase";
    }

}

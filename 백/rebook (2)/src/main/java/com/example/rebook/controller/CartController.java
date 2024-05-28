package com.example.rebook.controller;
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

@Controller
public class CartController {
}

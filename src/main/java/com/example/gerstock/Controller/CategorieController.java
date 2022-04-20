package com.example.gerstock.Controller;

import com.example.gerstock.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    CategorieService categorieService;

    @GetMapping("/create")
    public String index(){
        return "categorie/create";
    }
}

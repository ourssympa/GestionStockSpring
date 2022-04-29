package com.example.gerstock.Controller;

import com.example.gerstock.Model.Vente;
import com.example.gerstock.Service.ArticleService;
import com.example.gerstock.Service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Random;

@Controller
@RequestMapping("/vente")
public class VenteController {
    @Autowired
    VenteService venteService;
    @Autowired
    ArticleService articleService;
    @GetMapping("/")
    public String vente(Model model){
        String ref =gen();
    model.addAttribute("ref",ref);
    model.addAttribute("articles",articleService.listeArticle());
        model.addAttribute("ventes",venteService.listeVente(ref));
    return "vente/index";
    }
    @PostMapping("/{ref}")
    public String Vente(@PathVariable("ref") String ref, @ModelAttribute("vente")Vente vente, Model model){
       vente.setDate(LocalDate.now());
       vente.setTotal(vente.getPrix()* vente.getQte());
       venteService.saveVente(vente);
       articleService.Approvisionner(vente.getArticleId(), vente.getQte()*-1);
        return "redirect:ventes/"+ref;
    }
    @GetMapping("/ventes/{ref}")
    public String Ventes(@PathVariable("ref") String ref,Model model){
        model.addAttribute("ref",ref);
        model.addAttribute("articles",articleService.listeArticle());
        model.addAttribute("ventes",venteService.listeVente(ref));
        int total=0;
        for(int i =0;i<venteService.listeVente(ref).size();i++)
        {
            total+=venteService.listeVente(ref).get(i).getTotal();
        }
        model.addAttribute("total",total);
        return "vente/index";
    }

    public String gen(){
        Random rand = new Random();
        String alphabet ="afHDS9Vj8b7vs6O3LK2P4O5jh1sd";
        int longueur = alphabet.length();
        char a[] = new char[6];
        int i;
        String rec="";
        for( i=0;i<5;i++)
        {
            int k = rand.nextInt(longueur);
            a [i]= alphabet.charAt(k);
            rec += Character.toString(a[i]);
        }
        return rec.toString();
    }


}

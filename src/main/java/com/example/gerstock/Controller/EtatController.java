package com.example.gerstock.Controller;

import com.example.gerstock.Model.Date;
import com.example.gerstock.Model.Vente;
import com.example.gerstock.Service.ApprovisionnementService;
import com.example.gerstock.Service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/etat")
public class EtatController {
    @Autowired
    VenteService venteService;
    @Autowired
    ApprovisionnementService approvisionnementService;
    @PostMapping("/vente")
    public String venteEtat(@ModelAttribute("date")Date date, Model model){
        LocalDate date1 = date.getDate1();
        LocalDate date2 = date.getDate2();
        List<Vente> vListe =venteService.venteEtat(date1,date2);
        model.addAttribute("ventes",vListe);
        int total=0;
        for(int i =0;i<vListe.size();i++)
        {
            total+=vListe.get(i).getTotal();
        }
        model.addAttribute("total",total);
        model.addAttribute("i",vListe.size());
        model.addAttribute("date1",date2);
        model.addAttribute("date2",date1);
        return "etat/vente";
    }

}

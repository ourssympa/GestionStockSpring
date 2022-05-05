package com.example.gerstock.Controller;

import com.example.gerstock.Model.Article;
import com.example.gerstock.Model.Vente;
import com.example.gerstock.Service.ApprovisionnementService;
import com.example.gerstock.Service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Controller
public class home {
    @Autowired
    VenteService venteService;
    @Autowired
    ApprovisionnementService approvisionnementService;
    @GetMapping("/")
    public String home (Model model){
        List<Vente> listVente = venteService.venteEtat(LocalDate.now(),LocalDate.now());
        int i = listVente.size();
        int total=0;
        for(int j =0;j<i;j++)
        {
            total+=listVente.get(j).getTotal();
        }

        List<Article> listeAppro = approvisionnementService.listeAapprovisionner();
        int nbrAappro = listeAppro.size();
        int [] stat = statistiqueVente();
        model.addAttribute("articles",listeAppro);
        model.addAttribute("stats",stat);
        model.addAttribute("i",i);
        model.addAttribute("total",total);
        model.addAttribute("Aappro",nbrAappro);
        return "home/home";
    }
    public int[] statistiqueVente(){
        List<Vente> list = venteService.ToutesVente();
        int stat []= new int [12];
        //switche case plus efficace mais flemme de reprendre
        for(int i =0;i<list.size();i++){

            if(list.get(i).getDate().getMonth().equals(Month.JANUARY)){
             stat[0]+= list.get(i).getTotal();
            }
            if(list.get(i).getDate().getMonth().equals(Month.FEBRUARY)){
             stat[1]+= list.get(i).getTotal();
            }

            if(list.get(i).getDate().getMonth().equals(Month.MARCH)){
             stat[2]+= list.get(i).getTotal();
            }
            if(list.get(i).getDate().getMonth().equals(Month.APRIL)){
             stat[3]+= list.get(i).getTotal();
            }
            if(list.get(i).getDate().getMonth().equals(Month.MAY)){
             stat[4]+= list.get(i).getTotal();
            }
            if(list.get(i).getDate().getMonth().equals(Month.JUNE)){
             stat[5]+= list.get(i).getTotal();
            }
            if(list.get(i).getDate().getMonth().equals(Month.JULY)){
             stat[6]+= list.get(i).getTotal();
            }
            if(list.get(i).getDate().getMonth().equals(Month.AUGUST)){
             stat[7]+= list.get(i).getTotal();
            }
            if(list.get(i).getDate().getMonth().equals(Month.SEPTEMBER)){
             stat[8]+= list.get(i).getTotal();
            }
            if(list.get(i).getDate().getMonth().equals(Month.OCTOBER)){
             stat[9]+= list.get(i).getTotal();
            }
            if(list.get(i).getDate().getMonth().equals(Month.NOVEMBER)){
             stat[10]+= list.get(i).getTotal();
            }
            if(list.get(i).getDate().getMonth().equals(Month.DECEMBER)){
             stat[11]+= list.get(i).getTotal();
            }
        }
        return stat;
    }
}

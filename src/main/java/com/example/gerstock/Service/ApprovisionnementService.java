package com.example.gerstock.Service;

import com.example.gerstock.Model.Approvisionnement;
import com.example.gerstock.Model.Article;
import com.example.gerstock.Repository.ApprovisionnemantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovisionnementService {
    @Autowired
    ApprovisionnemantRepository approvisionnemantRepository;

    public void saveApprovisionnement(Approvisionnement approvisionnement){
        approvisionnemantRepository.save(approvisionnement);
    }

    public List<Approvisionnement> listeApprovisionnement(){
        return approvisionnemantRepository.findAll();
    }

    public  Approvisionnement oneApprovisionnement(int id){
        return  approvisionnemantRepository.findById(id).get();
    }
    public void delete(int id){
        approvisionnemantRepository.deleteById(id);
    }
    public List<Article> listeAapprovisionner(){
      return approvisionnemantRepository.listeAApprovisionner();
    }
}

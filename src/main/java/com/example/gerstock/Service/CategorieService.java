package com.example.gerstock.Service;

import com.example.gerstock.Model.Categorie;
import com.example.gerstock.Repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    @Autowired
    CategorieRepository categorieRepository;

    public void saveCategorie (Categorie categorie){
        categorieRepository.save(categorie);
    }
    public List<Categorie> listeCategorie(){
         return categorieRepository.findAll();
    }
    public  Categorie oneCategorie(int id){
        return categorieRepository.findById(id).get();
    }
    public void deleteCategorie(int id){
    categorieRepository.deleteById(id);
    }
}

package com.example.gerstock.Service;

import com.example.gerstock.Model.Article;
import com.example.gerstock.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;
    public void saveArticle(Article article){
        articleRepository.save(article);
    }

    public List<Article> listeArticle(){
        return articleRepository.findAll();
    }

    public Article oneArticle(int id){
        return articleRepository.findById(id).get();
    }
    public void deleteArticle(int id){
        articleRepository.deleteById(id);
    }

    public void Approvisionner(int id, int qte){
        articleRepository.updateStockArticle(id,qte);
    }
}

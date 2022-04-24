package com.example.gerstock.Repository;

import com.example.gerstock.Model.Approvisionnement;
import com.example.gerstock.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprovisionnemantRepository extends JpaRepository<Approvisionnement,Integer> {

    @Query("select a from Article a where a.qteStock <= a.qteSeuil")
    public List<Article> listeAApprovisionner();
}

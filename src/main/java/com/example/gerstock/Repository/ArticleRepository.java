package com.example.gerstock.Repository;

import com.example.gerstock.Model.Approvisionnement;
import com.example.gerstock.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer>{
    @Modifying
    @Transactional
    @Query("update Article a set a.qteStock=a.qteStock + :qte where a.id= :idd")
    void updateStockArticle(@Param("idd") int idd,@Param("qte") int qte);


}

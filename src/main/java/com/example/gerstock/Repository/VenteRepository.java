package com.example.gerstock.Repository;

import com.example.gerstock.Model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenteRepository extends JpaRepository<Vente,Integer> {

    @Query("select v from Vente v where v.ref = :reff")
    List<Vente> venteListe(@Param("reff") String reff);
}

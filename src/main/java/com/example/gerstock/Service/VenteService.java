package com.example.gerstock.Service;

import com.example.gerstock.Model.Vente;
import com.example.gerstock.Repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteService {
    @Autowired
    VenteRepository venteRepository;

    public List<Vente> listeVente(String ref){
        return venteRepository.venteListe(ref);
    }
    public void saveVente(Vente vente){
        venteRepository.save(vente);
    }
}

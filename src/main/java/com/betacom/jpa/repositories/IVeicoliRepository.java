package com.betacom.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.betacom.jpa.models.Veicoli;

public interface IVeicoliRepository extends JpaRepository<Veicoli, Integer> {

    @Query(name="veicoli.selectByFilter")
    List<Veicoli> selectByFilter(
            @Param("id_veicoli") Integer idVeicoli,
            @Param("tipoVeicolo") String tipoVeicolo,
            @Param("marca") String marca,
            @Param("modello") String modello,
            @Param("colore") Integer colore,
            @Param("categoria") Integer categoria,
            @Param("alimentazione") Integer alimentazione
    );
    
    @Query(name="veicoli.getByMarcaLikeA")
    List<Veicoli> getByMarcaLikeA();
}
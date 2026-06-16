package com.betacom.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.betacom.jpa.models.Bici;

public interface IBiciRepository extends JpaRepository<Bici, Integer> {

    @Query(name = "bici.selectByFilter")
    List<Bici> selectByFilter(
            @Param("id_bici") Integer idBici,
            @Param("tipoFreno") String tipoFreno,
            @Param("tipoSospensione") String tipoSospensione,
            @Param("colore") Integer colore,
            @Param("categoria") Integer categoria,
            @Param("pieghevole") Boolean pieghevole
    );

    @Query(name = "bici.getByMarcaLikeA")
    List<Bici> getByMarcaLikeA();
}
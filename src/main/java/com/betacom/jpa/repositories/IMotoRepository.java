package com.betacom.jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.betacom.jpa.models.Moto;

public interface IMotoRepository extends JpaRepository<Moto, Integer> {

    List<Moto> findByTargaContainingIgnoreCase(String targa);

    Optional<Moto> findByTarga(String targa);

    boolean existsByTarga(String targa);

    @Query("SELECT m FROM Moto m WHERE m.targa LIKE 'A%'")
    List<Moto> getByTargaLikeA();
    
}
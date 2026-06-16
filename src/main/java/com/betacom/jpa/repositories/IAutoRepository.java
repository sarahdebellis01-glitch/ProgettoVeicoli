package com.betacom.jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.betacom.jpa.models.Auto;

public interface IAutoRepository extends JpaRepository<Auto, Integer>{
	
	 @Query(name ="auto.selectByFilter")
	    List<Auto> selectByFilter(
	            @Param("id_auto") Integer idAuto,
	            @Param("targa") String targa,
	            @Param("marca") String marca,
	            @Param("modello") String modello,
	            @Param("colore") Integer colore,
	            @Param("categoria") Integer categoria
	    );

	    @Query(name="auto.getByTarga")
	    Optional<Auto> getByTarga(
	            @Param("targa") String targa
	    );

	    
	    @Query(name = "auto.getByTargaLikeA")
	    List<Auto> getByTargaLikeA();
	    
	    
	    Boolean existsByTarga(String targa);
	    Optional<Auto> findByTarga(String targa);

		

}
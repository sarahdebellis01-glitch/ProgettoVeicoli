package com.betacom.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "colore")
public class Colore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdColore;

    @Column(length = 50, nullable = false, unique = true)
    private String nome;
}
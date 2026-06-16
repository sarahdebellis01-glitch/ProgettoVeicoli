package com.betacom.jpa.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(
    name = "moto",
    uniqueConstraints = @UniqueConstraint(name = "uk_moto_targa", columnNames = "targa")
)
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMoto;

    @Column(length = 10, nullable = false, unique = true)
    private String targa;

    @Column(nullable = false)
    private Integer cilindrata;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(
            name = "veicolo_id",
            referencedColumnName = "id_veicoli",
            foreignKey = @ForeignKey(name = "fk_moto_veicolo")
    )
    private Veicoli veicolo;
}
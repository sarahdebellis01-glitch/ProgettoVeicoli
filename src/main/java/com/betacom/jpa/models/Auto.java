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
        name = "auto",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_auto_targa", columnNames = "targa")
        }
)
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auto")
    private Integer idAuto;

    @Column(length = 10, nullable = false, unique = true)
    private String targa;

    @Column(nullable = false)
    private Integer cilindrata;

    @Column(name = "numero_porte", nullable = false)
    private Integer numeroPorte;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(
            name = "veicolo_id",
            referencedColumnName = "id_veicoli",
            foreignKey = @ForeignKey(name = "fk_auto_veicolo")
    )
    private Veicoli veicolo;
}
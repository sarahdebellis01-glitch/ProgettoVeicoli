package com.betacom.jpa.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "bici")
@NamedQuery(name = "bici.selectByFilter", query = "select b from Bici b")
public class Bici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bici")
    private Integer idBici;

    @Column(name = "tipo_freno", nullable = false)
    private String tipoFreno;

    @Column(name = "tipo_sospensione", nullable = false)
    private String tipoSospensione;

    @Column(name = "numero_marce", nullable = false)
    private Integer numeroMarce;

    @Column(nullable = false)
    private Boolean pieghevole;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(
            name = "veicolo_id",
            referencedColumnName = "id_veicoli",
            foreignKey = @ForeignKey(name = "fk_bici_veicolo")
    )
    private Veicoli veicolo;
}
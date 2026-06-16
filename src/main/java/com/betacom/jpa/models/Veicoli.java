package com.betacom.jpa.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "veicolo")
public class Veicoli {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_veicoli")
	private Integer idVeicoli;

    @Column(name="tipo_veicolo", nullable = false, length = 50)
    private String tipoVeicolo;

    @Column(name="numero_ruote", nullable = false)
    private Integer numeroRuote;

    @Column(nullable = false, length = 100)
    private String modello;

    @Column(nullable = false, length = 100)
    private String marca;

    @Column(name="anno_produzione", nullable = false)
    private Integer annoProduzione;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "colore_id")
    private Colore colore;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_alimentazione_id")
    private tipoAlimentazione tipoAlimentazione;
}
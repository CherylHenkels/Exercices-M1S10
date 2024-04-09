package br.fullstack.education.exerciciosm1s10.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "materiais")
@Data
public class MaterialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "agenda_id")
    private AgendaEntity agenda;

    private String descricao;

    @Column(nullable = false)
    private String caminhoArquivo;



}

package br.fullstack.education.exerciciosm1s10.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tutores")
@Data
public class TutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String especialidade;


}

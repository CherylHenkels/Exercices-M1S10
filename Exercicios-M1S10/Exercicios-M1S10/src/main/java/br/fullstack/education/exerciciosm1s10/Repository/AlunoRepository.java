package br.fullstack.education.exerciciosm1s10.Repository;

import br.fullstack.education.exerciciosm1s10.Entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
}

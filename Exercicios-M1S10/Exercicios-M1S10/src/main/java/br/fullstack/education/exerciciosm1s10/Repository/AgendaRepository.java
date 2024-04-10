package br.fullstack.education.exerciciosm1s10.Repository;

import br.fullstack.education.exerciciosm1s10.Entity.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {
}

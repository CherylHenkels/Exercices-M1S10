package br.fullstack.education.exerciciosm1s10.Repository;

import br.fullstack.education.exerciciosm1s10.Entity.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {

    List<AgendaEntity> findByAlunoIdOrderByData(Long alunoId);
    List<AgendaEntity> findByTutorIdOrderByData(Long tutorId);
}

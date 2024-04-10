package br.fullstack.education.exerciciosm1s10.Repository;

import br.fullstack.education.exerciciosm1s10.Entity.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<TutorEntity, Long> {
}

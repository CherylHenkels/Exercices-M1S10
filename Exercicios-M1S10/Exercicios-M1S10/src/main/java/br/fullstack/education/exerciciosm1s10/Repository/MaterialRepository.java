package br.fullstack.education.exerciciosm1s10.Repository;

import br.fullstack.education.exerciciosm1s10.Entity.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {
}

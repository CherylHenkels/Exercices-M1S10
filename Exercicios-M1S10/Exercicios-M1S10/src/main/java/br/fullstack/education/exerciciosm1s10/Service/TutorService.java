package br.fullstack.education.exerciciosm1s10.Service;

import br.fullstack.education.exerciciosm1s10.Entity.TutorEntity;

import java.util.List;

public interface TutorService {

    List<TutorEntity> buscarTodos();

    TutorEntity buscarPorId(Long id);

    TutorEntity criar(TutorEntity tutorEntity);

    TutorEntity atualizar(Long id, TutorEntity tutorEntity);

    void excluir(Long id);
}

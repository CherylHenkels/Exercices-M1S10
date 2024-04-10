package br.fullstack.education.exerciciosm1s10.Service;

import br.fullstack.education.exerciciosm1s10.Entity.AgendaEntity;

import java.util.List;

public interface AgendaService {

    List<AgendaEntity> buscarTodos();

    AgendaEntity buscarPorId(Long id);

    AgendaEntity criar(AgendaEntity agendaEntity);

    AgendaEntity atualizar(Long id, AgendaEntity agendaEntity);

    void excluir(Long id);

    List<AgendaEntity> buscarPorAlunoId(Long alunoId);

    List<AgendaEntity> buscarPorTutorId(Long tutorId);
}

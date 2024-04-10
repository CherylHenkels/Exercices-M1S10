package br.fullstack.education.exerciciosm1s10.Service;

import br.fullstack.education.exerciciosm1s10.Entity.MaterialEntity;

import java.util.List;

public interface MaterialService {

    List<MaterialEntity> buscarTodos();

    MaterialEntity buscarPorId(Long id);

    MaterialEntity criar(MaterialEntity materialEntity);

    MaterialEntity atualizar(Long id, MaterialEntity materialEntity);

    void excluir(Long id);
}

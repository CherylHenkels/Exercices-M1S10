package br.fullstack.education.exerciciosm1s10.Service;

import br.fullstack.education.exerciciosm1s10.Entity.AlunoEntity;
import java.util.List;

public interface AlunoService {

    List<AlunoEntity> buscarTodos();

    AlunoEntity buscarPorId(Long id);

    AlunoEntity criar(AlunoEntity alunoEntity);

    AlunoEntity atualizar(Long id, AlunoEntity alunoEntity);

    void excluir(Long id);
}

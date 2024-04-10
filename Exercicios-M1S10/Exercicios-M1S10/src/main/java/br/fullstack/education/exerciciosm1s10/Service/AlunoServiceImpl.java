package br.fullstack.education.exerciciosm1s10.Service;

import br.fullstack.education.exerciciosm1s10.Entity.AlunoEntity;
import br.fullstack.education.exerciciosm1s10.Repository.AlunoRepository;
import br.fullstack.education.exerciciosm1s10.Exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {
    private AlunoRepository alunoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<AlunoEntity> buscarTodos() {
        return alunoRepository.findAll();
    }

    @Override
    public AlunoEntity buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado com id " + id));
                //() ->: lambda function with no arguments.
                //this lambda expression is used to create a function or method that, when called, will throw a NotFoundException
    }

    @Override
    public AlunoEntity criar(AlunoEntity alunoEntity) {
        alunoEntity.setId(null);
        return alunoRepository.save(alunoEntity);
    }

    @Override
    public AlunoEntity atualizar(Long id, AlunoEntity alunoEntity) {
        buscarPorId(id);
        alunoEntity.setId(id);
        return alunoRepository.save(alunoEntity);
    }

    @Override
    public void excluir(Long id) {
        alunoRepository.delete(buscarPorId(id));
    }
}

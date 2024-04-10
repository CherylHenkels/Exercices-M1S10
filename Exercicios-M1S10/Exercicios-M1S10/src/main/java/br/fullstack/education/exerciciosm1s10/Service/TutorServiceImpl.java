package br.fullstack.education.exerciciosm1s10.Service;

import br.fullstack.education.exerciciosm1s10.Entity.TutorEntity;
import br.fullstack.education.exerciciosm1s10.Exception.NotFoundException;
import br.fullstack.education.exerciciosm1s10.Repository.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorServiceImpl implements TutorService {
    private TutorRepository tutorRepository;

    public TutorServiceImpl(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @Override
    public List<TutorEntity> buscarTodos() {
        return tutorRepository.findAll();
    }

    @Override
    public TutorEntity buscarPorId(Long id) {
        return tutorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tutor não encontrado com id " + id));
                //() ->: lambda function with no arguments.
                //this lambda expression is used to create a function or method that, when called, will throw a NotFoundException
    }

    @Override
    public TutorEntity criar(TutorEntity tutorEntity) {
        tutorEntity.setId(null);
        return tutorRepository.save(tutorEntity);
    }

    @Override
    public TutorEntity atualizar(Long id, TutorEntity tutorEntity) {
        buscarPorId(id);
        tutorEntity.setId(id);
        return tutorRepository.save(tutorEntity);
    }

    @Override
    public void excluir(Long id) {
        tutorRepository.delete(buscarPorId(id));
    }
}

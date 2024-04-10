package br.fullstack.education.exerciciosm1s10.Service;

import br.fullstack.education.exerciciosm1s10.Entity.AgendaEntity;
import br.fullstack.education.exerciciosm1s10.Entity.AlunoEntity;
import br.fullstack.education.exerciciosm1s10.Entity.TutorEntity;
import br.fullstack.education.exerciciosm1s10.Exception.NotFoundException;
import br.fullstack.education.exerciciosm1s10.Repository.AgendaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {

    private AgendaRepository agendaRepository;
    private AlunoService alunoService;
    private TutorService tutorService;


    public AgendaServiceImpl(TutorService tutorService, AlunoService alunoService, AgendaRepository agendaRepository) {
        this.tutorService = tutorService;
        this.alunoService = alunoService;
        this.agendaRepository = agendaRepository;
    }



    @Override
    public List<AgendaEntity> buscarTodos() {
        return agendaRepository.findAll();
    }

    @Override
    public AgendaEntity buscarPorId(Long id) {
        return agendaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Agenda não encontrado com id " + id));
                //() ->: lambda function with no arguments.
                //this lambda expression is used to create a function or method that, when called, will throw a NotFoundException
    }

    @Override
    public AgendaEntity criar(AgendaEntity agendaEntity) {
        agendaEntity.setId(null);

        AlunoEntity alunoEntity = alunoService.buscarPorId(agendaEntity.getAluno().getId());
        agendaEntity.setAluno(alunoEntity);

        TutorEntity tutorEntity = tutorService.buscarPorId(agendaEntity.getTutor().getId());
        agendaEntity.setTutor(tutorEntity);

        return agendaRepository.save(agendaEntity);
    }

    @Override
    public AgendaEntity atualizar(Long id, AgendaEntity agendaEntity) {
        buscarPorId(id);
        agendaEntity.setId(id);

        AlunoEntity alunoEntity = alunoService.buscarPorId(agendaEntity.getAluno().getId());
        agendaEntity.setAluno(alunoEntity);

        TutorEntity tutorEntity = tutorService.buscarPorId(agendaEntity.getTutor().getId());
        agendaEntity.setTutor(tutorEntity);

        return agendaRepository.save(agendaEntity);
    }

    @Override
    public void excluir(Long id) {
        agendaRepository.delete(buscarPorId(id));
    }

    @Override
    public List<AgendaEntity> buscarPorAlunoId(Long alunoId) {
        alunoService.buscarPorId(alunoId);
        return agendaRepository.findByAlunoIdOrderByData(alunoId);
    }

    @Override
    public List<AgendaEntity> buscarPorAlunoIdProximos(Long alunoId) {
        alunoService.buscarPorId(alunoId);
        return agendaRepository.findByAlunoIdAndDataGreaterThanOrderByData(alunoId, LocalDate.now());
    }


    @Override
    public List<AgendaEntity> buscarPorTutorId(Long tutorId) {
        tutorService.buscarPorId(tutorId);
        return agendaRepository.findByTutorIdOrderByData(tutorId);
    }

    @Override
    public List<AgendaEntity> buscarPorTutorIdProximos(Long tutorId) {
        tutorService.buscarPorId(tutorId);
        return agendaRepository.findByTutorIdAndDataGreaterThanOrderByData(tutorId, LocalDate.now());

    }
}

package br.fullstack.education.exerciciosm1s10.Service;

import br.fullstack.education.exerciciosm1s10.Entity.AgendaEntity;
import br.fullstack.education.exerciciosm1s10.Exception.NotFoundException;
import br.fullstack.education.exerciciosm1s10.Repository.AgendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {
    private AgendaRepository agendaRepository;

    public AgendaServiceImpl(AgendaRepository agendaRepository) {
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
        return agendaRepository.save(agendaEntity);
    }

    @Override
    public AgendaEntity atualizar(Long id, AgendaEntity agendaEntity) {
        buscarPorId(id);
        agendaEntity.setId(id);
        return agendaRepository.save(agendaEntity);
    }

    @Override
    public void excluir(Long id) {
        agendaRepository.delete(buscarPorId(id));
    }
}

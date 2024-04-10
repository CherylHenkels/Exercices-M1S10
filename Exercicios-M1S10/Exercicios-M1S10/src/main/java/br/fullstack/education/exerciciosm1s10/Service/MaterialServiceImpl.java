package br.fullstack.education.exerciciosm1s10.Service;

import br.fullstack.education.exerciciosm1s10.Entity.MaterialEntity;
import br.fullstack.education.exerciciosm1s10.Exception.NotFoundException;
import br.fullstack.education.exerciciosm1s10.Repository.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {
    private MaterialRepository materialRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public List<MaterialEntity> buscarTodos() {
        return materialRepository.findAll();
    }

    @Override
    public MaterialEntity buscarPorId(Long id) {
        return materialRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Material não encontrado com id " + id));
                //() ->: lambda function with no arguments.
                //this lambda expression is used to create a function or method that, when called, will throw a NotFoundException
    }

    @Override
    public MaterialEntity criar(MaterialEntity materialEntity) {
        materialEntity.setId(null);
        return materialRepository.save(materialEntity);
    }

    @Override
    public MaterialEntity atualizar(Long id, MaterialEntity materialEntity) {
        buscarPorId(id);
        materialEntity.setId(id);
        return materialRepository.save(materialEntity);
    }

    @Override
    public void excluir(Long id) {
        materialRepository.delete(buscarPorId(id));
    }
}

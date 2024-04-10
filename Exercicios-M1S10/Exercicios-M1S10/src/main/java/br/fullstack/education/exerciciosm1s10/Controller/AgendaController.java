package br.fullstack.education.exerciciosm1s10.Controller;

import br.fullstack.education.exerciciosm1s10.Entity.AgendaEntity;
import br.fullstack.education.exerciciosm1s10.Service.AgendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agendas")
public class AgendaController {

    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping
    public ResponseEntity<List<AgendaEntity>> get(){
        return ResponseEntity.ok(agendaService.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<AgendaEntity> getId(@PathVariable Long id){
        return ResponseEntity.ok(agendaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<AgendaEntity> post(@RequestBody AgendaEntity agendaEntity){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(agendaService.criar(agendaEntity));
    }

    @PutMapping("{id}")
    public ResponseEntity<AgendaEntity> put(@PathVariable Long id, @RequestBody AgendaEntity agendaEntity){
        return ResponseEntity.ok(agendaService.atualizar(id,agendaEntity));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        agendaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

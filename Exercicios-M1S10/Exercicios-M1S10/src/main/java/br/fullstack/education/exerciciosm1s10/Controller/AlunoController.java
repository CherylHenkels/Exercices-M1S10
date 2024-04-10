package br.fullstack.education.exerciciosm1s10.Controller;

import br.fullstack.education.exerciciosm1s10.Entity.AlunoEntity;
import br.fullstack.education.exerciciosm1s10.Service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<AlunoEntity>> get(){
        return ResponseEntity.ok(alunoService.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<AlunoEntity> getId(@PathVariable Long id){
        return ResponseEntity.ok(alunoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<AlunoEntity> post(@RequestBody AlunoEntity alunoEntity){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(alunoService.criar(alunoEntity));
    }

    @PutMapping("{id}")
    public ResponseEntity<AlunoEntity> put(@PathVariable Long id, @RequestBody AlunoEntity alunoEntity){
        return ResponseEntity.ok(alunoService.atualizar(id,alunoEntity));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        alunoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

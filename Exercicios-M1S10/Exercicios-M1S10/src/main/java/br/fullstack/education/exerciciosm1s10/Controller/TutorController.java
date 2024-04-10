package br.fullstack.education.exerciciosm1s10.Controller;

import br.fullstack.education.exerciciosm1s10.Entity.TutorEntity;
import br.fullstack.education.exerciciosm1s10.Service.TutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tutores")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping
    public ResponseEntity<List<TutorEntity>> get(){
        return ResponseEntity.ok(tutorService.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<TutorEntity> getId(@PathVariable Long id){
        return ResponseEntity.ok(tutorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TutorEntity> post(@RequestBody TutorEntity tutorEntity){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(tutorService.criar(tutorEntity));
    }

    @PutMapping("{id}")
    public ResponseEntity<TutorEntity> put(@PathVariable Long id, @RequestBody TutorEntity tutorEntity){
        return ResponseEntity.ok(tutorService.atualizar(id,tutorEntity));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        tutorService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

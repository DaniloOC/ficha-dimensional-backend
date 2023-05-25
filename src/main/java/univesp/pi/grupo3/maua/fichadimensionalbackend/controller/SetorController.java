package univesp.pi.grupo3.maua.fichadimensionalbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import univesp.pi.grupo3.maua.fichadimensionalbackend.model.Setor;
import univesp.pi.grupo3.maua.fichadimensionalbackend.service.SetorService;

@RestController
@RequestMapping("/api/setor")
public class SetorController {

    @Autowired
    private SetorService service;

    @GetMapping
    public List<Setor> lista() {
        return service.listaTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Setor> get(@PathVariable("id") Long id) {
        Optional<Setor> setorOpt = service.findById(id);
        if (!setorOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(setorOpt.get());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Setor> salvar(@RequestBody Setor request) {
        Setor setor = service.salvar(request);
        return ResponseEntity.status(HttpStatus.OK).body(setor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Optional<Setor> setorOpt = service.findById(id);
        if (!setorOpt.isPresent()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Setor não foi encontrado.");
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Setor removido com sucesso.");
    }

}

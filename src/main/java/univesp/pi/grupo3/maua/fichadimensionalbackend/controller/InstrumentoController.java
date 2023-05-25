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

import univesp.pi.grupo3.maua.fichadimensionalbackend.model.Instrumento;
import univesp.pi.grupo3.maua.fichadimensionalbackend.service.InstrumentoService;

@RestController
@RequestMapping("/api/instrumento")
public class InstrumentoController {

    @Autowired
    private InstrumentoService service;

    @GetMapping
    public List<Instrumento> lista() {
        return service.listaTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrumento> get(@PathVariable("id") Long id) {
        Optional<Instrumento> instrumentoOpt = service.findById(id);
        if (!instrumentoOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(instrumentoOpt.get());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Instrumento> salvar(@RequestBody Instrumento request) {
        Instrumento instrumento = service.salvar(request);
        return ResponseEntity.status(HttpStatus.OK).body(instrumento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Optional<Instrumento> instrumentoOpt = service.findById(id);
        if (!instrumentoOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instrumento não foi encontrado.");
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Instrumento removido com sucesso.");
    }

}

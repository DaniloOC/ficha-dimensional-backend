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

import univesp.pi.grupo3.maua.fichadimensionalbackend.model.Maquina;
import univesp.pi.grupo3.maua.fichadimensionalbackend.service.MaquinaService;

@RestController
@RequestMapping("/api/maquina")
public class MaquinaController {

    @Autowired
    private MaquinaService service;

    @GetMapping
    public List<Maquina> lista() {
        return service.listaTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maquina> get(@PathVariable("id") Long id) {
        Optional<Maquina> maquinaOpt = service.findById(id);
        if (!maquinaOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(maquinaOpt.get());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Maquina> salvar(@RequestBody Maquina request) {
        Maquina maquina = service.salvar(request);
        return ResponseEntity.status(HttpStatus.OK).body(maquina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Optional<Maquina> maquinaOpt = service.findById(id);
        if (!maquinaOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Maquina não foi encontrada.");
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Maquina removido com sucesso.");
    }

}

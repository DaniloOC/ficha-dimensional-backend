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

import univesp.pi.grupo3.maua.fichadimensionalbackend.model.Funcionario;
import univesp.pi.grupo3.maua.fichadimensionalbackend.service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<Funcionario> lista() {
        return service.listaTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> get(@PathVariable("id") Long id) {
        Optional<Funcionario> funcionarioOpt = service.findById(id);
        if (!funcionarioOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioOpt.get());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario request) {
        Funcionario funcionario = service.salvar(request);
        return ResponseEntity.status(HttpStatus.OK).body(funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Optional<Funcionario> produtoOpt = service.findById(id);
        if (!produtoOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não foi encontrado.");
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Funcionario removido com sucesso.");
    }

}

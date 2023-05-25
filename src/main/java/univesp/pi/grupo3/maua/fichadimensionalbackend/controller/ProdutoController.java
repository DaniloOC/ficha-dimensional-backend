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

import univesp.pi.grupo3.maua.fichadimensionalbackend.model.Produto;
import univesp.pi.grupo3.maua.fichadimensionalbackend.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> lista() {
        return service.listaTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> get(@PathVariable("id") Long id) {
        Optional<Produto> produtoOpt = service.findById(id);
        if (!produtoOpt.isPresent()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoOpt.get());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> salvar(@RequestBody Produto request) {
        Produto produto = service.salvar(request);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Optional<Produto> produtoOpt = service.findById(id);
        if (!produtoOpt.isPresent()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não foi encontrado.");
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Produto removido com sucesso.");
    }

}

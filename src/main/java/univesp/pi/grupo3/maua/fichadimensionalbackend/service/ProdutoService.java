package univesp.pi.grupo3.maua.fichadimensionalbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univesp.pi.grupo3.maua.fichadimensionalbackend.model.Produto;
import univesp.pi.grupo3.maua.fichadimensionalbackend.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listaTodos() {
        return repository.findAllByOrderByIdAsc();
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Optional<Produto> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}

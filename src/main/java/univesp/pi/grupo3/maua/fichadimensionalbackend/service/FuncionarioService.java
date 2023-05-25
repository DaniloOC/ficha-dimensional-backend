package univesp.pi.grupo3.maua.fichadimensionalbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univesp.pi.grupo3.maua.fichadimensionalbackend.model.Funcionario;
import univesp.pi.grupo3.maua.fichadimensionalbackend.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> listaTodos() {
        return repository.findAllByOrderByIdAsc();
    }

    public Funcionario salvar(Funcionario produto) {
        return repository.save(produto);
    }

    public Optional<Funcionario> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}

package univesp.pi.grupo3.maua.fichadimensionalbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univesp.pi.grupo3.maua.fichadimensionalbackend.model.Setor;
import univesp.pi.grupo3.maua.fichadimensionalbackend.repository.SetorRepository;

@Service
public class SetorService {

    @Autowired
    private SetorRepository repository;

    public List<Setor> listaTodos() {
        return repository.findAllByOrderByIdAsc();
    }

    public Setor salvar(Setor setor) {
        return repository.save(setor);
    }

    public Optional<Setor> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}

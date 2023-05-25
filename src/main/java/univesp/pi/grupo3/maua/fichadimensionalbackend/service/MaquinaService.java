package univesp.pi.grupo3.maua.fichadimensionalbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univesp.pi.grupo3.maua.fichadimensionalbackend.model.Maquina;
import univesp.pi.grupo3.maua.fichadimensionalbackend.repository.MaquinaRepository;

@Service
public class MaquinaService {

    @Autowired
    private MaquinaRepository repository;

    public List<Maquina> listaTodos() {
        return repository.findAllByOrderByIdAsc();
    }

    public Maquina salvar(Maquina setor) {
        return repository.save(setor);
    }

    public Optional<Maquina> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}

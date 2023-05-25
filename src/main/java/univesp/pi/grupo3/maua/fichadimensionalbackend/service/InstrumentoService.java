package univesp.pi.grupo3.maua.fichadimensionalbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univesp.pi.grupo3.maua.fichadimensionalbackend.model.Instrumento;
import univesp.pi.grupo3.maua.fichadimensionalbackend.repository.InstrumentoRepository;

@Service
public class InstrumentoService {

    @Autowired
    private InstrumentoRepository repository;

    public List<Instrumento> listaTodos() {
        return repository.findAllByOrderByIdAsc();
    }

    public Instrumento salvar(Instrumento instrumento) {
        return repository.save(instrumento);
    }

    public Optional<Instrumento> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}

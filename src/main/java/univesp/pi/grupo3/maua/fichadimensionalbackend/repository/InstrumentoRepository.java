package univesp.pi.grupo3.maua.fichadimensionalbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import univesp.pi.grupo3.maua.fichadimensionalbackend.model.Instrumento;

public interface InstrumentoRepository extends JpaRepository<Instrumento, Long> {

    List<Instrumento> findAllByOrderByIdAsc();

}

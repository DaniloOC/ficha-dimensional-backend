package univesp.pi.grupo3.maua.fichadimensionalbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import univesp.pi.grupo3.maua.fichadimensionalbackend.model.Setor;

public interface SetorRepository extends JpaRepository<Setor, Long> {

    List<Setor> findAllByOrderByIdAsc();

}

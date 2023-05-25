package univesp.pi.grupo3.maua.fichadimensionalbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import univesp.pi.grupo3.maua.fichadimensionalbackend.model.Maquina;

public interface MaquinaRepository extends JpaRepository<Maquina, Long> {

    List<Maquina> findAllByOrderByIdAsc();

}

package univesp.pi.grupo3.maua.fichadimensionalbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import univesp.pi.grupo3.maua.fichadimensionalbackend.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findAllByOrderByIdAsc();

}

package univesp.pi.grupo3.maua.fichadimensionalbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import univesp.pi.grupo3.maua.fichadimensionalbackend.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findAllByOrderByIdAsc();

}

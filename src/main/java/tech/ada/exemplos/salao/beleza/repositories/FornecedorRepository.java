package tech.ada.exemplos.salao.beleza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.exemplos.salao.beleza.entities.Fornecedor;

import java.util.Optional;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    Optional<Fornecedor> findByIdentificador(String identificador);
}

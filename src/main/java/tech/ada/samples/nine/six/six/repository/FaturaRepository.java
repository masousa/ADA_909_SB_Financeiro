package tech.ada.samples.nine.six.six.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.samples.nine.six.six.entity.Fatura;

import java.util.Optional;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Long> {

    Optional<Fatura> findByMesAndAnoAndUsuarioId(String mes, Integer ano, Long usuarioId);
}

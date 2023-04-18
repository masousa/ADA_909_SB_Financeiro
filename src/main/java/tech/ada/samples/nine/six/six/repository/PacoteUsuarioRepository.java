package tech.ada.samples.nine.six.six.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.samples.nine.six.six.entity.PacoteUsuario;

import java.util.List;

@Repository
public interface PacoteUsuarioRepository extends JpaRepository<PacoteUsuario, Long> {
    List<PacoteUsuario> findByUsuarioId(Long usuarioId);
}

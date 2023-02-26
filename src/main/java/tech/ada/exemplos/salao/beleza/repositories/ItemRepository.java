package tech.ada.exemplos.salao.beleza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.exemplos.salao.beleza.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}

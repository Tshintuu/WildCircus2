package fr.wildcodeschool.wildcircus.repositories;

import fr.wildcodeschool.wildcircus.entities.ProductColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductColorDAO extends JpaRepository<ProductColor, Long> {
}

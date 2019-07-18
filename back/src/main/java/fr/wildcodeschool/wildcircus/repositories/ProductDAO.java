package fr.wildcodeschool.wildcircus.repositories;

import fr.wildcodeschool.wildcircus.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {
}

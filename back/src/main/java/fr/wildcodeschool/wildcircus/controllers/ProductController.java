package fr.wildcodeschool.wildcircus.controllers;


import fr.wildcodeschool.wildcircus.entities.Category;
import fr.wildcodeschool.wildcircus.entities.Product;
import fr.wildcodeschool.wildcircus.entities.ProductDTO;
import fr.wildcodeschool.wildcircus.repositories.CategoryDAO;
import fr.wildcodeschool.wildcircus.repositories.ProductColorDAO;
import fr.wildcodeschool.wildcircus.repositories.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {

    @Autowired
    private ProductDAO dao;

    @Autowired
    private ProductColorDAO colorDAO;

    @Autowired
    private CategoryDAO categoryDAO;

    @GetMapping(value ="/products")
    public List<Product> getAll(){
        return dao.findAll();
    }


    @PostMapping("/products")
    public Product create(@RequestBody ProductDTO p_product) throws Exception {

        Product current = new Product();
        current.setName(p_product.getName());
        current.setPrice(p_product.getPrice());
        current.setImgUrl(p_product.getImgUrl());
        current.setDescription(p_product.getDescription());

        current.setCategory(categoryDAO.findById(p_product.getCategory_id()).get());
        return dao.save(current);
    }
}

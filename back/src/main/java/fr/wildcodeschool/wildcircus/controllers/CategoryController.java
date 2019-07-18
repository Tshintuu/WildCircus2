package fr.wildcodeschool.wildcircus.controllers;


import fr.wildcodeschool.wildcircus.entities.Category;
import fr.wildcodeschool.wildcircus.entities.Product;
import fr.wildcodeschool.wildcircus.entities.ProductDTO;
import fr.wildcodeschool.wildcircus.repositories.CategoryDAO;
import fr.wildcodeschool.wildcircus.repositories.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController

public class CategoryController {

    @Autowired
    private ProductDAO dao;

    @Autowired
    private CategoryDAO categoryDAO;


    @GetMapping(value ="/products/category")
    public List<Category> getAll(){
        return categoryDAO.findAll();
    }


    @PostMapping("/products/category")
    public Category create(@RequestBody Category category) throws Exception {

        return categoryDAO.save(category);
    }
}

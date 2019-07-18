package fr.wildcodeschool.wildcircus.controllers;

import fr.wildcodeschool.wildcircus.entities.ProductColor;
import fr.wildcodeschool.wildcircus.entities.ProductColorDTO;

import fr.wildcodeschool.wildcircus.repositories.ProductColorDAO;
import fr.wildcodeschool.wildcircus.repositories.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
public class ProductColorController {

    @Autowired
    private ProductDAO dao;

    @Autowired
    private ProductColorDAO colorDAO;

    @GetMapping(value ="/products/color")
    public List<ProductColor> getAll(){
        return colorDAO.findAll();
    }

    @PostMapping("/products/color")
    public ProductColor create(@RequestBody ProductColorDTO p_productcolor) throws Exception {

        ProductColor current = new ProductColor();
        current.setCode(p_productcolor.getCode());
        current.setUrl(p_productcolor.getUrl());

        current.setProduct(dao.findById(p_productcolor.getProductId()).get());
        return colorDAO.save(current);
    }

}

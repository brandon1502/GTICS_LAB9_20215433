package com.example.lab9_20215433.controller;

import com.example.lab9_20215433.dao.CategoriaDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/categoria")

public class CategoriaController {

    final CategoriaDao categoryDao;


    public CategoriaController(CategoriaDao categoryDao) {
        this.categoryDao = categoryDao;

    }

    @GetMapping({"/lista", "", "/"})
    public String listarCategorias(Model model) {
        //model.addAttribute("listaProductos", productRepository.findAll());
        model.addAttribute("listaCategorias", categoryDao.listar());
        return "comida/listaCategorias";
    }



}

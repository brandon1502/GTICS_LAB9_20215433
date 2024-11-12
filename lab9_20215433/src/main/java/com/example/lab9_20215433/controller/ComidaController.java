package com.example.lab9_20215433.controller;
import com.example.lab9_20215433.dao.ComidaDao;
import com.example.lab9_20215433.entity.Comida;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/comida")

public class ComidaController {

    final ComidaDao comidaDao;


    public ComidaController(ComidaDao comidaDao) {
        this.comidaDao = comidaDao;

    }

    @GetMapping("/listarPorBuscador")
    public String listarPorBuscador(@RequestParam("nombre") String nombre, Model model){
        List<Comida> listaComidas = comidaDao.buscarComida(nombre);
        model.addAttribute("listaComidas", listaComidas);
        //mostraremos la funcionalidad del buscador en el mismo html que el inciso 1
        return "comida/listaCategorias";
    }

    @GetMapping("/verDetalles")
    public String verDetalles(@RequestParam("id") String id,Model model){
        Comida comida = comidaDao.verDetallesComida(id);
        model.addAttribute("comida", comida);
        return "comida/verDetalles";
    }
}

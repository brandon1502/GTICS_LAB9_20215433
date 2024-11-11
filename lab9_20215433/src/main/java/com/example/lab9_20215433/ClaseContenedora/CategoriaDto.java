package com.example.lab9_20215433.ClaseContenedora;

import com.example.lab9_20215433.entity.Categoria;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoriaDto {
    private List<Categoria> categories;
}
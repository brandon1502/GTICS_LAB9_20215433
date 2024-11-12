package com.example.lab9_20215433.dao;

import com.example.lab9_20215433.ClaseContenedora.CategoriaDto;
import com.example.lab9_20215433.entity.Categoria;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriaDao {

    public List<Categoria> listar() {

        List<Categoria> lista = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        String endPoint = "https://www.themealdb.com/api/json/v1/1/categories.php";

        ResponseEntity<CategoriaDto> responseEntity = restTemplate.getForEntity(endPoint, CategoriaDto.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            CategoriaDto categoriaDto = responseEntity.getBody();

            if (categoriaDto != null) {
                lista = categoriaDto.getCategories();

            }
        }
        return lista;
    }
}
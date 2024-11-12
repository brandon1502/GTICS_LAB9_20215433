package com.example.lab9_20215433.dao;

import com.example.lab9_20215433.ClaseContenedora.ComidaDto;
import com.example.lab9_20215433.entity.Comida;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Component
public class ComidaDao {

    public List<Comida> buscarComida(String nombreComida) {

        List<Comida> lista = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        String endPoint = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + nombreComida;

        ResponseEntity<ComidaDto> responseEntity = restTemplate.getForEntity(endPoint, ComidaDto.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            ComidaDto comidaDto = responseEntity.getBody();

            if (comidaDto != null) {
                lista = comidaDto.getMeals();

            }
        }
        return lista;
    }

    public Comida verDetallesComida(String id) {

        RestTemplate restTemplate = new RestTemplate();

        String endPoint = "https://www.themealdb.com/api/json/v1/1/lookup.php?i=" + id;

        ResponseEntity<ComidaDto> responseEntity = restTemplate.getForEntity(endPoint, ComidaDto.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {

            ComidaDto comidaDto = responseEntity.getBody();

            if (comidaDto != null && comidaDto.getMeals() != null && !comidaDto.getMeals().isEmpty()) {
                return comidaDto.getMeals().get(0);
            } else {
                return null;
            }
        }
        return null;
    }

}
package com.example.lab9_20215433.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "platosfavoritos")
public class PlatoFavorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idplatosFavoritos", nullable = false)
    private int id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "foto", nullable = false)
    private String foto;

    @Column(name = "categoria", nullable = false, length = 45)
    private String categoria;






}

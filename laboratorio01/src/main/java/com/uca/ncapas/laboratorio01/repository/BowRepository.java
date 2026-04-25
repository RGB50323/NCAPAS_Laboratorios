package com.uca.ncapas.laboratorio01.repository;

import com.uca.ncapas.laboratorio01.model.Bow;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BowRepository {

    private final List<Bow> bowList = new ArrayList<>();

    public BowRepository() {
        bowList.add(new Bow("Licker", "T-Virus", 4, "Cabeza", "En libertad", "Comisaría", "A-32"));
        bowList.add(new Bow("Hunter", "T-Virus", 3, "Cuello", "Contenido", "Laboratorio", "B-14"));
        bowList.add(new Bow("Tyrant", "G-Virus", 5, "Corazón expuesto", "En libertad", "Mansión", "C-20"));
        bowList.add(new Bow("Regenerador", "Las Plagas", 4, "Parásitos internos", "Eliminado", "Pueblo", "Lab Redes"));
        bowList.add(new Bow("Lady Dimitrescu", "Cadou", 5, "Torso", "En libertad", "Castillo", "Aula Magna"));
    }

    public List<Bow> findAll() {
        return new ArrayList<>(bowList);
    }
}
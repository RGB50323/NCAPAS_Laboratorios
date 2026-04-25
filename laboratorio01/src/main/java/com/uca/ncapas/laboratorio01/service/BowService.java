package com.uca.ncapas.laboratorio01.service;

import com.uca.ncapas.laboratorio01.model.Bow;
import com.uca.ncapas.laboratorio01.repository.BowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BowService {

    private final BowRepository bowRepository;

    public BowService(BowRepository bowRepository) {
        this.bowRepository = bowRepository;
    }

    public List<Bow> filtrarPorVirus(String virusBase) {
        return bowRepository.findAll()
                .stream()
                .filter(bow -> bow.getVirusBase().equalsIgnoreCase(virusBase))
                .toList();
    }

    public List<Bow> filtrarPorEstado(String estadoActual) {
        return bowRepository.findAll()
                .stream()
                .filter(bow -> bow.getEstadoActual().equalsIgnoreCase(estadoActual))
                .toList();
    }

    public List<String> virusActivosSinRepeticion() {
        return bowRepository.findAll()
                .stream()
                .filter(bow -> bow.getEstadoActual().equalsIgnoreCase("En libertad"))
                .map(Bow::getVirusBase)
                .distinct()
                .toList();
    }
}
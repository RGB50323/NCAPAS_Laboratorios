package uca.ncapas.laboratorio02.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uca.ncapas.laboratorio02.domain.entity.Pirate;
import uca.ncapas.laboratorio02.repository.PirataRepository;
import uca.ncapas.laboratorio02.service.PirataService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PirataServiceImpl implements PirataService {

    private final PirataRepository pirataRepository;

    @Override
    public Pirate createPirate(Pirate pirate) {
        return pirataRepository.save(pirate);
    }

    @Override
    public List<Pirate> getAllPirates() {
        return pirataRepository.findAll();
    }

    @Override
    public Pirate getPirateById(UUID id) {
        return pirataRepository.findById(id).orElse(null);
    }

    @Override
    public Pirate updatePirate(Pirate pirate) {
        return pirataRepository.save(pirate);
    }

    @Override
    public void deletePirate(UUID id) {
        pirataRepository.deleteById(id);
    }
}

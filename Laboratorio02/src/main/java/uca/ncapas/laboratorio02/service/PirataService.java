package uca.ncapas.laboratorio02.service;


import uca.ncapas.laboratorio02.domain.entity.Pirate;

import java.util.List;
import java.util.UUID;

public interface PirataService {

    Pirate createPirate(Pirate pirate);
    List<Pirate> getAllPirates();
    Pirate getPirateById(UUID id);
    Pirate updatePirate(Pirate pirate);
    void deletePirate(UUID id);

}

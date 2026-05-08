package uca.ncapas.laboratorio02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uca.ncapas.laboratorio02.domain.entity.Pirate;

import java.util.UUID;

@Repository
public interface PirataRepository extends JpaRepository<Pirate, UUID> {
}

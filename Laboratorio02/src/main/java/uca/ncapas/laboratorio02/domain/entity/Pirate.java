package uca.ncapas.laboratorio02.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "Piratas")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pirate {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Bounty")
    private double bounty;

    @Column(name = "Crew")
    private String crew;

    @Column(name = "PirateAlive")
    private Boolean isAlive;
}

package uca.ncapas.laboratorio02.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uca.ncapas.laboratorio02.domain.entity.Pirate;
import uca.ncapas.laboratorio02.service.PirataService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pirate")
public class PirateController {

    private final PirataService pirataService;

    @PostMapping("/create")
    public ResponseEntity<Pirate> createPirate(@RequestBody Pirate pirate){
        return ResponseEntity.status(HttpStatus.CREATED).body(pirataService.createPirate(pirate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pirate> getPirate(@PathVariable UUID id) {
        return ResponseEntity.ok(pirataService.getPirateById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Pirate>> getAllPirates(){
        return ResponseEntity.ok(pirataService.getAllPirates());
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Pirate> updatePirate(@RequestBody Pirate pirate, @PathVariable UUID id){
        pirate.setId(id);
        pirataService.updatePirate(pirate);
        return ResponseEntity.status(HttpStatus.OK).body(pirate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pirate> deletePirate(@PathVariable UUID id){
        pirataService.deletePirate(id);
        return ResponseEntity.ok().build();
    }

}

package uca.ncapas.laboratorio02.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uca.ncapas.laboratorio02.domain.entity.Pirate;
import uca.ncapas.laboratorio02.repository.PirataRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PirataServiceImplTest {

    @Mock
    private PirataRepository pirataRepository;

    @InjectMocks
    private PirataServiceImpl pirataService;

    private UUID pirateId;
    private Pirate pirate;

    @BeforeEach
    void setUp() {
        pirateId = UUID.randomUUID();

        pirate = Pirate.builder()
                .id(pirateId)
                .name("Monkey D. Luffy")
                .bounty(3000000000.0)
                .crew("Straw Hat Pirates")
                .isAlive(true)
                .build();
    }

    @Test
    void createPirate_shouldSaveAndReturnPirate() {
        when(pirataRepository.save(pirate)).thenReturn(pirate);

        Pirate result = pirataService.createPirate(pirate);

        assertThat(result).isEqualTo(pirate);
        verify(pirataRepository).save(pirate);
    }

    @Test
    void getAllPirates_shouldReturnList() {
        when(pirataRepository.findAll()).thenReturn(List.of(pirate));

        List<Pirate> result = pirataService.getAllPirates();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Monkey D. Luffy");
    }

    @Test
    void getPirateById_shouldReturnPirate_whenExists() {
        when(pirataRepository.findById(pirateId)).thenReturn(Optional.of(pirate));

        Pirate result = pirataService.getPirateById(pirateId);

        assertThat(result).isEqualTo(pirate);
    }

    @Test
    void getPirateById_shouldReturnNull_whenNotExists() {
        when(pirataRepository.findById(pirateId)).thenReturn(Optional.empty());

        Pirate result = pirataService.getPirateById(pirateId);

        assertThat(result).isNull();
    }

    @Test
    void deletePirate_shouldCallRepository() {
        doNothing().when(pirataRepository).deleteById(pirateId);

        pirataService.deletePirate(pirateId);

        verify(pirataRepository).deleteById(pirateId);
    }
}
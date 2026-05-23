package uca.ncapas.laboratorio03.services.ServiceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uca.ncapas.laboratorio03.common.mappers.SpecimenMapper;
import uca.ncapas.laboratorio03.domain.dto.request.CreateSpecimenRequest;
import uca.ncapas.laboratorio03.domain.dto.request.UpdateSpecimenRequest;
import uca.ncapas.laboratorio03.domain.dto.response.PageableResponse;
import uca.ncapas.laboratorio03.domain.dto.response.SpecimenResponse;
import uca.ncapas.laboratorio03.domain.entities.Specimen;
import uca.ncapas.laboratorio03.exceptions.ResourceNotFoundException;
import uca.ncapas.laboratorio03.repositories.SpecimenRepository;
import uca.ncapas.laboratorio03.services.SpecimenService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpecimenServiceImpl implements SpecimenService {
    private final SpecimenRepository specimenRepository;
    private final SpecimenMapper specimenMapper;

    @Override
    @Transactional
    public SpecimenResponse createSpecimen(CreateSpecimenRequest request) {
        return specimenMapper.toDto(
                specimenRepository.save(specimenMapper.toEntityCreate(request))
        );
    }

    @Override
    public PageableResponse<SpecimenResponse> getAllSpecimens(int page, int size, String sortBy, String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() :
                Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        PageableResponse<SpecimenResponse> result = specimenMapper.toDtoPage(specimenRepository.findAll(pageable));

        if (result.getTotalElements() == 0)
            throw new ResourceNotFoundException("No specimens are registered in Hyrule");

        return result;
    }

    @Override
    public SpecimenResponse getSpecimenById(UUID id) {
        return specimenMapper.toDto(specimenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Specimen not found in Sheikah Slate records"))
        );
    }

    @Override
    @Transactional
    public SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request) {
        this.getSpecimenById(id);
        return specimenMapper.toDto(specimenRepository.save(specimenMapper.toEntityUpdate(request, id)));
    }

    @Transactional
    public SpecimenResponse deleteSpecimen(UUID id) {
        SpecimenResponse existSpecimen = this.getSpecimenById(id);
        specimenRepository.deleteById(id);
        return existSpecimen;
    }
}
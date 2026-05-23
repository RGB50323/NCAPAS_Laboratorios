package uca.ncapas.laboratorio03.services;

import uca.ncapas.laboratorio03.domain.dto.request.CreateSpecimenRequest;
import uca.ncapas.laboratorio03.domain.dto.request.UpdateSpecimenRequest;
import uca.ncapas.laboratorio03.domain.dto.response.PageableResponse;
import uca.ncapas.laboratorio03.domain.dto.response.SpecimenResponse;

import java.util.List;
import java.util.UUID;

public interface SpecimenService {
    SpecimenResponse createSpecimen(CreateSpecimenRequest specimenRequest);
    SpecimenResponse updateSpecimen(UUID uuid, UpdateSpecimenRequest specimenRequest);
    PageableResponse<SpecimenResponse> getAllSpecimens(int page, int size, String sortBy, String sortOrder);
    SpecimenResponse getSpecimenById(UUID uuid);
    SpecimenResponse deleteSpecimen(UUID uuid);
}

package uca.ncapas.laboratorio03.common.mappers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import uca.ncapas.laboratorio03.domain.dto.request.CreateSpecimenRequest;
import uca.ncapas.laboratorio03.domain.dto.request.UpdateSpecimenRequest;
import uca.ncapas.laboratorio03.domain.dto.response.PageableResponse;
import uca.ncapas.laboratorio03.domain.dto.response.SpecimenResponse;
import uca.ncapas.laboratorio03.domain.entities.Specimen;

import java.util.UUID;

@Component
public class SpecimenMapper {

    public Specimen toEntityCreate(CreateSpecimenRequest request) {
        return Specimen.builder()
                .name(request.getName())
                .region(request.getRegion())
                .dangerLevel(request.getDangerLevel())
                .isFriendly(request.getIsFriendly())
                .build();
    }

    public Specimen toEntityUpdate(UpdateSpecimenRequest request, UUID id) {
        return Specimen.builder()
                .id(id)
                .name(request.getName())
                .region(request.getRegion())
                .dangerLevel(request.getDangerLevel())
                .isFriendly(request.getIsFriendly())
                .build();
    }

    public SpecimenResponse toDto(Specimen specimen) {
        return SpecimenResponse.builder()
                .id(specimen.getId())
                .name(specimen.getName())
                .region(specimen.getRegion())
                .dangerLevel(specimen.getDangerLevel())
                .isFriendly(specimen.getIsFriendly())
                .build();
    }

    public PageableResponse<SpecimenResponse> toDtoPage(Page<Specimen> specimens) {
        return PageableResponse.<SpecimenResponse>builder()
                .content(specimens.map(this::toDto).getContent())
                .page(specimens.getNumber())
                .size(specimens.getSize())
                .totalElements(specimens.getTotalElements())
                .totalPages(specimens.getTotalPages())
                .last(specimens.isLast())
                .build();
    }
}
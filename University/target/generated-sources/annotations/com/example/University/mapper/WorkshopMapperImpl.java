package com.example.University.mapper;

import com.example.University.dto.WorkshopRequestDTO;
import com.example.University.dto.WorkshopResponseDTO;
import com.example.University.model.Workshop;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-22T00:24:43-0600",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.2 (Microsoft)"
)
@Component
public class WorkshopMapperImpl implements WorkshopMapper {

    @Override
    public WorkshopResponseDTO toResponseDTO(Workshop workshop) {
        if ( workshop == null ) {
            return null;
        }

        WorkshopResponseDTO workshopResponseDTO = new WorkshopResponseDTO();

        workshopResponseDTO.setId( workshop.getId() );
        workshopResponseDTO.setTitle( workshop.getTitle() );
        workshopResponseDTO.setDescription( workshop.getDescription() );
        workshopResponseDTO.setLocation( workshop.getLocation() );
        workshopResponseDTO.setStartDatetime( workshop.getStartDatetime() );
        workshopResponseDTO.setTotalSeats( workshop.getTotalSeats() );
        workshopResponseDTO.setSeatsRemaining( workshop.getSeatsRemaining() );
        workshopResponseDTO.setStatus( workshop.getStatus() );

        return workshopResponseDTO;
    }

    @Override
    public Workshop toEntity(WorkshopRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Workshop workshop = new Workshop();

        workshop.setTitle( dto.getTitle() );
        workshop.setDescription( dto.getDescription() );
        workshop.setLocation( dto.getLocation() );
        workshop.setStartDatetime( dto.getStartDatetime() );
        workshop.setTotalSeats( dto.getTotalSeats() );

        return workshop;
    }
}

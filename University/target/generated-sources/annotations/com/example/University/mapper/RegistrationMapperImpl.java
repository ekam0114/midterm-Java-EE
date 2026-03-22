package com.example.University.mapper;

import com.example.University.dto.RegistrationResponseDTO;
import com.example.University.model.Registration;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-22T00:24:42-0600",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.2 (Microsoft)"
)
@Component
public class RegistrationMapperImpl implements RegistrationMapper {

    @Override
    public RegistrationResponseDTO toResponseDTO(Registration registration) {
        if ( registration == null ) {
            return null;
        }

        RegistrationResponseDTO registrationResponseDTO = new RegistrationResponseDTO();

        registrationResponseDTO.setId( registration.getId() );
        registrationResponseDTO.setStatus( registration.getStatus() );
        registrationResponseDTO.setCreatedAt( registration.getCreatedAt() );
        registrationResponseDTO.setCancelledAt( registration.getCancelledAt() );

        return registrationResponseDTO;
    }
}

package com.example.University.mapper;


import com.example.University.dto.RegistrationResponseDTO;
import com.example.University.model.Registration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegistrationMapper {

    RegistrationResponseDTO toResponseDTO(Registration registration);
}

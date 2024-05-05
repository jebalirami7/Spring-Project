package project.server.Entities.Mappers;

import org.modelmapper.ModelMapper;

import project.server.Entities.CourseMaterial;
import project.server.Entities.DTO.CourseMaterialDto;

public class CourseMaterialMapper {
    
    private static final ModelMapper modelMapper = new ModelMapper();

    public static CourseMaterialDto convertToDto(CourseMaterial material) {
        return modelMapper.map(material, CourseMaterialDto.class);
    }

    public static CourseMaterial convertToEntity(CourseMaterialDto materialDto) {
        return modelMapper.map(materialDto, CourseMaterial.class);
    }
}

package project.server.Entities.Mappers;

import org.modelmapper.ModelMapper;

import project.server.Entities.QuizzOption;
import project.server.Entities.DTO.QuizzOptionDto;

public class QuizzOptionMapper {
    
    private static final ModelMapper modelMapper = new ModelMapper();

    public static QuizzOptionDto convertToDto(QuizzOption quizzOption) {
        return modelMapper.map(quizzOption, QuizzOptionDto.class);
    }

    public static QuizzOption convertToEntity(QuizzOptionDto quizzOptionDto) {
        return modelMapper.map(quizzOptionDto, QuizzOption.class);
    }

}

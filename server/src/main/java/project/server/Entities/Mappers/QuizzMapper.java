package project.server.Entities.Mappers;

import org.modelmapper.ModelMapper;

import project.server.Entities.Quizz;
import project.server.Entities.DTO.QuizzDto;

public class QuizzMapper {
    
    private static final ModelMapper modelMapper = new ModelMapper();

    public static QuizzDto convertToDto(Quizz quizz) {
        return modelMapper.map(quizz, QuizzDto.class);
    }

    public static Quizz convertToEntity(QuizzDto quizzDto) {
        return modelMapper.map(quizzDto, Quizz.class);
    }

}

package project.server.Entities.Mappers;

import org.modelmapper.ModelMapper;

import project.server.Entities.QuizzQuestion;
import project.server.Entities.DTO.QuizzQuestionDto;

public class QuizzQuestionMapper {
    
    private static final ModelMapper modelMapper = new ModelMapper();

    public static QuizzQuestionDto convertToDto(QuizzQuestion quizzQuestion) {
        return modelMapper.map(quizzQuestion, QuizzQuestionDto.class);
    }

    public static QuizzQuestion convertToEntity(QuizzQuestionDto quizzQuestionDto) {
        return modelMapper.map(quizzQuestionDto, QuizzQuestion.class);
    }

}

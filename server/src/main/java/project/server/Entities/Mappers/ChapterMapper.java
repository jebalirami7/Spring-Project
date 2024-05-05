package project.server.Entities.Mappers;

import org.modelmapper.ModelMapper;

import project.server.Entities.Chapter;
import project.server.Entities.DTO.ChapterDto;

public class ChapterMapper {
    
    private static final ModelMapper modelMapper = new ModelMapper();

    public static ChapterDto convertToDto(Chapter chapter) {
        return modelMapper.map(chapter, ChapterDto.class);
    }

    public static Chapter convertToEntity(ChapterDto chapterDto) {
        return modelMapper.map(chapterDto, Chapter.class);
    }
}

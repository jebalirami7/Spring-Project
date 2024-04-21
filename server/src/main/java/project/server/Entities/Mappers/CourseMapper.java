package project.server.Entities.Mappers;

import org.modelmapper.ModelMapper;

import project.server.Entities.Course;
import project.server.Entities.DTO.CourseDTO;

public class CourseMapper {
    
    private static final ModelMapper modelMapper= new ModelMapper();

    public static CourseDTO convertToDTO(Course course)
	{
	return modelMapper.map(course, CourseDTO.class);
	}

	public static Course convertToEntity(CourseDTO CourseDTO)
	{
	return modelMapper.map(CourseDTO, Course.class);	
	}

}

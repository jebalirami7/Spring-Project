package project.server.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.server.Entities.Chapter;
import project.server.Entities.Course;

public interface ChapterRepo extends JpaRepository<Chapter, Integer>{

    List<Chapter> findByCourse(Course course);
    


}

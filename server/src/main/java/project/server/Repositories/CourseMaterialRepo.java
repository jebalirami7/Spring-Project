package project.server.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.server.Entities.CourseMaterial;

public interface CourseMaterialRepo extends JpaRepository<CourseMaterial, Integer>{
    
}

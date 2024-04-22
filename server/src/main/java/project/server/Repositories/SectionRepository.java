package project.server.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.server.Entities.Section;

public interface SectionRepository extends JpaRepository<Section, Integer> {
}

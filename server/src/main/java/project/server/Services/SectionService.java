package project.server.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.server.Entities.Section;
import project.server.Repositories.SectionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    public Section getSectionById(int id) {
        Optional<Section> optionalSection = sectionRepository.findById(id);
        return optionalSection.orElse(null);
    }

    public Section addSection(Section section) {
        return sectionRepository.save(section);
    }

    public Section updateSection(int id, Section newSection) {
        Optional<Section> optionalSection = sectionRepository.findById(id);
        if (optionalSection.isPresent()) {
            Section existingSection = optionalSection.get();
            existingSection.setName(newSection.getName());
            existingSection.setNiveau(newSection.getNiveau());
            existingSection.setStudents(newSection.getStudents());
            // existingSection.setSubjects(newSection.getSubjects());
            return sectionRepository.save(existingSection);
        }
        return null;
    }

    public void deleteSection(int id) {
        sectionRepository.deleteById(id);
    }
}

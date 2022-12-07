package pairmatching.domain.repository;

import pairmatching.domain.model.Course;
import pairmatching.domain.model.Crew;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class CrewRepository {

    private final List<Crew> crews;

    public CrewRepository() throws FileNotFoundException {
        this.crews = ReadorCrewName.readCrew();
    }

    public void save(Crew crew) {
        crews.add(crew);
    }

    public Crew findByName(String name) {
        return crews.stream()
                .filter(crew -> crew.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public List<Crew> findAllByCourse(Course course) {
        return crews.stream()
                .filter(crew -> crew.isSameCourse(course))
                .collect(Collectors.toList());
    }
}

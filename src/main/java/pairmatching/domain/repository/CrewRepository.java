package pairmatching.domain.repository;

import pairmatching.domain.model.Crew;

import java.util.ArrayList;
import java.util.List;

public class CrewRepository {

    private final List<Crew> crews;

    public CrewRepository() {
        this.crews = new ArrayList<>();
    }

    public void save(Crew crew) {
        crews.add(crew);
    }

    public Crew findByName(String name) {
        return crews.stream()
                .filter(crew -> crew.isSame(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}

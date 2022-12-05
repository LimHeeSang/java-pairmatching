package pairmatching.domain.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pairmatching.domain.model.Course;
import pairmatching.domain.model.Crew;

import static org.assertj.core.api.Assertions.assertThat;

class CrewRepositoryTest {

    private CrewRepository crewRepository;

    @BeforeEach
    void setUp() {
        crewRepository = new CrewRepository();
    }

    @Test
    void 한명의_크루를_저장하고_불러온다() {
        Crew crew = new Crew("pobi", Course.BACKEND);
        crewRepository.save(crew);

        Crew findCrew = crewRepository.findByName("pobi");
        assertThat(findCrew).isEqualTo(crew);
    }
}
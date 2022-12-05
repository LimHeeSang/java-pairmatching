package pairmatching.domain.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pairmatching.domain.model.Course;
import pairmatching.domain.model.Crew;

import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CrewRepositoryTest {

    private CrewRepository crewRepository;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        crewRepository = new CrewRepository();
    }

    @Test
    void 한명의_크루를_저장하고_불러온다() {
        Crew crew = new Crew("pobi", Course.BACKEND);
        crewRepository.save(crew);

        Crew findCrew = crewRepository.findByName("pobi");
        assertThat(findCrew).isEqualTo(crew);
    }

    @ValueSource(strings = {"보노" ,"시저", "쉐리", "신디", "다비", "덴버", "이브" ,"제시",
            "라라", "린다", "리사", "니콜", "로드", "윌터", "제키", "용팔", "구식", "달재"})
    @ParameterizedTest
    void 파일에있는_크루들을_저장(String name) {
        Crew crew = crewRepository.findByName(name);
        assertThat(crew.isSameName(name)).isTrue();
    }

    @ValueSource(strings = {"FRONTEND", "BACKEND"})
    @ParameterizedTest
    void 코스별로_크루들을_조회(String name) {
        List<Crew> crews = crewRepository.findAllByCourse(Course.valueOf(name));
        for (Crew crew : crews) {
            assertThat(crew.isSameCourse(Course.valueOf(name))).isTrue();
        }
    }
}
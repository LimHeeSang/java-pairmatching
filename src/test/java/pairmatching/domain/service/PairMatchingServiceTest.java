package pairmatching.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pairmatching.domain.model.Course;
import pairmatching.domain.model.Level;
import pairmatching.domain.model.Mission;
import pairmatching.domain.repository.CrewRepository;
import pairmatching.domain.repository.PairRepository;

import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PairMatchingServiceTest {

    private PairMatchingService pairMatchingService;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        pairMatchingService = new PairMatchingService(
                new CrewRepository(),
                new PairRepository(),
                new TestShuffleStrategy());
    }

    @Test
    void 페어매칭_서비스() {
        pairMatchingService.pairMatch(Course.FRONTEND, Level.LEVEL1, Mission.LOTTO);
        List<String> pairs = pairMatchingService.getPair(Course.FRONTEND, Level.LEVEL1, Mission.LOTTO);
        assertThat(pairs).containsExactly("보노 : 시저", "쉐리 : 신디", "다비 : 덴버",
                "이브 : 제시", "라라 : 린다", "리사 : 니콜", "로드 : 윌터 : 제키");
    }

    @Test
    void 페어매칭시_레벨에_같은페어정보가_있을경우_3회재시도_넘으면_예외() {
        pairMatchingService.pairMatch(Course.FRONTEND, Level.LEVEL1, Mission.BASEBALL_GAME);
        assertThatThrownBy(() ->
                pairMatchingService.pairMatch(Course.FRONTEND, Level.LEVEL1, Mission.LOTTO))
                .isInstanceOf(IllegalStateException.class);
    }
}
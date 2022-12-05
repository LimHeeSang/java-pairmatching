package pairmatching.domain.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pairmatching.domain.model.Course;
import pairmatching.domain.model.Level;
import pairmatching.domain.model.Mission;
import pairmatching.domain.model.Pair;
import pairmatching.domain.model.PairKey;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PairRepositoryTest {

    private PairRepository pairRepository;

    @BeforeEach
    void setUp() {
        pairRepository = new PairRepository();
    }

    @Test
    void 코스별_레벨별_미션별_페어정보_저장하고_조회() {
        PairKey pairKey = new PairKey(Course.BACKEND, Level.LEVEL1, Mission.BASEBALL_GAME);
        Pair pair = new Pair("a", "b");
        Pair otherPair = new Pair("c", "d");
        List<Pair> pairs = Arrays.asList(pair, otherPair);

        pairRepository.save(pairKey, pairs);
        List<Pair> findPairs = pairRepository.findByKey(pairKey);

        assertThat(findPairs.size()).isEqualTo(findPairs.size());
        assertThat(findPairs).containsExactly(pair, otherPair);
    }
}
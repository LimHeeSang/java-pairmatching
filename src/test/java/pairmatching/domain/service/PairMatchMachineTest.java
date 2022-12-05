package pairmatching.domain.service;

import org.junit.jupiter.api.Test;
import pairmatching.domain.model.Pair;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PairMatchMachineTest {

    @Test
    void 코스별로_페어매치() {
        List<String> names = Arrays.asList("pobi", "jason", "nana", "hanbi", "jundle", "kaka");
        List<Pair> pairs = PairMatchMachine.match(names);
        assertThat(pairs.size()).isEqualTo(3);
        assertThat(pairs).containsExactly(
                new Pair("jason", "pobi"),
                new Pair("nana", "hanbi"),
                new Pair("kaka", "jundle"));
    }
}
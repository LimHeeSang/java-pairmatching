package pairmatching.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PairTest {

    @Test
    void Pair내_이름순서가_달라도_동일이름이면_equals_true() {
        Pair pair = new Pair("pobi", "jason");
        Pair pair1 = new Pair("jason", "pobi");
        Pair pair2 = new Pair("pobi", "jason");
        assertThat(pair.equals(pair1)).isTrue();
        assertThat(pair.equals(pair2)).isTrue();
    }
}
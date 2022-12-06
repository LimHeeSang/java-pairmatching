package pairmatching.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LevelTest {

    @Test
    void 레벨에_없는미션시_예외발생() {
        Level level = Level.LEVEL3;
        assertThatThrownBy(() -> level.validateMission(Mission.PAYMENT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 해당 레벨에 없는 미션입니다.");
    }
}
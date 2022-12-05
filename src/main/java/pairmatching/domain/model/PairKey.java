package pairmatching.domain.model;

import java.util.Objects;

public class PairKey {

    private final Course course;
    private final Level level;
    private final Mission mission;

    public PairKey(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairKey pairKey = (PairKey) o;
        return course == pairKey.course && level == pairKey.level && mission == pairKey.mission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }
}

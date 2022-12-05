package pairmatching.domain.service;

import java.util.List;

public class TestShuffleStrategy implements ShuffleStrategy {

    @Override
    public List<String> shuffle(List<String> names) {
        return names;
    }
}

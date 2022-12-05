package pairmatching.domain.service;

import java.util.List;

public interface ShuffleStrategy {

    List<String> shuffle(List<String> names);
}

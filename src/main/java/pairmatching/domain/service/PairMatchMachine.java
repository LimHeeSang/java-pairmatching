package pairmatching.domain.service;

import pairmatching.domain.model.Pair;

import java.util.ArrayList;
import java.util.List;

public class PairMatchMachine {

    public static List<Pair> match(List<String> names) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < names.size() - 1; i += 2) {
            pairs.add(new Pair(names.get(i), names.get(i + 1)));
        }
        return pairs;
    }
}

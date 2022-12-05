package pairmatching.domain.service;

import pairmatching.domain.model.Pair;

import java.util.ArrayList;
import java.util.List;

public class PairMatchMachine {

    public static List<Pair> match(List<String> names) {
        if (isEven(names)) {
            return createEvenPairs(names);
        }
        return createOddPairs(names);
    }

    private static boolean isEven(List<String> names) {
        return names.size() % 2 == 0;
    }

    private static List<Pair> createEvenPairs(List<String> names) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < names.size(); i += 2) {
            pairs.add(new Pair(names.get(i), names.get(i + 1)));
        }
        return pairs;
    }

    private static List<Pair> createOddPairs(List<String> names) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < names.size() - 1; i += 2) {
            pairs.add(new Pair(names.get(i), names.get(i + 1)));
        }
        pairs.add(new Pair(names.get(names.size() - 1), names.get(names.size() - 2)));
        pairs.add(new Pair(names.get(names.size() - 1), names.get(names.size() - 3)));
        return pairs;
    }
}

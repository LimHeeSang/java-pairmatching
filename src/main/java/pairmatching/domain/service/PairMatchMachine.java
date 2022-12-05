package pairmatching.domain.service;

import pairmatching.domain.model.Pair;

import java.util.ArrayList;
import java.util.List;

public class PairMatchMachine {

    public static List<Pair> match(List<String> names) {
        List<Pair> pairs = new ArrayList<>();

        if (names.size() % 2 == 0) {
            for (int i = 0; i < names.size(); i += 2) {
                pairs.add(new Pair(names.get(i), names.get(i + 1)));
            }
        }
        //0, 1, 2, 3, 4, 5, 6
        if (names.size() % 2 != 0) {
            for (int i = 0; i < names.size(); i += 2) {
                if (i == (names.size() - 1)) {
                    pairs.add(new Pair(names.get(i), names.get(i - 1)));
                    pairs.add(new Pair(names.get(i), names.get(i - 2)));
                } else {
                    pairs.add(new Pair(names.get(i), names.get(i + 1)));
                }
            }
        }
        return pairs;
    }
}

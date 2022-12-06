package pairmatching.domain.service;

import pairmatching.domain.model.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PairMatchMachine {

    public static List<Pair> match(List<String> names) {
        if (isEven(names.size())) {
            return createEvenPairs(names);
        }
        return createOddPairs(names);
    }

    private static boolean isEven(int size) {
        return size % 2 == 0;
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

    public static List<String> mapToString(List<Pair> pairs) {
        if (isEven(pairs.size())) {
            return mapToEvenString(pairs);
        }
        return mapToOddString(pairs);
    }

    private static List<String> mapToEvenString(List<Pair> pairs) {
        return pairs.stream()
                .map(Pair::toString)
                .collect(Collectors.toList());
    }

    private static List<String> mapToOddString(List<Pair> pairs) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < pairs.size() - 3; i++) {
            result.add(pairs.get(i).toString());
        }
        Pair pair = pairs.get(pairs.size() - 3);
        Pair otherPair = pairs.get(pairs.size() - 2);
        result.add(pair.toString(otherPair));
        return result;
    }

    public static boolean isDuplicate(List<Pair> pairs, List<Pair> otherPairs) {
        for (Pair pair : pairs) {
            if (otherPairs.contains(pair)) {
                return true;
            }
        }
        return false;
    }
}

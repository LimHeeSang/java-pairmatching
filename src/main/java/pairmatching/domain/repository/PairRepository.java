package pairmatching.domain.repository;

import pairmatching.domain.model.Pair;
import pairmatching.domain.model.PairKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairRepository {

    private final Map<PairKey, List<Pair>> pairs;

    public PairRepository() {
        this.pairs = new HashMap<>();
    }

    public void save(PairKey pairKey, List<Pair> pairs) {
        this.pairs.put(pairKey, pairs);
    }

    public List<Pair> findByKey(PairKey pairKey) {
        return pairs.get(pairKey);
    }
}

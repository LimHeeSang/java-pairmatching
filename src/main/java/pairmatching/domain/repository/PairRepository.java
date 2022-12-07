package pairmatching.domain.repository;

import pairmatching.domain.model.Level;
import pairmatching.domain.model.Pair;
import pairmatching.domain.model.PairKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PairRepository {

    private static final String ERROR_NOT_EXIST_MATCH_RESULT = "[ERROR] 해당 매칭 정보가 없습니다.";
    private final Map<PairKey, List<Pair>> pairs;

    public PairRepository() {
        this.pairs = new HashMap<>();
    }

    public void save(PairKey pairKey, List<Pair> pairs) {
        this.pairs.put(pairKey, pairs);
    }

    public List<Pair> findByKey(PairKey pairKey) {
        if (!existPairByKey(pairKey)) {
            throw new IllegalArgumentException(ERROR_NOT_EXIST_MATCH_RESULT);
        }
        return pairs.get(pairKey);
    }

    public List<List<Pair>> findAllByLevel(Level level) {
        List<PairKey> keys = filterEqualMissionKeys(level);
        return keys.stream()
                .map(pairs::get)
                .collect(Collectors.toList());
    }

    private List<PairKey> filterEqualMissionKeys(Level level) {
        return pairs.keySet().stream()
                .filter(pairKey -> pairKey.isEqualLevel(level))
                .collect(Collectors.toList());
    }

    public boolean existPairByKey(PairKey pairKey) {
        return pairs.containsKey(pairKey);
    }

    public void clear() {
        pairs.clear();
    }
}

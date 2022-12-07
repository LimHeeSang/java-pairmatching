package pairmatching.domain.service;

import pairmatching.domain.model.Course;
import pairmatching.domain.model.Crew;
import pairmatching.domain.model.Level;
import pairmatching.domain.model.Mission;
import pairmatching.domain.model.Pair;
import pairmatching.domain.model.PairKey;
import pairmatching.domain.repository.CrewRepository;
import pairmatching.domain.repository.PairRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PairMatchingService {

    private static final String ERROR_OVER_TRY_MESSAGE = "[ERROR] 매칭 시도가 3회를 초과했습니다.";
    private static final int CRITERION_TRY_COUNT = 3;
    private final CrewRepository crewRepository;
    private final PairRepository pairRepository;
    private final ShuffleStrategy shuffleStrategy;

    public PairMatchingService(CrewRepository crewRepository, PairRepository pairRepository, ShuffleStrategy shuffleStrategy) {
        this.crewRepository = crewRepository;
        this.pairRepository = pairRepository;
        this.shuffleStrategy = shuffleStrategy;
    }

    public boolean existMatchingResult(Course course, Level level, Mission mission) {
        level.validateMission(mission);
        return pairRepository.existPairByKey(new PairKey(course, level, mission));
    }

    public void pairMatch(Course course, Level level, Mission mission) {
        level.validateMission(mission);
        List<Crew> crews = crewRepository.findAllByCourse(course);
        List<String> crewsName = crews.stream().map(Crew::getName).collect(Collectors.toList());

        List<Pair> pairs = createPair(crewsName, level);
        pairRepository.save(new PairKey(course, level, mission), pairs);
    }

    private List<Pair> createPair(List<String> crewsName, Level level) {
        List<List<Pair>> missionPairs = pairRepository.findAllByLevel(level);
        return tryCreatePairs(crewsName, missionPairs);
    }

    private List<Pair> tryCreatePairs(List<String> crewsName, List<List<Pair>> missionPairs) {
        int count = 0;
        while (count < CRITERION_TRY_COUNT) {
            List<Pair> createPair = createShufflePairs(crewsName);
            if (!checkDuplicate(missionPairs, createPair)) {
                return createPair;
            }
            count++;
        }
        throw new IllegalStateException(ERROR_OVER_TRY_MESSAGE);
    }

    private List<Pair> createShufflePairs(List<String> crewsName) {
        return PairMatchMachine.match(shuffleStrategy.shuffle(crewsName));
    }

    private boolean checkDuplicate(List<List<Pair>> missionPairs, List<Pair> createPair) {
        for (List<Pair> missionPair : missionPairs) {
            if (PairMatchMachine.isDuplicate(createPair, missionPair)) {
                return true;
            }
        }
        return false;
    }

    public List<String> getPair(Course course, Level level, Mission mission) {
        List<Pair> pairs = pairRepository.findByKey(new PairKey(course, level, mission));
        return PairMatchMachine.mapToString(pairs);
    }

    public void initPair() {
        pairRepository.clear();
    }
}

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

    private final CrewRepository crewRepository;
    private final PairRepository pairRepository;
    private final ShuffleStrategy shuffleStrategy;

    public PairMatchingService(CrewRepository crewRepository, PairRepository pairRepository, ShuffleStrategy shuffleStrategy) {
        this.crewRepository = crewRepository;
        this.pairRepository = pairRepository;
        this.shuffleStrategy = shuffleStrategy;
    }

    public void pairMatch(Course course, Level level, Mission mission) {
        List<Crew> crews = crewRepository.findAllByCourse(course);
        List<String> crewsName = crews.stream().map(Crew::getName).collect(Collectors.toList());

        shuffleStrategy.shuffle(crewsName);
        List<Pair> pairs = PairMatchMachine.match(crewsName);

        pairRepository.save(new PairKey(course, level, mission), pairs);
    }

    public List<String> getPair(Course course, Level level, Mission mission) {
        List<Pair> pairs = pairRepository.findByKey(new PairKey(course, level, mission));
        return PairMatchMachine.mapToString(pairs);
    }
}

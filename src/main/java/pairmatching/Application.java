package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.domain.repository.CrewRepository;
import pairmatching.domain.repository.PairRepository;
import pairmatching.domain.service.PairMatchingService;
import pairmatching.domain.service.RandomShuffleStrategy;

import java.io.FileNotFoundException;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        PairMatchingController controller = new PairMatchingController(pairMatchingService());
        controller.run();
    }

    private static PairMatchingService pairMatchingService() throws FileNotFoundException {
        return new PairMatchingService(crewRepository(), pairRepository(), randomShuffleStrategy());
    }

    private static CrewRepository crewRepository() throws FileNotFoundException {
        return new CrewRepository();
    }

    private static PairRepository pairRepository() {
        return new PairRepository();
    }

    private static RandomShuffleStrategy randomShuffleStrategy() {
        return new RandomShuffleStrategy();
    }
}

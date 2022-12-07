package pairmatching.controller;

import pairmatching.domain.service.PairMatchingService;
import pairmatching.view.CourseLevelMissionDto;
import pairmatching.view.FeatureType;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import pairmatching.view.ReMatchType;

public class PairMatchingController {

    private final PairMatchingService pairMatchingService;

    public PairMatchingController(PairMatchingService pairMatchingService) {
        this.pairMatchingService = pairMatchingService;
    }

    public void run() {

        while (true) {
            FeatureType feature = InputView.inputFeature();

            if (feature.isPairMatch()) {
                CourseLevelMissionDto dto = InputView.inputCourseLevelMission();

                if (pairMatchingService.existMatchingResult(dto.getCourse(), dto.getLevel(), dto.getMission())) {
                    ReMatchType rematch = InputView.inputRematch();

                    if (rematch.isNo()) {
                        continue;
                    }
                }
                pairMatchingService.pairMatch(dto.getCourse(), dto.getLevel(), dto.getMission());
                OutputView.printPairMatchingResult(pairMatchingService.getPair(dto.getCourse(), dto.getLevel(), dto.getMission()));
            }

            if (feature.isPairGet()) {
                CourseLevelMissionDto dto = InputView.inputCourseLevelMission();
                OutputView.printPairMatchingResult(pairMatchingService.getPair(dto.getCourse(), dto.getLevel(), dto.getMission()));
            }

            if (feature.isPairInit()) {
                pairMatchingService.initPair();
            }

            if (feature.isQuit()) {
                break;
            }
        }

    }
}

package pairmatching.controller;

import pairmatching.domain.model.Course;
import pairmatching.domain.model.Level;
import pairmatching.domain.model.Mission;
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
        FeatureType feature;
        do {
            feature = InputView.inputFeature();

            if (feature.isPairMatch()) {
                operatePairMatch();
            }
            if (feature.isPairGet()) {
                operatePairGet();
            }
            if (feature.isPairInit()) {
                operatePairInit();
            }
        } while (!feature.isQuit());
    }

    private void operatePairMatch() {
        CourseLevelMissionDto dto = InputView.inputCourseLevelMission();
        if (pairMatchingService.existMatchingResult(dto.getCourse(), dto.getLevel(), dto.getMission())) {
            checkRematch(dto);
            return;
        }
        pairMatch(dto);
    }

    private void checkRematch(CourseLevelMissionDto dto) {
        ReMatchType rematch = InputView.inputRematch();
        if (rematch.isYes()) {
            pairMatch(dto);
        }
    }

    private void pairMatch(CourseLevelMissionDto dto) {
        Course course = dto.getCourse();
        Level level = dto.getLevel();
        Mission mission = dto.getMission();
        pairMatchingService.pairMatch(course, level, mission);
        OutputView.printPairMatchingResult(pairMatchingService.getPair(course, level, mission));
    }

    private void operatePairGet() {
        CourseLevelMissionDto dto = InputView.inputCourseLevelMission();
        OutputView.printPairMatchingResult(pairMatchingService.getPair(dto.getCourse(), dto.getLevel(), dto.getMission()));
    }

    private void operatePairInit() {
        pairMatchingService.initPair();
    }
}

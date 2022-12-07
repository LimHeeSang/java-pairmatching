package pairmatching.controller;

import pairmatching.domain.model.Course;
import pairmatching.domain.model.Level;
import pairmatching.domain.model.Mission;
import pairmatching.domain.service.PairMatchingService;
import pairmatching.view.CourseLevelMissionDto;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import pairmatching.view.ReMatchType;

public class PairMatchFeature implements Feature {

    @Override
    public void operate(PairMatchingService pairMatchingService) {
        CourseLevelMissionDto dto = InputView.inputCourseLevelMission();
        if (pairMatchingService.existMatchingResult(dto.getCourse(), dto.getLevel(), dto.getMission())) {
            checkRematch(pairMatchingService, dto);
            return;
        }
        pairMatch(pairMatchingService, dto);
    }

    private void checkRematch(PairMatchingService pairMatchingService, CourseLevelMissionDto dto) {
        ReMatchType rematch = InputView.inputRematch();
        if (rematch.isYes()) {
            pairMatch(pairMatchingService, dto);
        }
    }

    private void pairMatch(PairMatchingService pairMatchingService, CourseLevelMissionDto dto) {
        Course course = dto.getCourse();
        Level level = dto.getLevel();
        Mission mission = dto.getMission();
        pairMatchingService.pairMatch(course, level, mission);
        OutputView.printPairMatchingResult(pairMatchingService.getPair(course, level, mission));
    }
}

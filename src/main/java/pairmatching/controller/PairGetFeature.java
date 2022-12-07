package pairmatching.controller;

import pairmatching.domain.service.PairMatchingService;
import pairmatching.view.CourseLevelMissionDto;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairGetFeature implements Feature {

    @Override
    public void operate(PairMatchingService pairMatchingService) {
        CourseLevelMissionDto dto = InputView.inputMethod(InputView::inputCourseLevelMission);
        OutputView.printPairMatchingResult(pairMatchingService.getPair(dto.getCourse(), dto.getLevel(), dto.getMission()));
    }
}

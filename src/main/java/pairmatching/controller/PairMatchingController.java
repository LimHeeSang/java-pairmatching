package pairmatching.controller;

import pairmatching.domain.service.PairMatchingService;
import pairmatching.view.FeatureType;
import pairmatching.view.InputView;

public class PairMatchingController {

    private final PairMatchingService pairMatchingService;

    public PairMatchingController(PairMatchingService pairMatchingService) {
        this.pairMatchingService = pairMatchingService;
    }

    public void run() {
        FeatureType feature;
        do {
            feature = InputView.inputFeature();
            feature.operate(pairMatchingService);
        } while (!feature.isQuit());
    }
}

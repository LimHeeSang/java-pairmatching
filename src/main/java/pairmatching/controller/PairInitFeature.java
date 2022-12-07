package pairmatching.controller;

import pairmatching.domain.service.PairMatchingService;

public class PairInitFeature implements Feature {

    @Override
    public void operate(PairMatchingService pairMatchingService) {
        pairMatchingService.initPair();
    }
}

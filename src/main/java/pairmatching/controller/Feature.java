package pairmatching.controller;

import pairmatching.domain.service.PairMatchingService;

@FunctionalInterface
public interface Feature {

    void operate(PairMatchingService pairMatchingService);
}

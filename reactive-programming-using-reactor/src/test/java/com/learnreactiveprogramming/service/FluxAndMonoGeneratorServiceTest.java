package com.learnreactiveprogramming.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxAndMonoGeneratorServiceTest {
  FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

  @Test
  void namesFlux() {

    //when
    var namesFlux = fluxAndMonoGeneratorService.nameFlux();

    //then
    //This test fail if i inverse the order of the elements
    StepVerifier.create(namesFlux)
        //.expectNext("alex","ben","chloe")
        //.expectNextCount(3)
        .expectNext("alex")
        .expectNextCount(2)
        .verifyComplete();



  }
}
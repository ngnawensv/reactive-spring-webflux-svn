package com.learnreactiveprogramming.service;

import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxAndMonoGeneratorService {

  public Flux<String> nameFlux(){
    return Flux.fromIterable(List.of("alex","ben","chloe")).log();
  }

  public Mono<String> nameMono(){
   return Mono.just("alex").log();
  }
  public static void main(String[] args) {
    FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();
    fluxAndMonoGeneratorService.nameFlux().subscribe(name ->{
      System.out.println("Name is "+name);
    });
    fluxAndMonoGeneratorService.nameMono().subscribe(name->{
      System.out.println("Name mono is "+name);
    });
  }
}

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

  public Flux<String> nameFluxMap(){
    return Flux.fromIterable(List.of("alex","ben","chloe"))
        .map(String::toUpperCase)
        //.map(name->name.toUpperCase())
        .log();
  }

  public Flux<String> nameFluxImmutability(){
    var namesFlux= Flux.fromIterable(List.of("alex","ben","chloe"));
    namesFlux.map(String::toUpperCase);// A new flux is created
    return namesFlux;
  }

  public Flux<String> nameFluxMapFilter(int stringLength){
    //filter the string whole length is greater than
    return Flux.fromIterable(List.of("alex","ben","chloe"))
        .map(String::toUpperCase)
        .filter(s -> s.length()>stringLength)
        .map(s -> s.length()+"-"+s)
        //.map(name->name.toUpperCase())
        .log();
  }

  //flatMap() transform one source element to a Flux of 1 to N elements
  //Ex: "ALEX" -> Flux.just("A","L","E","X")
  public Flux<String> nameFluxFlatMap(int stringLength){
    //filter the string whole length is greater than
    return Flux.fromIterable(List.of("alex","ben","chloe"))
        .map(String::toUpperCase)
        .filter(s -> s.length()>stringLength)
       // .map(s -> s.length()+"-"+s)
        .flatMap(s->splitString(s))
        .log();
  }

  public Flux<String> splitString(String name){
    var charArray = name.split("");
    return Flux.fromArray(charArray);
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

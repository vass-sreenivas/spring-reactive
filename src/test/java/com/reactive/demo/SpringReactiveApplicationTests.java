package com.reactive.demo;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class SpringReactiveApplicationTests {

	@Test
	void contextLoads() {
	}
	
	
	@Test
	public void tesMono() {
		
		Mono<?> monoString=Mono.just("Iphone 12")
				                    .then(Mono.error(new RuntimeException("Got Some Exception")))
				                    .log();
		monoString.subscribe(System.out::println);
	}
	
	@Test
	public void testFlux() {
		
	  Flux<?> fluxString=Flux.just("iPhone 7","iPhone8",
			                                 "iPhone X","iPhone 11",
			                                 "iPhone 12","iPhone 13")
			                 .concatWithValues("Android").log();
	  fluxString.subscribe(System.out::println);
	}
	
	
	@Test
	public void testFluxWhenThrowsError() {
		
	  Flux<?> fluxString=Flux.just("iPhone 7","iPhone8",
			                                 "iPhone X","iPhone 11",
			                                 "iPhone 12","iPhone 13")
			                 .concatWith(Flux.error(new RuntimeException("")))
			                 .concatWithValues("Android")
			                 .log();
	  fluxString.subscribe(System.out::println,e->System.out.println("Trhows some exception"));
	}

}

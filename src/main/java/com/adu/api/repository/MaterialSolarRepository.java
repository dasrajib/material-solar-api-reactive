package com.adu.api.repository;

import com.adu.api.model.MaterialSolar;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MaterialSolarRepository extends ReactiveCrudRepository<MaterialSolar, Long> {

    Flux<MaterialSolar> findByDescription(String description);    
}

package com.adu.api.service;

import com.adu.api.model.MaterialSolar;
import com.adu.api.repository.MaterialSolarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MaterialSolarService {

    private final MaterialSolarRepository materialsolarRepository;

    public Flux<MaterialSolar> getAllMaterialSolar() {
        return materialsolarRepository.findAll();
    }

    public Mono<MaterialSolar> getMaterialSolarById(Long materialsolar_id) {
        return materialsolarRepository.findById(materialsolar_id);
    }

    public Mono<MaterialSolar> createMaterialSolar(MaterialSolar materialsolar) {
        return materialsolarRepository.save(materialsolar);
    }

    public Mono<MaterialSolar> updateMaterialSolar(Long materialsolar_id, MaterialSolar materialsolar) {
        return materialsolarRepository.findById(materialsolar_id)
                .flatMap(existingMaterialSolar -> {
                    existingMaterialSolar.setDescription(materialsolar.getDescription());
                    existingMaterialSolar.setExt_description(materialsolar.getExt_description());
                  
                    existingMaterialSolar.setPrice(materialsolar.getPrice());

                    existingMaterialSolar.setUpdated_at(LocalDateTime.now());
                
                    return materialsolarRepository.save(existingMaterialSolar);
                });
    }

    public Mono<Void> deleteMaterialSolar(Long layoutentry_id) {
        return materialsolarRepository.deleteById(layoutentry_id);
    }
}

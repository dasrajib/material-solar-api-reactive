package com.adu.api.controller;

import com.adu.api.model.MaterialSolar;
import com.adu.api.service.MaterialSolarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/materialsolar")
@RequiredArgsConstructor
@Tag(name = "materialsolar Management", description = "APIs for managing materialsolar")
public class MaterialSolarController {

    private final MaterialSolarService materialsolarService;

    @GetMapping
    @Operation(summary = "Get all materialsolar")
    public Flux<MaterialSolar> getAllMaterialSolar() {
        return materialsolarService.getAllMaterialSolar();
    }

    @GetMapping("/{materialsolar_id}")
    @Operation(summary = "Get materialsolar by ID")
    public Mono<MaterialSolar> getMaterialSolarById(@PathVariable Long  materialsolar_id) {
        return materialsolarService.getMaterialSolarById( materialsolar_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new materialsolar")
    public Mono<MaterialSolar> createMaterialSolar(@RequestBody MaterialSolar  materialsolar) {
        return materialsolarService.createMaterialSolar( materialsolar);
    }

    @PutMapping("/{materialsolar_id}")
    @Operation(summary = "Update an existing materialsolar")
    public Mono<MaterialSolar> updateMaterialSolar(@PathVariable Long  materialsolar_id, @RequestBody MaterialSolar  materialsolar) {
        return materialsolarService.updateMaterialSolar(materialsolar_id, materialsolar);
    }

    @DeleteMapping("/{materialsolar_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a materialsolar")
    public Mono<Void> deleteMaterialSolar(@PathVariable Long  materialsolar_id) {
        return materialsolarService.deleteMaterialSolar( materialsolar_id);
    }
}

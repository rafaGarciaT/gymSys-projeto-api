package com.grupo.gymSys.controller;

import com.grupo.gymSys.domain.dto.UnidadeDTO;
import com.grupo.gymSys.domain.mapper.UnidadeMapper;
import com.grupo.gymSys.domain.model.Unidade;
import com.grupo.gymSys.service.UnidadeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Tag(name = "Unidades")
@RestController
@RequestMapping("/unidades")
public class UnidadeController {
    private final UnidadeService unidadeService;
    private final UnidadeMapper unidadeMapper;


    public UnidadeController(UnidadeService unidadeService, UnidadeMapper unidadeMapper) {
        this.unidadeService = unidadeService;
        this.unidadeMapper = unidadeMapper;
    }

    @Operation(summary = "Buscar unidade")
    @GetMapping("/{id}")
    public ResponseEntity<Unidade> findById(@PathVariable Long id) {
        var unidade = unidadeService.findById(id);
        return ResponseEntity.ok(unidade);
    }

    @Operation(summary = "Cadastrar nova unidade")
    @PostMapping
    public ResponseEntity<UnidadeDTO> create(@Valid @RequestBody UnidadeDTO unidadeToCreate) {
        Unidade savedUnidade = unidadeService.create(unidadeMapper.toEntity(unidadeToCreate));


        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUnidade.getId())
                .toUri();
        return ResponseEntity.created(location).body(unidadeMapper.toDTO(savedUnidade));
    }

    @Operation(summary = "Deletar unidade")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        unidadeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Atualizar unidade existente")
    @PutMapping("/{id}")
    public ResponseEntity<UnidadeDTO> update(@PathVariable Long id, @Valid @RequestBody UnidadeDTO dto) {
        Unidade updated = unidadeService.update(id, unidadeMapper.toEntity(dto));
        return ResponseEntity.ok(unidadeMapper.toDTO(updated));
    }
}




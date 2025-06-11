package com.grupo.gymSys.controller;


import com.grupo.gymSys.domain.dto.AparelhoDTO;
import com.grupo.gymSys.domain.mapper.AparelhoMapper;
import com.grupo.gymSys.service.AparelhoService;
import com.grupo.gymSys.domain.model.Aparelho;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;

@Tag(name="Aparelhos")
@RestController
@RequestMapping("/aparelhos")
public class AparelhoController {

    private final AparelhoService aparelhoService;
    private final AparelhoMapper aparelhoMapper;


    public AparelhoController(AparelhoService aparelhoService, AparelhoMapper aparelhoMapper) {
        this.aparelhoService = aparelhoService;
        this.aparelhoMapper = aparelhoMapper;
    }

    @Operation(summary = "Buscar aparelho")
    @GetMapping("/{id}")
    public ResponseEntity<Aparelho> findById(@PathVariable Long id) {
        var aparelho = aparelhoService.findById(id);
        return ResponseEntity.ok(aparelho);
    }

    @Operation(summary = "Cadastrar novo Aparelho")
    @PostMapping
    public ResponseEntity<AparelhoDTO> create(@Valid @RequestBody AparelhoDTO aparelhoToCreate) {
        Aparelho savedAparelho = aparelhoService.create(aparelhoMapper.toEntity(aparelhoToCreate));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedAparelho.getId())
                .toUri();
        return ResponseEntity.created(location).body(aparelhoMapper.toDTO(savedAparelho));
    }

    @Operation(summary = "Deletar Aparelho existente")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        aparelhoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Atualizar aparelho existente")
    @PutMapping("/{id}")
    public ResponseEntity<AparelhoDTO> update(@PathVariable Long id, @Valid @RequestBody AparelhoDTO dto) {
        Aparelho updated = aparelhoService.update(id, aparelhoMapper.toEntity(dto));
        return ResponseEntity.ok(aparelhoMapper.toDTO(updated));
    }
}

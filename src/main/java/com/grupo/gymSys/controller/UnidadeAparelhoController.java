package com.grupo.gymSys.controller;

import com.grupo.gymSys.domain.dto.UnidadeAparelhoDTO;
import com.grupo.gymSys.domain.mapper.UnidadeAparelhoMapper;
import com.grupo.gymSys.domain.model.UnidadeAparelho;
import com.grupo.gymSys.service.UnidadeAparelhoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;



@Tag(name="Unidade-Aparelhos")
@RestController
@RequestMapping("/unidade-aparelhos")
public class UnidadeAparelhoController {

    private final UnidadeAparelhoService service;
    private final UnidadeAparelhoMapper mapper;

    public UnidadeAparelhoController(UnidadeAparelhoService service, UnidadeAparelhoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
    @Operation(summary = "Associar um aparelho com uma unidade")
    @PostMapping
    public ResponseEntity<Void> associate(@Valid @RequestBody UnidadeAparelhoDTO dto) {
        UnidadeAparelho created = service.createOrUpdate(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @Operation(summary = "Listar aparelhos por unidade")
    @GetMapping("/unidade/{id}")
    public ResponseEntity<List<UnidadeAparelhoDTO>> listByUnidade(@PathVariable Long id) {
        List<UnidadeAparelho> entities = service.listByUnidade(id);
        List<UnidadeAparelhoDTO> dtos = entities.stream()
                .map(mapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @Operation(summary = "Buscar associações")
    @GetMapping("/{id}")
    public ResponseEntity<UnidadeAparelhoDTO> getById(@PathVariable Long id) {
        UnidadeAparelho entity = service.findById(id);
        return ResponseEntity.ok(mapper.toDTO(entity));
    }
    @Operation(summary = "Deletar associações")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

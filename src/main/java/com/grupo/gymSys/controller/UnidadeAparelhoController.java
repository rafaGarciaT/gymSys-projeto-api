package com.grupo.gymSys.controller;

import com.grupo.gymSys.domain.dto.UnidadeAparelhoDTO;
import com.grupo.gymSys.domain.mapper.UnidadeAparelhoMapper;
import com.grupo.gymSys.domain.model.UnidadeAparelho;
import com.grupo.gymSys.service.UnidadeAparelhoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidade-aparelhos")
public class UnidadeAparelhoController {

    private final UnidadeAparelhoService service;
    private final UnidadeAparelhoMapper mapper;

    public UnidadeAparelhoController(UnidadeAparelhoService service, UnidadeAparelhoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<Void> associate(@Valid @RequestBody UnidadeAparelhoDTO dto) {
        UnidadeAparelho created = service.createOrUpdate(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/unidade/{id}")
    public ResponseEntity<List<UnidadeAparelhoDTO>> listByUnidade(@PathVariable Long id) {
        List<UnidadeAparelho> entities = service.listByUnidade(id);
        List<UnidadeAparelhoDTO> dtos = entities.stream()
                .map(mapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtos);
    }
}

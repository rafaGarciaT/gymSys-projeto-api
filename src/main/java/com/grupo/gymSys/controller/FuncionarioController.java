package com.grupo.gymSys.controller;


import com.grupo.gymSys.domain.dto.FuncionarioDTO;
import com.grupo.gymSys.domain.mapper.FuncionarioMapper;
import com.grupo.gymSys.domain.model.Funcionario;
import com.grupo.gymSys.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {


    private final FuncionarioService funcionarioService;
    private final FuncionarioMapper funcionarioMapper;


    public FuncionarioController(FuncionarioService funcionarioService, FuncionarioMapper funcionarioMapper) {
        this.funcionarioService = funcionarioService;
        this.funcionarioMapper = funcionarioMapper;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Long id) {
        var funcionario = funcionarioService.findById(id);
        return ResponseEntity.ok(funcionario);
    }


    @PostMapping
    public ResponseEntity<FuncionarioDTO> create(@Valid @RequestBody FuncionarioDTO funcionarioToCreate) {
        Funcionario savedFuncionario = funcionarioService.create(funcionarioMapper.toEntity(funcionarioToCreate));


        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedFuncionario.getId())
                .toUri();
        return ResponseEntity.created(location).body(funcionarioMapper.toDTO(savedFuncionario));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        funcionarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> update(@PathVariable Long id, @Valid @RequestBody FuncionarioDTO dto) {
        Funcionario updated = funcionarioService.update(id, funcionarioMapper.toEntity(dto));
        return ResponseEntity.ok(funcionarioMapper.toDTO(updated));
    }
}

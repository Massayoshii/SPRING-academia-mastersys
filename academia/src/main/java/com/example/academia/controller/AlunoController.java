package com.example.academia.controller;

import com.example.academia.dto.AlunoFiltroRequest;
import com.example.academia.dto.AlunoRequest;
import com.example.academia.dto.AlunoResponse;
import com.example.academia.service.AlunoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
@AllArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoResponse cadastrar(@RequestBody @Valid AlunoRequest alunoRequest){
        return alunoService.cadastrar(alunoRequest);
    }

    @GetMapping
    public Page<AlunoResponse> listar(AlunoFiltroRequest filtro ,Pageable pageable){
        return alunoService.listar(filtro , pageable);
    }

    @GetMapping("/{id}")
    public AlunoResponse buscarPorId(@PathVariable   Long id){
        return alunoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public AlunoResponse atualizar(@PathVariable Long id , @RequestBody @Valid AlunoRequest alunoRequest){
        return alunoService.atualizar(id,alunoRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        alunoService.excluir(id);
    }

}

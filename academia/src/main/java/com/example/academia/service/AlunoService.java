package com.example.academia.service;

import com.example.academia.dto.AlunoRequest;
import com.example.academia.dto.AlunoResponse;
import com.example.academia.entity.Aluno;
import com.example.academia.exceptions.AlunoNaoEncontradoException;
import com.example.academia.exceptions.EmailJaCadastradoException;
import com.example.academia.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlunoService {

    public final AlunoRepository alunoRepository;

    public AlunoResponse cadastrar(AlunoRequest request){
        if (request.email() != null && alunoRepository.existsByEmail(request.email())){
            throw new EmailJaCadastradoException();
        }
        Aluno aluno = request.toEntity();
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return AlunoResponse.fromEntity(alunoSalvo);
    }

    public Page<AlunoResponse> listar(Pageable pageable){
        return alunoRepository.findAll(pageable).map(AlunoResponse::fromEntity);
    }
    public AlunoResponse buscarPorId(Long id){
        Aluno aluno = buscarEntidadePorId(id);
        return AlunoResponse.fromEntity(aluno);
    }

    public AlunoResponse atualizar(Long id , AlunoRequest request){
        Aluno aluno = buscarEntidadePorId(id);
        request.preencher(aluno);
        Aluno alunoAtualizado = alunoRepository.save(aluno);
        return AlunoResponse.fromEntity(alunoAtualizado);
    }

    public void excluir(Long id ){
        Aluno aluno = buscarEntidadePorId(id);
        alunoRepository.delete(aluno);
    }

    private Aluno buscarEntidadePorId(Long id){
        return alunoRepository.findById(id).orElseThrow(() -> new AlunoNaoEncontradoException(id));
    }
}

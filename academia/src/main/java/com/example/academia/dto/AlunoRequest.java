package com.example.academia.dto;

import com.example.academia.entity.Aluno;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlunoRequest(
        @NotBlank(message = "O nome é obrigatorio")
        @Size(max = 150 , message = "O nome deve ter o maximo de 150 caracteres.")
        String nome,

        @Past(message = "A data de nascimento deve ser no passado.")
        LocalDate data_nascimento,

        @Size(max = 1, message = "O sexo deve ser representado por um único caractere.")
        String sexo,

        @Size(max = 30 , message = "O telefone deve ter o maximo de 30 caracteres.")
        String telefone,

        String celular,

        @Email(message = "E-mail invalido.")
        @Size(max = 150 , message = "O email deve ter o maximo de 150 caracteres.")
        String email,

        String observacao,

        @Size(max = 150 , message = "O endereco deve ter o maximo de 150 caracteres.")
        String endereco,

        @Size(max = 100 , message = "O numero deve ter o maximo de 100 caracteres.")
        String numero,

        @Size(max = 100 ,message = "O complemento deve ter o maximo de 100 caracteres.")
        String complemento,

        @Size(max = 100 , message = "O bairro deve ter o maximo de 100 caracteres.")
        String bairro,

        @Size(max = 100 , message = "O cidade deve ter o maximo de 100 caracteres.")
        String cidade,
        @Size(max = 2 , message = "O estado deve ter o maximo de 2 caracteres.")
        String estado,
        @Size(max = 20 , message = "O CEP deve ter o maximo de 20 caracteres.")
        String cep
) {
    public Aluno toEntity(){
        Aluno aluno = new Aluno();
        preencher(aluno);
        return aluno;
    }

    public void preencher(Aluno aluno){
        aluno.setNome(nome);
        aluno.setDataNascimento(data_nascimento);
        aluno.setSexo(sexo);
        aluno.setTelefone(telefone);
        aluno.setCelular(celular);
        aluno.setEmail(email);
        aluno.setObservacao(observacao);
        aluno.setEndereco(endereco);
        aluno.setNumero(numero);
        aluno.setComplemento(complemento);
        aluno.setBairro(bairro);
        aluno.setCidade(cidade);
        aluno.setEstado(estado);
        aluno.setCep(cep);
    }

}
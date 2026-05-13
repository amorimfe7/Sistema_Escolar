package model;

import java.time.LocalDate;

public class Aluno {
    private String nome;
    private String cpf;
    private String email;
    private LocalDate data_nascimento;
    private String telefone;

    int id;

    //construtor p/ CRIAR um novo Aluno

    //construtor p/ LEITURA dos dados de Aluno
    public Aluno(int id, String nome, String cpf, String email, LocalDate data_nascimento, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
    }
    public Aluno(String nome, String cpf, String email, LocalDate data_Nascimento, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.data_nascimento = data_Nascimento;
        this.telefone = telefone;
    }

    public Aluno(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    };

    @Override
    public String toString(){
        return String.format("Aluno: id=%d | Nome = %s | CPF = %s | Email = %s | DataNascimento = %s | Telefone = %s", id, nome, cpf, email, data_nascimento,telefone);
    }

    public void setId(int id) {
        this.id = id;
    }
}

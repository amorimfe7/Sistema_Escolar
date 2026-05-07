package model;

import sun.util.resources.LocaleData;

public class Aluno {
    private String nome;
    private String cpf;
    private String email;
    private LocaleData data_nascimento;
    private String telefone;

    int id;

    //construtor p/ CRIAR um novo Aluno
    public Aluno(String cpf, String nome, String telefone, LocaleData data_nascimento, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.data_nascimento = data_nascimento;
        this.email = email;
    }

    //construtor p/ LEITURA dos dados de Aluno
    public Aluno(int id, String telefone, LocaleData data_nascimento, String email, String cpf, String nome) {
        this.id = id;
        this.telefone = telefone;
        this.data_nascimento = data_nascimento;
        this.email = email;
        this.cpf = cpf;
        this.nome = nome;
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

    public LocaleData getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocaleData data_nascimento) {
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
}

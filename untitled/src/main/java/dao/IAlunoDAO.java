package dao;

import model.Aluno;

import java.util.List;

public interface IAlunoDAO {

    //C
    void criar(Aluno aluno);

    //R
    List<Aluno> listarTodosAlunos();

    //U
    void atualizarAluno(Aluno aluno);

    //D
    void deletarAluno(int id);

    void salvarAluno(Aluno aluno);

    Aluno listarAlunoId(int id);
}

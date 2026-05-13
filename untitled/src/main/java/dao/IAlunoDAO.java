package dao;

import model.Aluno;

import java.util.List;
import java.util.Optional;

public interface IAlunoDAO {

    //C
    void salvarAluno(Aluno aluno);

    //R
    List<Aluno> listarTodosAlunos();
    Optional<Aluno> buscarPorId(int id);

    //U
    void atualizarAluno(Aluno aluno);

    //D
    void deletarAluno(int id);

}

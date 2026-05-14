package dao;

import model.Aluno;
import model.Turma;

import java.util.List;

public interface ITurmaDao {
    List<Turma> listarTodasTurmas();

    List<Aluno> listarAlunosPorTurmaId(int id);



}

package daoImplements;

import dao.IAlunoDAO;
import database.sqlConn;
import model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOImplements implements IAlunoDAO {

    @Override
    public void salvarAluno(Aluno aluno){}

    @Override
    public void criar(Aluno aluno) {
    }

    @Override
    public List<Aluno> listarTodosAlunos() {
        String sql = "SELECT * FROM aluno ORDER BY nome ASC";
        List<Aluno> alunos = new ArrayList<>();

        try(Connection conn = sqlConn.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                alunos.add(new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("telefone")
                ));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return alunos;
    };

    @Override
    public void atualizarAluno(Aluno aluno) {

    }

    @Override
    public void deletarAluno(int id) {

    }

    @Override
    public Aluno listarAlunoId(int id) {
        String sql = ("SELECT * FROM aluno WHERE id = ?");
        Aluno alunoId = null;
        try (Connection conn = sqlConn.getConnection()) {
            //Statement = prepara a consulta no SQL para ser executada
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            //`execute.Query()` executa o SELECT | rs = guarda o resultado/retorno da consulta
            ResultSet rs = stmt.executeQuery();

            //enquanto existir linhas no resultado, continue lendo
            if (rs.next()) {
                alunoId = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("telefone")
                );
            };

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return alunoId;
    }

}

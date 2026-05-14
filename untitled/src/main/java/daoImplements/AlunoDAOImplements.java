package daoImplements;

import dao.IAlunoDAO;
import database.sqlConn;
import model.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlunoDAOImplements implements IAlunoDAO {

    @Override
    public void salvarAluno(Aluno aluno){
        String sql = "INSERT INTO aluno (nome, cpf, email, data_nascimento, telefone)" +
                "VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = sqlConn.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //Pegando o ID do próximo aluno a ser cadastrado (o do próprio aluno a ser cadastrado)

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getEmail());
            stmt.setDate(4, Date.valueOf(aluno.getData_nascimento()));
            stmt.setString(5, aluno.getTelefone());

            stmt.executeUpdate();

            ResultSet chavePk = stmt.getGeneratedKeys();

            if(chavePk.next()){
                aluno.setId(chavePk.getInt(1));
            }

            System.out.println("Aluno cadastrado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar Aluno" + e.getMessage());
        }
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
        String sql = "UPDATE aluno SET nome = ?, email = ?, telefone = ? WHERE id = ?";

        try (Connection conn = sqlConn.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getTelefone());
            stmt.setInt(4, aluno.getId());

            stmt.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deletarAluno(int id) {
        String sql = "DELETE FROM aluno WHERE id = ?";

        try(Connection conn = sqlConn.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Aluno excluído com sucesso");
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

        //sql
        //conexao conn
        //preparar
        //if
        //execute
    }

    @Override
    public Optional<Aluno> buscarPorId(int id) {
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
        return Optional.ofNullable(alunoId);
    }

}

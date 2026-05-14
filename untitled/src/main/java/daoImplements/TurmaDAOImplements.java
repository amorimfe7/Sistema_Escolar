package daoImplements;

import dao.ITurmaDao;
import database.sqlConn;
import model.Aluno;
import model.Turma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAOImplements implements ITurmaDao {
    @Override
    public List<Turma> listarTodasTurmas() {
        String sql = "SELECT * FROM turma ORDER BY turno DESC, nome ASC";
        List<Turma> listaTurmas = new ArrayList<>();

        try(Connection conn = sqlConn.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) { //leia todas as linhas q retornaram, dps de ler tudo, crie um novo objetivo do tipo Turma e adicione na lista
                listaTurmas.add(new Turma(
                        rs.getInt("id"),
                        rs.getInt("instituicao_id"),
                        rs.getInt("professor_id"),
                        rs.getString("nome"),
                        rs.getInt("ano_letivo"),
                        rs.getString("turno"),
                        rs.getInt("vagas")
                ));
            }
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

        return listaTurmas;
    }

    @Override
    public List<Aluno> listarAlunosPorTurmaId(int id) {
        String sql = "SELECT a.* FROM matricula m INNER JOIN aluno a ON m.aluno_id = a.id WHERE m.turma_id = ? ";

        List<Aluno> alunosTurma = new ArrayList<>();

        try(Connection conn = sqlConn.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                alunosTurma.add(new Aluno (
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("telefone")
                ));
            }

        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());

        }

        return alunosTurma;
    }
}

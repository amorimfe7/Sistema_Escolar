package org.example;

import daoImplements.AlunoDAOImplements;
import database.sqlConn;
import model.Aluno;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        sqlConn.testConnection();

        AlunoDAOImplements alunoDaoMetodos = new AlunoDAOImplements();
        Scanner sc = new Scanner(System.in);

        int opção;

        do{
            System.out.println("===== MENU ======");
            System.out.println("1. Cadastar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Atualizar Alunos");
            System.out.println("4. Excluir Aluno");
            System.out.println("0. Fechar programa");

            opção = sc.nextInt();

            switch (opção){
                case 1:
                    System.out.println("--- Cadastrar Alunos ---");

                    System.out.println("Nome: ");
                    String nome = sc.next();
                    System.out.println("CPF");
                    String cpf = sc.next();
                    System.out.println("Email:");
                    String email = sc.next();
                    System.out.println("Data de Nascimento");
                    LocalDate dataNascimento;
                    try{
                        dataNascimento = LocalDate.parse(sc.next());
                    } catch (Exception e ){
                        throw new RuntimeException("Erro de data. Tente: aaaa-mm-dd");
                    }
                    System.out.println("Telefone: ");
                    String telefone= sc.next();

                    Aluno alunoNovo = new Aluno(nome, cpf, email, dataNascimento, telefone);
                    alunoDaoMetodos.salvarAluno(alunoNovo);
                    break;

                case 2:
                    System.out.println("--- Listar Alunos ---");
                    List<Aluno> todosAlunos = alunoDaoMetodos.listarTodosAlunos();

                    if(todosAlunos.isEmpty()){
                        System.out.println("Nenhum aluno encontrado");
                    } else {
                        for(Aluno aluno : todosAlunos){
                            System.out.println(aluno);
                        }
                    }
                    break;

                case 3:

                    System.out.println("--- Atualizar Alunos ---");

                    for(Aluno aluno : alunoDaoMetodos.listarTodosAlunos()){
                        System.out.println(alunoDaoMetodos.listarTodosAlunos());
                    }

                    System.out.println("Insira o ID do aluno a ser atualizado: ");
                    int idAtualizar = sc.nextInt();

                    if(alunoDaoMetodos.buscarPorId(idAtualizar).isPresent()){
                        System.out.println("Novo nome: ");
                        String nomeNovo = sc.nextLine();
                        System.out.println("Novo email:");
                        String emailNovo = sc.nextLine();

                    }
                    ;

                    break;

                case 4:
                    System.out.println("--- Deletar Alunos ---\n");

                    for(Aluno aluno : alunoDaoMetodos.listarTodosAlunos()){
                        alunoDaoMetodos.listarTodosAlunos();
                    };

                    System.out.println("Digite o ID do aluno a ser excluído: ");
                    int idExcluir = sc.nextInt();

                    alunoDaoMetodos.deletarAluno(idExcluir);
                    break;

                case 5:
                    System.out.println("--- Pesquisar Aluno por ID ---\n");
                    System.out.println("Insira o ID do Aluno a ser localizado: ");
                    int idSelecionado = sc.nextInt();

                    alunoDaoMetodos.buscarPorId(idSelecionado);
                    break;

                case 0:
                    System.out.println("--- Fechando o programa.. ---");
                    opção = 0;
                    break;
            }

        } while(opção != 0);

    }
}

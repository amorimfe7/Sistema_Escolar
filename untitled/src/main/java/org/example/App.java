package org.example;

import daoImplements.AlunoDAOImplements;
import database.sqlConn;
import model.Aluno;

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
                    //alunoDaoMetodos.salvarAluno();
                    System.out.println("--- Cadastrar Alunos ---");

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
                    break;

                case 4:
                    System.out.println("--- Deletar Alunos ---");
                    break;
                case 5:
                    System.out.println("--- Pesquisar Aluno por ID ---\n");
                    System.out.println("Insira o ID do Aluno a ser localizado: ");
                    int idSelecionado = sc.nextInt();

                    alunoDaoMetodos.listarAlunoId(idSelecionado);
                    break;
                case 0:
                    System.out.println("--- Fechando o programa.. ---");
                    opção = 1;
                    break;
            }

        } while(opção != 0);

    }
}

package com.mycompany.universidade;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) throws SQLException {
        String menu = "1-Cadastrar\n 2-Atualizar\n 3-Apagar\n 4-Listar\n 0-sair";
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcao) {
                case 1:
                    int ra_aluno = Integer.parseInt(JOptionPane.showInputDialog("Digite seu ra"));
                    String telefone_aluno = JOptionPane.showInputDialog("Digite seu telefone");
                    String nome_aluno = JOptionPane.showInputDialog("Digite seu nome");
                    int id_aluno;
                    Aluno aluno =  new Aluno();
                    aluno.setRa_aluno(ra_aluno);
                    aluno.setTelefone_aluno(telefone_aluno);
                    aluno.setNome_aluno(nome_aluno);
                    aluno.inserir();
                    break;
                case 2:
                    ra_aluno = Integer.parseInt(JOptionPane.showInputDialog("Digite seu ra"));
                    telefone_aluno = JOptionPane.showInputDialog("Digite seu telefone");
                    nome_aluno = JOptionPane.showInputDialog("Digite seu nome");
                    id_aluno = Integer.parseInt(JOptionPane.showInputDialog("Digite seu id"));
                    Aluno aluno1 =  new Aluno();
                    aluno1.setRa_aluno(ra_aluno);
                    aluno1.setTelefone_aluno(telefone_aluno);
                    aluno1.setNome_aluno(nome_aluno);
                    aluno1.setId_aluno(id_aluno);
                    aluno1.atualizar();
                    break;
                case 3:
                   id_aluno = Integer.parseInt(JOptionPane.showInputDialog("Digite seu id"));
                    Aluno aluno2 =  new Aluno();
                    aluno2.setId_aluno(id_aluno);
                    aluno2.deletar();
                    break;
                case 4:
                    Aluno aluno3 =  new Aluno();
                    aluno3.listar();
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        } while (opcao != 0);
    }

}
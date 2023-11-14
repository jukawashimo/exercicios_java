package com.mycompany.universidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.lang.Integer;

public class Aluno {
    
   private int id_aluno;
   private String nome_aluno;
   private int ra_aluno;
   private String telefone_aluno;
   
   public void inserir() throws SQLException{
       // Comando Sql a ser executado
       String sql = "INSERT INTO aluno(ra_aluno, telefone_aluno, nome_aluno) values(?,?,?)";
       
       // Abrir uma conexão
       ConnectionFactory factory = new ConnectionFactory();
       try(Connection con = factory.obtemConexao()){
           
           // Preparar o comando SQL
           PreparedStatement ps = con.prepareStatement(sql);
           
           ps.setInt(1, getRa_aluno());
           ps.setString(2, getTelefone_aluno());
           ps.setString(3, getNome_aluno());
           
           ps.execute();
           
       }catch(SQLException ex){
           ex.printStackTrace();
       }
   }
   
      public void atualizar() throws SQLException{
       // Comando Sql a ser executado
       String sql = "UPDATE aluno SET ra_aluno = ?, telefone_aluno = ?, nome_aluno = ? WHERE id_aluno = ?";
       
       // Abrir uma conexão
       ConnectionFactory factory = new ConnectionFactory();
       try(Connection con = factory.obtemConexao()){
           
           // Preparar o comando SQL
           PreparedStatement ps = con.prepareStatement(sql);
           
           ps.setInt(1, getRa_aluno());
           ps.setString(2, getTelefone_aluno());
           ps.setString(3, getNome_aluno());
           ps.setInt(4, getId_aluno());
           ps.execute();
           
       }catch(SQLException ex){
           ex.printStackTrace();
       }
   }
      
      public void deletar() throws SQLException{
       // Comando Sql a ser executado
       String sql = "DELETE FROM aluno WHERE id_aluno = ?";
       
       // Abrir uma conexão
       ConnectionFactory factory = new ConnectionFactory();
       try(Connection con = factory.obtemConexao()){
           
           // Preparar o comando SQL
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, getId_aluno());
           ps.execute();
           
       }catch(SQLException ex){
           ex.printStackTrace();
       }
   }
      
      public void listar() throws SQLException{
        String sql = "SELECT * FROM aluno";
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()){
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                id_aluno = rs.getInt("id_aluno");
                ra_aluno = rs.getInt("ra_aluno");
                telefone_aluno = rs.getString("telefone_aluno");
                nome_aluno = rs.getString("nome_aluno");
                String aux = String.format(" id: %d \n ra: %d \n telefone: %s \n nome: %s",
                        id_aluno,ra_aluno,telefone_aluno,nome_aluno);
                //JOptionPane.showMessageDialog(null, aux);
                JOptionPane.showMessageDialog(null, aux);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @return the id_aluno
     */
    public int getId_aluno() {
        return id_aluno;
    }

    /**
     * @param id_aluno the id_aluno to set
     */
    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    /**
     * @return the nome_aluno
     */
    public String getNome_aluno() {
        return nome_aluno;
    }

    /**
     * @param nome_aluno the nome_aluno to set
     */
    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    /**
     * @return the ra_aluno
     */
    public int getRa_aluno() {
        return ra_aluno;
    }

    /**
     * @param ra_aluno the ra_aluno to set
     */
    public void setRa_aluno(int ra_aluno) {
        this.ra_aluno = ra_aluno;
    }

    /**
     * @return the telefone_aluno
     */
    public String getTelefone_aluno() {
        return telefone_aluno;
    }

    /**
     * @param telefone_aluno the telefone_aluno to set
     */
    public void setTelefone_aluno(String telefone_aluno) {
        this.telefone_aluno = telefone_aluno;
    }
}
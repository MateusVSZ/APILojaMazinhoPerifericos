/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vsz.br.apimazinhoperifericos.dao;

import com.vsz.br.apimazinhoperifericos.model.Produto;
import com.vsz.br.apiperifericos.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateus
 */
public class ProdutoDAO {

    private static final String SQL_INSERT = "INSERT INTO produto(nome, tipo, preco, qtd)"
            + "VALUES(?, ?, ?, ?)";

    //CRUD
    
    //SELECT ALL
    private static final String SQL_SELECT_ALL = "SELECT * FROM produto";
    private static final String SQL_SELECT_ID = "SELECT * FROM produto"
            + "WHERE id_produto = ?";
    //UPDATE
    private static final String SQL_UPDATE = "UPDATE produto SET tipo = ?,"
            + "qtd = ?"
            + "WHERE id_produto = ?";

    //DELETE
    private static final String SQL_DELETE = "DELETE produto WHERE id_produto = ?";

    public void create(Produto p) throws SQLException, ClassNotFoundException {
        Connection conn = Conexao.conectar(); //CONEXÃO COM O BANCO DE DADOS LA DA CLASSE CONEXAO
        PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);// AQUI conn. É A CONEXAO DO BANCO. E O METODO Prepared é pra fazer o CRUD DO SQL. EXECUTA(SQL_INSERT)
        try {
            //AQUI ELE VAI DEFINIR O PARAMETRO(?, ?, ? ,?) COMO STRING OBTIDA PELO getNome()
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getTipo());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getQtd());

            //EXECUTA O STATEMENT
            stmt.executeUpdate();

            //CASO DE ERRO ELE MOSTRA NO OUTPUT, CONSOLE
        } catch (SQLException e) {
            e.printStackTrace();

            //AQUI ELE ENCERRA O PROCESSO DE CONEXAO SE DER ERRO
        } finally {
            conn.close();
        }

    }

    //AQUI PARTI PRA PASSAR DO SQL PRA OBJETO PQ ELA PRECISA SAIR DO BANCO VIRAR OBJETO PRA DEPOIS TRASNFORMAR EM REQUISIÇÃO
    //PEGO A CLASSE <Produto> e LISTO ELA USANDO O MÉTODO findAll() para depois levar ate o SERVICE
    
    public List<Produto> findAll() throws ClassNotFoundException, SQLException {
        System.out.println("entrou no findAll");
        //MÉTODO CONTEM A CONEXAO DO BANCO
        Connection conn = Conexao.conectar();
         System.out.println("conectado com o banco sucesso");
        Produto p = null;
        PreparedStatement stmt = null; //AQUI O CRUD DO SQL, DEFINI COMO NULL PQ PREPAREDSTMT NÃO POSSUI NENHUM VALOR AINDA NO MÉTODO FINDALL, ELE VAI RECEBER...
        ResultSet rs = null; //RESULTSET É UMA CLASSE DA API JDBC QUE ARMAZENA E REPETE UMA AÇÃO QUE SERIA NEXT() ELE PROCESSA O REGISTRO DO BANCO ATÉ QUE SEJA FALSE
        
        List<Produto> listaProdutos = new ArrayList<>(); //AQUI ESTOU INSTANCIANDO UM OBJETO litaProdutos e ela recebe uma lista

        try {
            stmt = conn.prepareStatement(SQL_SELECT_ALL);//FAZ A CONEXÃO
            rs = stmt.executeQuery(); //EXECUTA A CONSULTA CRUD DO PREPARED STMT E  O RESULT RS QUE ARMAZENA E VARRE
            //carrega os dados do ResultSet rs, converte em produto e
            //adiciona na lista de retorno
            
            //FACA ISSO ATE QUE SE TORNE FALSE, METODO(RS.NEXT()) DA CLASSE RESULTSET
            while (rs.next()) {
                p = new Produto();
                p.setId(rs.getLong("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setTipo(rs.getString("tipo"));
                p.setPreco(rs.getDouble("preco"));
                p.setQtd(rs.getInt("qtd"));
                listaProdutos.add(p);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaProdutos; //VAI RETORNAR listProdutos COM TODOS OS VALORES NO MÉTODO findAll();

    }
}

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
        Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
        try {
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getTipo());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getQtd());

            //EXECUTA O STATEMENT
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.close();
        }

    }

    public List<Produto> findAll() throws ClassNotFoundException, SQLException {
        Connection conn = Conexao.conectar();
        Produto p = null;
        PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
        ResultSet rs = null;
        List<Produto> listaProdutos = new ArrayList<>();
        return listaProdutos;
        try {
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            
            

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vsz.br.apiperifericos.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mateus
 */
public class Conexao {

    private static final String url = "jdbc:mysql://localhost:3306/mazinhoperifericos";
    private static final String usuario = "root";
    private static final String senha = "1234";
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    //CONEXAO
    public static Connection conectar() throws ClassNotFoundException {

        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, usuario, senha);
        
            
            
        } catch (SQLException e){
            throw new RuntimeException("Erro ao conectar com o banco" + e.getMessage());
       
        }
    }

}

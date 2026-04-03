/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.vsz.br.apimazinhoperifericos;

import com.vsz.br.apiperifericos.util.Conexao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Mateus
 */
public class ApiPerifericos {

    public static void main(String[] args) throws ClassNotFoundException {
   try (Connection conn = Conexao.conectar()) {
        System.out.println("Conectou com sucesso!");
    } catch (SQLException e) {
        System.out.println("Erro na conexão:");
        e.printStackTrace();
    }
    }
}

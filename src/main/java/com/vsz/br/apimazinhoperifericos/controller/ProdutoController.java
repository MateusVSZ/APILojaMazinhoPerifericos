/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vsz.br.apimazinhoperifericos.controller;

import com.vsz.br.apimazinhoperifericos.model.Produto;
import com.vsz.br.apimazinhoperifericos.service.ProdutoService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mateus
 */

@WebServlet("/produtos")
public class ProdutoController extends HttpServlet {

    private ProdutoService produtoService;

    @Override
    public void init() {
        produtoService = new ProdutoService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();

        out.println("API funcionando");

        try {
            out.println("Antes do findAll");

            List<Produto> produtos = produtoService.findAll();

            out.println("Depois do findAll");
            out.println("Quantidade de produtos: " + produtos.size());

            for (Produto p : produtos) {
                out.println(
                        "ID: " + p.getId()
                        + " | Nome: " + p.getNome()
                        + " | Tipo: " + p.getTipo()
                        + " | Preço: " + p.getPreco()
                        + " | Quantidade: " + p.getQtd()
                );
            }

        } catch (SQLException ex) {
            out.println("Erro SQL: " + ex.getMessage());
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            out.println("Erro de classe: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            out.println("Erro geral: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}

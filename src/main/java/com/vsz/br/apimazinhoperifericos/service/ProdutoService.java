/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vsz.br.apimazinhoperifericos.service;

import com.vsz.br.apimazinhoperifericos.dao.ProdutoDAO;
import com.vsz.br.apimazinhoperifericos.model.Produto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mateus
 */
public class ProdutoService {

    ProdutoDAO produtoDAO;
    
    public ProdutoService(){
     this.produtoDAO = new ProdutoDAO();   
    }

     public List<Produto> findAll() throws SQLException, ClassNotFoundException{
       
       return produtoDAO.findAll();
        
    }
}

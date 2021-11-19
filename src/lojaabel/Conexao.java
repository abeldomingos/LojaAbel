/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaabel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Tequerro
 */
public class Conexao {
    
     public static Connection conector(){
      
       java.sql.Connection  conexao = null;
       String driver ="com.mysql.jdbc.Driver";  
       String url ="jdbc:mysql://localhost:3306/bancoteste";
       String user ="root";
       String password="";
       
        try {
            Class.forName(driver);
            conexao =DriverManager.getConnection(url,user,password);
                System.out.println("sucesso na conexão");
            return conexao;
        
        } catch (Exception e) {
            System.out.println("Falha na Conexão"+e);
            return null;
        }
        
        
        
        
    }
        
        

    
    
    
}

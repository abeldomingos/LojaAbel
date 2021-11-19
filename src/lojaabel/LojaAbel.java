/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaabel;

/**
 *
 * @author Tequerro
 */
public class LojaAbel {
       java.sql.Connection  conexao = null;

    
    public static void main(String[] args) {
        // TODO code application logic here
       
        Cliente cliente = new Cliente(10, "Mingo", "Zango", 19);
//        cliente.cadastrar(cliente);
       // cliente.excluir(cliente);
        //cliente.editar(cliente);
        cliente.pesquisar(cliente);
        
       
    }

    public LojaAbel() {
     conexao = Conexao.conector();

    }
    
    
}

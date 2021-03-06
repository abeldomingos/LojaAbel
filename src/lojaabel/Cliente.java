
package lojaabel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import lojaabel.Telas.Telass;

public class Cliente {
    int id_cliente;
    String nome;
    String morada;
    int idade;
   Connection conexao = null;
   PreparedStatement pst =null;
   ResultSet rs = null;
    
   
    public Cliente(int id_cliente, String nome, String morada, int idade) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.morada = morada;
        this.idade = idade;
         conexao = Conexao.conector();
        
        
    }

    public Cliente(int id_cliente) {
        this.id_cliente = id_cliente;
        conexao = Conexao.conector();
    }


    
    
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

  public void cadastrar(Cliente cliente){
                String sql = "insert into cliente (id_cliente,nome, morada, idade) values(default,?,?,?)";

      try {
          //
          //PreparedStatement pst = conex.con.prepareStatement
          pst= conexao.prepareStatement(sql);
          pst.setString(1, cliente.getNome());
          pst.setString(2, cliente.getMorada());
          pst.setInt(3, cliente.getIdade());
          pst.executeUpdate();
          pst.close();
          System.out.println("Sucesso em cadastrar");

      } catch (Exception erro) {
          JOptionPane.showMessageDialog(null, "Falha Ao Inserir Dados\n"+erro);
          
          
      }
      
  }
  
  
  public void excluir(Cliente cliente) {
       String sql = "delete from cliente where id_cliente = ?";
      try {
          pst= conexao.prepareStatement(sql);
          pst.setInt(1,cliente.getId_cliente());
          int result = pst.executeUpdate();
          if (result >0) {
               JOptionPane.showMessageDialog(null, "Aten??ao","Sucess",JOptionPane.OK_OPTION);

          }      
          
      } catch (Exception erro) {
              JOptionPane.showMessageDialog(null, "Falha Ao Excluir Dados\n"+erro);
              
              System.out.println("erro"+erro);
      }
      
  
  }
  
  public void editar(Cliente cliente){
      String sql = "update cliente set nome=?, morada=? ,idade=? where id_cliente = ?";      
      
      try {
           pst= conexao.prepareStatement(sql);
           pst.setString(1, cliente.getNome());
           pst.setString(2, cliente.getMorada());
           pst.setInt(3, cliente.getIdade());
           pst.setInt(4, cliente.getId_cliente());       
           int result = pst.executeUpdate();
          if (result >0) {
               JOptionPane.showMessageDialog(null, "Aten??ao","Sucess",JOptionPane.OK_OPTION);

          }      
          
      } catch (Exception erro) {
          JOptionPane.showMessageDialog(null, "Falha Ao Alterar Dados\n"+erro);
          System.out.println("erro"+erro);
      }
  
  }
  
  public Cliente pesquisar(Cliente cliente){
     
       String sql = "select *from cliente where id_cliente =?";
      
      try {
           pst= conexao.prepareStatement(sql);
           pst.setInt(1, cliente.getId_cliente());
          rs= pst.executeQuery();
          if (rs.next()) {
              System.out.println("usuario existe");  
              String id= rs.getString("id_cliente");
              String nome = rs.getString("nome");
              String morada = rs.getString("morada");
              String idade = rs.getString("idade");
              //setar

              System.out.println("-------------------------");
              System.out.println("resultado da pesquisas");
              System.out.println("id:"+id); 
              System.out.println("nome:"+nome);
              System.out.println("morada :"+morada);
              System.out.println("idade:"+idade);
              Cliente cliente1 = new Cliente(Integer.parseInt(id), nome, morada, Integer.parseInt(idade));
              Cliente modelo;
              modelo =cliente1;
              return  modelo;
          } else {
              System.out.println("usuario n??o existe");
          }
          
      } catch (Exception erro) {
           JOptionPane.showMessageDialog(null, "Falha Ao Pesquisar Dados\n"+erro);
      }
      
     return null;
  }
  
   
}